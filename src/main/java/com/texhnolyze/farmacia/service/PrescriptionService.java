package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Prescription;
import com.texhnolyze.farmacia.exceptions.PrescriptionNotFoundException;
import com.texhnolyze.farmacia.repository.PrescriptionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PrescriptionService {

    private final PrescriptionRepository prescriptionRepository;
    private final Logger logger = LoggerFactory.getLogger(PrescriptionService.class);

    public PrescriptionService(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

    public Prescription savePrescription(Prescription prescription) {
        //TODO: Añadir una verificacion en caso que no exista el de la medicina
        logger.info("Info del prescription - {} ", prescription.toString());
        return prescriptionRepository.save(prescription);
    }


    public Prescription getPrescription(Long idPrescription) { return prescriptionRepository.findById(idPrescription).orElseThrow(() -> new PrescriptionNotFoundException("Not found medication"));}

    public List<Prescription> getAllPrescription() {return prescriptionRepository.findAll();}

    public Prescription updatePrescription(Long idPrescription, Prescription prescription) {
        Optional<Prescription> notFoundPrescription = prescriptionRepository.findById(idPrescription);

        Prescription existPrescription = notFoundPrescription.get();
        existPrescription.setPatientId(prescription.getPatientId());
        existPrescription.setMedication(prescription.getMedication());
        existPrescription.setDosage(prescription.getDosage());
        existPrescription.setRefills(prescription.getRefills());
        existPrescription.setExpirationDate(prescription.getExpirationDate());

        return existPrescription;
    }

    public void deletePrescription(Long idPrescription) {
        prescriptionRepository.deleteById(idPrescription);
    }

}
