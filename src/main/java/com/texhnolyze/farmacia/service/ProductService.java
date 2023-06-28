package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.config.S3Buckets;
import com.texhnolyze.farmacia.entities.Product;
import com.texhnolyze.farmacia.exceptions.ProductNotFoundException;
import com.texhnolyze.farmacia.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

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

    public void saveProduct(MultipartFile image, String name, String description, Double price, Integer quantity) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        productRepository.save(product);


        String imagePath = uploadImageProduct(image);
        product.setImage(imagePath);

        // Actualizar el producto en la base de datos con la ruta de la imagen
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

    public void uploadImageProduct(MultipartFile image) {
        try {
            String fileName = UUID.randomUUID().toString() + "-" + image.getOriginalFilename();

            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(s3Buckets.getCustomer())
                    .key(fileName)
                    .build();

            byte[] imageBytes = image.getBytes();
            InputStream inputStream = new ByteArrayInputStream(imageBytes);

            s3Service.putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, imageBytes.length));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] getImageProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ProductNotFoundException(
                "product with id [%s] not found".formatted(productId)
        ));

        var productImageId = "TODO";

        if (product.getImage().isBlank()) {
            throw new ProductNotFoundException(
                    "product with id [%s] image product not found".formatted(productId)
            );
        }

        byte[] productImage = s3Service.getObject(
                s3Buckets.getCustomer(),
                "image-product/%s/%s".formatted(productId, productImageId)
                );
        return productImage;
    }
}
