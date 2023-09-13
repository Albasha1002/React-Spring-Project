package com.project.Employee.service;

import java.util.List;

import com.project.Employee.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);
	
	List<Employee> getAllEmployee();

	boolean deleteEmployee(Long id);

	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Long id, Employee employee);
	
	
	
	
	
	

}
