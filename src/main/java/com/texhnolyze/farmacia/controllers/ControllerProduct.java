package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProduct {

    private ProductService productService;

    public ControllerProduct(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId){
        Product idProduct = productService.getProduct(productId);
        return ResponseEntity.ok(idProduct);
    }
}
