package com.texhnolyze.farmacia.controllers;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.entities.Sale;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class ControllerEmployee {

    private final EmployeeService employeeService;

    public ControllerEmployee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployee();
        return ResponseEntity.ok(allEmployees);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId){
        Employee idEmployee = employeeService.getEmployee(employeeId);
        return ResponseEntity.ok(idEmployee);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, Employee employee){
        Employee updateEmployee = employeeService.updateEmployee(employeeId,employee);

        if (updateEmployee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Se borro el product con el id " + employeeId);
    }
}
