package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product saveProduct(Product product);

    Product getProduct(String productId);

    Product updateProduct(String productId, Product product);

    void deleteProduct(String productId);
}
