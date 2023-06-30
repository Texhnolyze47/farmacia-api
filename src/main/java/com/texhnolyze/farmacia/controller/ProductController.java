package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok("Product added");
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() { return ResponseEntity.ok(productService.getAllProducts());}

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long productId){return ResponseEntity.ok(productService.getProduct(productId));}


    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, Product product) {
        return ResponseEntity.ok(productService.updateProduct(productId,product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Delete client");
    }


}
