package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Sale;
import com.texhnolyze.farmacia.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class ControllerSale {
    private SaleService saleService;


    public ControllerSale(SaleService saleService) {
        this.saleService = saleService;
    }
    @PostMapping
    public ResponseEntity<Sale> addSale(@RequestBody Sale sale){
        Sale newSale = saleService.addSale(sale);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSale);
    }
    @GetMapping
    public ResponseEntity<List<Sale>> AllSale(){
         List<Sale> allSales = saleService.getAllSales();
        return ResponseEntity.ok(allSales);
    }
}
