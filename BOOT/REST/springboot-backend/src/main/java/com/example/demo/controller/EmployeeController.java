package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.IEmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employee")
public class EmployeeController {

	private IEmployeeService employeeservice;

	public EmployeeController(IEmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}
	
	//build create REST API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		System.out.println(employee);
		
		ObjectMapper mapper = new ObjectMapper();
	    try {
	        String employeeJson = mapper.writeValueAsString(employee);
	        System.out.println("Received JSON payload: " + employeeJson);
	    } catch (JsonProcessingException e) {
	        System.err.println("Error processing JSON: " + e.getMessage());
	    }
		
		Employee emp = employeeservice.saveEmployee(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		
	}
	
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeservice.getAllEmployees();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long userId){
		
		Employee employee = employeeservice.getEmployeebyId(userId);
		
		
		return new ResponseEntity<>(employee,HttpStatus.OK);
		
		
	}
	
	@PutMapping("{id}")
	  public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long userId,@RequestBody Employee employee){
	   
	   employee.setId(userId);
       Employee updatedemployee =  employeeservice.updateEmployee(employee);
       return new ResponseEntity<>(updatedemployee, HttpStatus.OK);
       }
	
    @DeleteMapping("{id}")
    public  ResponseEntity<String> deleteEmployee(@PathVariable("id") Long userId1){
  	   employeeservice.deleteEmployeebyId(userId1);
       return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
     }
	
}
