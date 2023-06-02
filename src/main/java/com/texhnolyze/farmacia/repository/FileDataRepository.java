package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends JpaRepository<FileData, Long> {
}
