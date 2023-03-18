package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.exception.EmployeeNotFoundException;
import com.texhnolyze.farmacia.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long employeeId) {
        employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("id is not found on server" + employeeId))
        return null;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
