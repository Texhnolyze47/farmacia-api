package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageRepository extends JpaRepository<ImageData,Long> {
}
