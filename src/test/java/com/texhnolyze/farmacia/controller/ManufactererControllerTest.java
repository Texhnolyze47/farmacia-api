package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Manufacturer;
import com.texhnolyze.farmacia.service.ManufacturerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManufactererControllerTest {


    private final ManufacturerService manufacturerService = Mockito.mock(ManufacturerService.class);
    private final ManufactererController manufactererController = new ManufactererController(manufacturerService);

    @Test
    public void testAddManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        ResponseEntity<String> response = manufactererController.addManufacturer(manufacturer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Manufacturer save", response.getBody());
        Mockito.verify(manufacturerService).saveManufacturer(manufacturer);
    }

    @Test
    public void testGetManufacturers() {
        List<Manufacturer> manufacturers = new ArrayList<>();
        Mockito.when(manufacturerService.getAllManufacturers()).thenReturn(manufacturers);
        ResponseEntity<List<Manufacturer>> response = manufactererController.getManufacturers();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(manufacturers, response.getBody());
    }

    @Test
    public void testGetManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        Mockito.when(manufacturerService.getManufacturer(1L)).thenReturn(manufacturer);
        ResponseEntity<Manufacturer> response = manufactererController.getManufacturer(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(manufacturer, response.getBody());
    }

    @Test
    public void testUpdateManufacturer() {
        Manufacturer manufacturer = new Manufacturer();
        Mockito.when(manufacturerService.updateManufacturer(1L, manufacturer)).thenReturn(manufacturer);
        ResponseEntity<Manufacturer> response = manufactererController.updateManufacturer(1L, manufacturer);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(manufacturer, response.getBody());
    }

    @Test
    public void testDeleteManufacturer() {
        ResponseEntity<String> response = manufactererController.deleteManufacturer(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Delete manufacturer", response.getBody());
        Mockito.verify(manufacturerService).deleteManufacturer(1L);
    }
}
