package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long employeeId);

    List<Employee> getAllEmployee();

    Employee updateEmployee(Long employeeId, Employee employee);

    void deleteEmployee(Long employeeId);
}
