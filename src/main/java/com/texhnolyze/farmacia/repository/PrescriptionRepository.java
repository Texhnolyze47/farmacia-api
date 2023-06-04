package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {

}
