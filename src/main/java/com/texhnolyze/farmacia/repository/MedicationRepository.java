package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication,Integer> {
}
