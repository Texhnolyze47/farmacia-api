package com.texhnolyze.farmacia.controller;

import com.texhnolyze.farmacia.entities.Employee;
import com.texhnolyze.farmacia.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeControllerTest {

    private final EmployeeService employeeService = Mockito.mock(EmployeeService.class);
    private final EmployeeController employeeController = new EmployeeController(employeeService);

    @Test
    public void testAddEmployee() {
        Employee employee = new Employee();
        ResponseEntity<String> response = employeeController.addEmployee(employee);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Employee save", response.getBody());
        Mockito.verify(employeeService).saveEmployee(employee);
    }

    @Test
    public void testListEmployee() {
        List<Employee> employees = new ArrayList<>();
        Mockito.when(employeeService.allEmployee()).thenReturn(employees);
        ResponseEntity<List<Employee>> response = employeeController.listEmployee();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employees, response.getBody());
    }

    @Test
    public void testGetEmployee() {
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployee(1L)).thenReturn(employee);
        ResponseEntity<Employee> response = employeeController.getEmployee(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(employee, response.getBody());
    }



    @Test
    public void testDeleteEmployee() {
        ResponseEntity<String> response = employeeController.deleteEmployee(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Employee delete", response.getBody());
        Mockito.verify(employeeService).deleteEmployee(1L);
    }
}
