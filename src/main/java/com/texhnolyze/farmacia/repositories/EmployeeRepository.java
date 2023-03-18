package com.texhnolyze.farmacia.repositories;

import com.texhnolyze.farmacia.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
