package com.global.hr.reposatory.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@Component
@Qualifier("employeeJDBCRepo")
public class EmployeeJDBCRepo implements EmployeeRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public int count() {
		
		return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM EMPLOYEE", Integer.class);
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID = ?", new Object[] {id} ,
				new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return  jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
	
	}

	@Override
	public int insert(Employee employee) {
		
		return jdbcTemplate.update("INSERT INTO EMPLOYEE VALUES (?,?,?)",
				new Object[] {employee.getId(),employee.getName(),employee.getSalary()});
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("UPDATE EMPLOYEE SET NAME =?, SALARY = ?",
				new Object[] {employee.getName(),employee.getSalary()});	
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("DELETE FROM EMPLOYEE WHERE ID=?",
				new Object[] {id});	
	}

	@Override
	public Employee findByNameAndSalary(String name, Double salary) {
		// TODO Auto-generated method stub
		return null;
	}

}
