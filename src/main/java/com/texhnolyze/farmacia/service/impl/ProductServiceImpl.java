package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.exception.ProductNotFoundException;
import com.texhnolyze.farmacia.repositories.ProductRepository;
import com.texhnolyze.farmacia.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    @Override
    public Product updateProduct(String productId,Product product) {
        Optional<Product> notFoundProduct = productRepository.findById(productId);

        if (notFoundProduct.isEmpty()){
            return null;
        }
        Product existProduct = notFoundProduct.get();
        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());
        existProduct.setPrice(product.getPrice());
        existProduct.setQuantity(product.getQuantity());

        return productRepository.save(existProduct);
    }


}
