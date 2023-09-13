package com.project.Employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Employee.Repository.EmployeeRepository;
import com.project.Employee.entity.EmployeeEntity;
import com.project.Employee.model.Employee;
import com.project.Employee.service.EmployeeService;
@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
		boolean deleted=false;
		deleted=employeeService.deleteEmployee(id);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted", deleted);
		return ResponseEntity.ok(response);
	}
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
		Employee employee=null;
		employee=employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
			
		}
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
		employee=employeeService.updateEmployee(id, employee);
		return ResponseEntity.ok(employee);
	}
		
	
	
	

}
