package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Manufacturer;
import com.texhnolyze.farmacia.exceptions.ManufacturerNotFoundException;
import com.texhnolyze.farmacia.repository.ManufacturerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    public List<Manufacturer> getAllManufacturers() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getManufacturer(Long manufacturerId) {return manufacturerRepository.findById(manufacturerId).orElseThrow(() -> new ManufacturerNotFoundException("Not manufacturer not found"));}


    public Manufacturer updateManufacturer(Long manufacturerId, Manufacturer manufacturer) {
        Optional<Manufacturer> notFoundManufacturer = manufacturerRepository.findById(manufacturerId);

        Manufacturer existManufacturer = notFoundManufacturer.get();
        existManufacturer.setName(manufacturer.getName());
        existManufacturer.setMedications(manufacturer.getMedications());

        return existManufacturer;
    }

    public void deleteManufacturer(Long manufacturerId) {
        manufacturerRepository.deleteById(manufacturerId);
    }

}
