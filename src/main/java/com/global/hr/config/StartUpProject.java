package com.global.hr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.model.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@Component
public class StartUpProject implements CommandLineRunner {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("DROP TABLE IF EXISTS EMPLOYEE");
		jdbcTemplate.execute("CREATE TABLE EMPLOYEE(ID SERIAL, NAME VARCHAR(255), SALARY NUMERIC (15,2))");
		
		if(employeeRepo.count() == 0) {
			employeeRepo.insert(new Employee(20L,"mohamed",1200.0));
			employeeRepo.insert(new Employee(30L,"ahmed",1300.0));
			employeeRepo.insert(new Employee(40L,"mahmoud",1400.0));
			employeeRepo.insert(new Employee(50L,"salem",1500.0));
		}
		
	}
	
}
