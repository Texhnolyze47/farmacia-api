package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.exception.ProductNotFoundException;
import com.texhnolyze.farmacia.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        String randomProductId = UUID.randomUUID().toString();
        product.setId(randomProductId);
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(
                "id is not found on server" + productId));
    }


}
