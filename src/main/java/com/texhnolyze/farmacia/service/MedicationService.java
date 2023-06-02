package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Manufacturer;
import com.texhnolyze.farmacia.entities.Medication;
import com.texhnolyze.farmacia.exceptions.MedicationNotFoundException;
import com.texhnolyze.farmacia.repository.ManufacturerRepository;
import com.texhnolyze.farmacia.repository.MedicationRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicationService {
    private final MedicationRepository medicationRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final Logger logger = LoggerFactory.getLogger(MedicationService.class);

    public MedicationService(MedicationRepository medicationRepository, ManufacturerRepository manufacturerRepository) {
        this.medicationRepository = medicationRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    public void saveMedication(Medication medication){
        logger.info("Service - medication");
        Manufacturer manufacturer = medication.getManufacturer();
        manufacturerRepository.save(manufacturer);
        medicationRepository.save(medication);
    }

    public Medication getMedication(Integer idMedication) { return medicationRepository.findById(idMedication).orElseThrow(() -> new MedicationNotFoundException("Not found medication"));}

    public List<Medication> getAllMedications() {return medicationRepository.findAll();}

    public Medication updateMedication(Integer idMedication, Medication medication) {
        Optional<Medication> notFoundMedication = medicationRepository.findById(idMedication);

        Medication existMedication = notFoundMedication.get();
        existMedication.setName(medication.getName());
        existMedication.setDescription(medication.getDescription());
        existMedication.setManufacturer(medication.getManufacturer());
        existMedication.setPrice(medication.getPrice());
        existMedication.setQuantity(medication.getQuantity());

        return existMedication;
    }

    public void deleteMedication(Integer idMedication) {
        medicationRepository.deleteById(idMedication);
    }
}
