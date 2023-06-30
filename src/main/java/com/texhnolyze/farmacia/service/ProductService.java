package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.config.S3Buckets;
import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.exceptions.ProductNotFoundException;
import com.texhnolyze.farmacia.repository.ProductRepository;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final S3Service s3Service;
    private final S3Buckets s3Buckets;

    public ProductService(ProductRepository productRepository, S3Service s3Service, S3Buckets s3Buckets) {
        this.productRepository = productRepository;
        this.s3Service = s3Service;
        this.s3Buckets = s3Buckets;
    }

    public void saveProduct(Product product) {
        productRepository.save(product);


    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long productId){
        return productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("Client not found"));
    }

    public Product updateProduct(Long productId, Product product) {
        Optional<Product> notFoundProduct = productRepository.findById(productId);

        Product existProduct = notFoundProduct.get();
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());

        return existProduct;
    }

    public void deleteProduct(Long clientId) {
        productRepository.deleteById(clientId);
    }


}
