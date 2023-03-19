package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Sale;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class ControllerSale {

    public ResponseEntity<Sale> addSale(@RequestBody Sale sale){
        return null;
    }
}
