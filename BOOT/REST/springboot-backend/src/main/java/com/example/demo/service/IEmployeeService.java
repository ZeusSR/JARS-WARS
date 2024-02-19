package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface IEmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Employee getEmployeebyId(Long userId);
	
	Employee updateEmployee(Employee employee);
	
	void deleteEmployeebyId(Long userId);
}
