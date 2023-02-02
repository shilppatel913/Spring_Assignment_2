package com.aster.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aster.app.entity.Employee;
import com.aster.app.repo.EmployeeRepo;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/user")
	public ResponseEntity<String> commonResourse() {
	String msg = "Welcome user..! It's a non secured resource";
	return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/secure/user")
	public ResponseEntity<String> securedResourse() {
	String msg = "It's a secured resource";
	return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<String> admin() {
	return new ResponseEntity<String>("Welcome to Masai App for Admin", HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/user")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
		Employee emp=this.employeeRepo.save(employee);
		return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
	}
}
