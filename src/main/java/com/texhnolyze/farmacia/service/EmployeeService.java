package com.texhnolyze.farmacia.service;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.repository.EmployeeRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRespository employeeRespository;

    public EmployeeService(EmployeeRespository employeeRespository) {
        this.employeeRespository = employeeRespository;
    }

    public void saveEmployee(Employee employee){
        employeeRespository.save(employee);
    }

    public List<Employee> allEmployee() {
        return employeeRespository.findAll();
    }


    public Employee getEmployee(Long employeeId) {
        //Todo: add exception
        return employeeRespository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public void deleteEmployee(Long employeeId) {
        employeeRespository.deleteById(employeeId);
    }

    public void updateEmployee(Long employeeId, Employee employee) {
        Employee changeEmployee = employeeRespository.findById(employeeId).orElseThrow(() -> new RuntimeException("Employee not found"));
        changeEmployee.setName(employee.getName());
        changeEmployee.setEmail(employee.getEmail());
        changeEmployee.setPhone(employee.getPhone());
        changeEmployee.setPosition(employee.getPosition());
        changeEmployee.setSalary(employee.getSalary());
        employeeRespository.save(changeEmployee);
    }
}
