package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return ResponseEntity.ok("Employee save");
    }
    @GetMapping
    public ResponseEntity<List<Employee>> listEmployee() {
        return ResponseEntity.ok(employeeService.allEmployee());
    }

}
