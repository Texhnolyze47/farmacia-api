package com.texhnolyze.farmacia.controller;


import com.texhnolyze.farmacia.entities.Medication;
import com.texhnolyze.farmacia.service.MedicationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medications")
@CrossOrigin("*")
public class MedicationController {

    private final MedicationService medicationService;

    public MedicationController(MedicationService medicationService) {
        this.medicationService = medicationService;
    }

    @PostMapping
    public ResponseEntity<String> addMedication(@Validated @RequestBody Medication request) {
        medicationService.saveMedication(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Medication added");
    }

    @GetMapping
    public ResponseEntity<List<Medication>> getAllMedications() {
        List<Medication> allMedications = medicationService.getAllMedications();
        return ResponseEntity.ok(allMedications);
    }

    @GetMapping("/{medicationId}")
    public ResponseEntity<Medication> getMedication(@PathVariable Integer medicationId) {
        Medication existMedication = medicationService.getMedication(medicationId);
        return ResponseEntity.ok(existMedication);
    }

    @PutMapping("/{medicationId}")
    public ResponseEntity<Medication> updateMedication(@PathVariable Integer medicationId, Medication medication) {
        Medication updateMedicine = medicationService.updateMedication(medicationId, medication);
        return ResponseEntity.ok(updateMedicine);
    }

    @DeleteMapping("/{medicationId}")
    public ResponseEntity<String> deleteMedication(@PathVariable Integer medicationId) {
        medicationService.deleteMedication(medicationId);
        return ResponseEntity.ok("Item deleted");
    }
}
