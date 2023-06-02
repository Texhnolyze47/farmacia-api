package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Manufacturer;
import com.texhnolyze.farmacia.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
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
}
