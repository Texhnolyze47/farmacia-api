package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Prescription;
import com.texhnolyze.farmacia.service.PrescriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prescription")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }
    @PostMapping
    public ResponseEntity<Prescription> addPrescription (@RequestBody Prescription prescription) {
        Prescription newPrescription = prescriptionService.savePrescription(prescription);
        return ResponseEntity.ok(newPrescription);
    }

    @GetMapping
    public ResponseEntity<List<Prescription>> getAllPrescription() {
        return ResponseEntity.ok(prescriptionService.getAllPrescription());
    }

    @GetMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> getPrescription (@PathVariable Long prescriptionId) {
        return ResponseEntity.ok(prescriptionService.getPrescription(prescriptionId));
    }

    @PutMapping("/{prescriptionId}")
    public ResponseEntity<Prescription> updatePrescription(@PathVariable Long prescriptionId, Prescription prescription) {
        return ResponseEntity.ok(prescriptionService.updatePrescription(prescriptionId, prescription));
    }

    @DeleteMapping("/{prescriptionId}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long prescriptionId) {
        prescriptionService.deletePrescription(prescriptionId);
        return ResponseEntity.ok("Prescription deleted");
    }
}
