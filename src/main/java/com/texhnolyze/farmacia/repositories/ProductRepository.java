package com.texhnolyze.farmacia.repositories;

import com.texhnolyze.farmacia.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
