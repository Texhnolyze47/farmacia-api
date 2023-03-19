package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.exception.EmployeeNotFoundException;
import com.texhnolyze.farmacia.repositories.EmployeeRepository;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        return employeeRepository.findById(employeeId).orElseThrow(() -> new EmployeeNotFoundException("id is not found on server" + employeeId));
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }
}
