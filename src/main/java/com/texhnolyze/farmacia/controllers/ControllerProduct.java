package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ControllerProduct {

    private final ProductService productService;

    public ControllerProduct(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        List<Product> allProducts = productService.getAllProducts();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid Product product){
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }


    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId){
        Product idProduct = productService.getProduct(productId);
        return ResponseEntity.ok(idProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable String productId, @RequestBody Product product){
        Product updateProduct = productService.updateProduct(productId, product);
        if (updateProduct == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateProduct);
    }

    @DeleteMapping("/{productId}")
    public  ResponseEntity<String> deleteProduct(@PathVariable String productId ){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Se borro el product con el id " + productId);
    }
}
