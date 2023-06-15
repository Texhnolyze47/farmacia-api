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


}
