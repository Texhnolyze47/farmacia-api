package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProduct {

    private ProductServiceImpl productService;

    public ControllerProduct(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product){
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

    }
}
