package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductControllerTest {

    private final ProductService productService = Mockito.mock(ProductService.class);
    private final ProductController productController = new ProductController(productService);

    @Test
    public void testAddProduct() {
        Product product = new Product();
        ResponseEntity<String> response = productController.addProduct(product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Product added", response.getBody());
        Mockito.verify(productService).saveProduct(product);
    }

    @Test
    public void testGetProducts() {
        List<Product> products = new ArrayList<>();
        Mockito.when(productService.getAllProducts()).thenReturn(products);
        ResponseEntity<List<Product>> response = productController.getProducts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    public void testGetProduct() {
        Product product = new Product();
        Mockito.when(productService.getProduct(1L)).thenReturn(product);
        ResponseEntity<Product> response = productController.getProduct(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testUpdateProduct() {
        Product product = new Product();
        Mockito.when(productService.updateProduct(1L, product)).thenReturn(product);
        ResponseEntity<Product> response = productController.updateProduct(1L, product);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    public void testDeleteProduct() {
        ResponseEntity<String> response = productController.deleteProduct(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Delete client", response.getBody());
        Mockito.verify(productService).deleteProduct(1L);
    }
}
