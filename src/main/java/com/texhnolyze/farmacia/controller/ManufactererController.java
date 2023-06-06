package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Manufacturer;
import com.texhnolyze.farmacia.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/manufacturer")
public class ManufactererController {

    private final ManufacturerService manufacturerService;

    public ManufactererController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<String> addManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.saveManufacturer(manufacturer);
        return ResponseEntity.ok("Manufacturer save");
    }

    @GetMapping
    public ResponseEntity<List<Manufacturer>> getManufacturers() {
        return  ResponseEntity.ok(manufacturerService.getAllManufacturers());
    }

    @GetMapping("/{manufacturerId}")
    public ResponseEntity<Manufacturer> getManufacturer(@PathVariable Long manufacturerId) {
        return ResponseEntity.ok(manufacturerService.getManufacturer(manufacturerId));
    }

    @PutMapping("/{manufacturerId}")
    public ResponseEntity<Manufacturer> updateManufacturer(@PathVariable Long manufacturerId, Manufacturer manufacturer) {
        return ResponseEntity.ok(manufacturerService.updateManufacturer(manufacturerId,manufacturer));
    }

    @DeleteMapping("/{manufacturerId}")
    public ResponseEntity<String> deleteManufacturer(@PathVariable Long manufacturerId) {
        manufacturerService.deleteManufacturer(manufacturerId);
        return ResponseEntity.ok("Delete manufacturer");
    }
}
