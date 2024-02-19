package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.IEmployeeRepository;
import com.example.demo.service.IEmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmployeeServiceImplementation implements IEmployeeService {
	
	private IEmployeeRepository employeerepository;

	public EmployeeServiceImplementation(IEmployeeRepository employeerepository) {
		super();
		this.employeerepository = employeerepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeerepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeerepository.findAll();
	}

	@Override
	public Employee getEmployeebyId(Long userId) {
		 Optional<Employee> optionalUser = employeerepository.findById(userId);
	        return optionalUser.get();
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		
		Employee existingemployee = getEmployeebyId(employee.getId());
		
		existingemployee.setFirstName(employee.getFirstName());
		existingemployee.setLastName(employee.getLastName());
		existingemployee.setEmail(employee.getEmail());
		
		Employee updatedgemployee = saveEmployee(existingemployee);
		
		return updatedgemployee;		
		
		
	}

	@Override
	public void deleteEmployeebyId(Long userId) {

		employeerepository.deleteById(userId);
		
	}

}
