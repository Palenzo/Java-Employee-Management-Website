package com.employee.crud.service;

import com.employee.crud.entity.Employee;
import com.employee.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    @Override
    public Employee updateEmployeeById(Long id, Employee employee) {
        Optional<Employee> employeel = employeeRepository.findById(id);
        if (employeel.isPresent()) {
            Employee originalEmployee = employeel.get();
            if (employee.getName() != null && !"".equalsIgnoreCase(employee.getName())) {
                originalEmployee.setName(employee.getName());
            }
            if (employee.getDoj() != null && !"".equalsIgnoreCase(employee.getDoj())) {
                originalEmployee.setDoj(employee.getDoj());
            }
            if (employee.getSalary() != 0) {
                originalEmployee.setSalary(employee.getSalary());
            }
            if (employee.getStatus() != -1) {
                originalEmployee.setStatus(employee.getStatus());
            }
            return employeeRepository.save(originalEmployee);
        }
        return null;
    }

    @Override
    public String deleteEmployeeById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        }
        return "Employee not found";
    }
}
