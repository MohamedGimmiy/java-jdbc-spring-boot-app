package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.model.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeJDBCRepo")
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/count")
	public int countEmployees() {
		return employeeRepo.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepo.findById(id);
	}
	
	
	@GetMapping
	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}

}
