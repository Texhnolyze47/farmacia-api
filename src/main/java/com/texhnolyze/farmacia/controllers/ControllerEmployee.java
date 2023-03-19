package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.entities.Sale;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class ControllerEmployee {

    private EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmployees);
    }

    public ResponseEntity<Employee> getEmployee(@PathVariable Long EmployeeId){
        Employee idEmployee = employeeService.getEmployee(EmployeeId);
        return ResponseEntity.ok(idEmployee);
    }
}
