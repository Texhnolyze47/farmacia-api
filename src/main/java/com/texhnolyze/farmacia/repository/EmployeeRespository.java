package com.texhnolyze.farmacia.repository;

import com.texhnolyze.farmacia.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRespository  extends JpaRepository<Employee, Long> {
}
