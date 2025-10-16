package com.employee.crud.controller;

import com.employee.crud.entity.Employee;
import com.employee.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.*;

@CrossOrigin(origins = "http://localhost")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
        Employee saved = employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = "status", required = false) Integer status) {
        List<Employee> all = employeeService.fetchAllEmployees();
        if (status != null) {
            List<Employee> filtered = new ArrayList<>();
            for (Employee e : all) {
                if (e.getStatus() != null && e.getStatus().equals(status)) {
                    filtered.add(e);
                }
            }
            return ResponseEntity.ok(filtered);
        }
        return ResponseEntity.ok(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        Employee e = employeeService.getEmployeeById(id);
        if (e == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployeeById(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee updated = employeeService.updateEmployeeById(id, employee);
        if (updated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,String>> deleteEmployee(@PathVariable("id") Long id) {
        String result = employeeService.deleteEmployeeById(id);
        Map<String,String> resp = new HashMap<>();
        if ("Employee deleted successfully".equals(result)) {
            resp.put("message", result);
            return ResponseEntity.ok(resp);
        }
        resp.put("message", result);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
    }

}
