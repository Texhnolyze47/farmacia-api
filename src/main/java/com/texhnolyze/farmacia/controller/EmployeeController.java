package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin("*")
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


    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeId){
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long employeeId, Employee employee){
        employeeService.updateEmployee(employeeId,employee);
        return ResponseEntity.ok("Employee update");
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee delete");
    }
}


