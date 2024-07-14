package com.employee.crud.service;
import com.employee.crud.entity.Employee;
import java.util.*;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> fetchAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployeeById(Long id, Employee employee);
	String deleteEmployeeById(Long id);
	


}
