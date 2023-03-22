package com.texhnolyze.farmacia.service.impl;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.exception.EmployeeNotFoundException;
import com.texhnolyze.farmacia.repositories.EmployeeRepository;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

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

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Optional<Employee> notFoundEmployee = employeeRepository.findById(employeeId);
        if (notFoundEmployee.isEmpty()){
            return null;
        }
        Employee existEmployee = notFoundEmployee.get();
        existEmployee.setName(employee.getName());
        existEmployee.setEmail(employee.getEmail());
        existEmployee.setNumber(employee.getNumber());
        existEmployee.setJob(employee.getJob());

        return employeeRepository.save(existEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.findById(employeeId);
    }
}
