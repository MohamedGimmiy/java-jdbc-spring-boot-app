package com.global.hr.reposatory;

import java.util.List;

import com.global.hr.model.Employee;

public interface EmployeeRepo {
	int count ();
	Employee findById(Long id);
	
	public Employee findByNameAndSalary(String name,Double salary);

	List<Employee> findAll();
	int insert(Employee employee);
	int update(Employee employee);
	int delete(Long id);
}
