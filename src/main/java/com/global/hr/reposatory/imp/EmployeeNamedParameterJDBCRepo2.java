package com.global.hr.reposatory.imp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.global.hr.mapper.EmployeeMapper;
import com.global.hr.model.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@Component
@Primary
@Qualifier("employeeNamedParameterJDBCRepo2")
public class EmployeeNamedParameterJDBCRepo2 implements EmployeeRepo {
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	
	@Override
	public int count() {
		return 0;
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID = :id",
				new MapSqlParameterSource("id",id) ,
				new EmployeeMapper());
	}
	
	@Override
	public Employee findByNameAndSalary(String name, Double salary) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name", name);
		map.addValue("salary", "salary");
		return namedParameterJdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE WHERE ID = :id AND SALARY = :salary",
				map ,
				new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		//return  jdbcTemplate.query("SELECT * FROM EMPLOYEE", new EmployeeMapper());
		return null;
	
	}

	@Override
	public int insert(Employee employee) {
		
		return namedParameterJdbcTemplate.update("INSERT INTO EMPLOYEE VALUES (:id,:name,:salary)",
				new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int update(Employee employee) {
		// TODO Auto-generated method stub
		return namedParameterJdbcTemplate.update("UPDATE EMPLOYEE SET NAME =:name, SALARY = :salary",
				new BeanPropertySqlParameterSource(employee));
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;	
	}

}
