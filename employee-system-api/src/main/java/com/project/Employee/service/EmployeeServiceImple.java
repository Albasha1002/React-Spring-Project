package com.project.Employee.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Employee.Repository.EmployeeRepository;
import com.project.Employee.entity.EmployeeEntity;
import com.project.Employee.model.Employee;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class EmployeeServiceImple implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	

	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity =new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		employeeRepository.save(employeeEntity);
		return employee;
		
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
List<EmployeeEntity> employeeEntities=employeeRepository.findAll();
		
		List<Employee> employees=employeeEntities
				                 .stream()
				                 .map(emp-> new Employee(
				                		 emp.getId(),
				                		 emp.getFirstName(),
				                		 emp.getLastName(),
				                		 emp.getEmailId()))
				                 .collect(Collectors
				                		 .toList());
		
		return employees;
	}


	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub\
		EmployeeEntity employee=employeeRepository.findById(id).get();
		
		employeeRepository.delete(employee);
		return true;
	}


	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		EmployeeEntity employeeEntity=employeeRepository.findById(id).get();
		Employee employee=new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}


	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		
			// TODO Auto-generated method stub
		    EmployeeEntity employeeEntity=employeeRepository.findById(id).get();	
		    
		    employeeEntity.setEmailId(employee.getEmailId());
		    employeeEntity.setFirstName(employee.getFirstName());
		    employeeEntity.setLastName(employee.getLastName());
		    
		    employeeRepository.save(employeeEntity);
			
			return employee;
	}
	
}
