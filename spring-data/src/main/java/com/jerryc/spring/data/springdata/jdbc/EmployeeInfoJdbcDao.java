package com.jerryc.spring.data.springdata.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jerryc.spring.data.springdata.entity.EmployeeInfo;
import com.jerryc.spring.data.springdata.entity.Person;

@Repository   // We could have said @Component, BUT we want to take advantage of @Repository
public class EmployeeInfoJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;  // Creates connection to DB and facilitates queries
	
	public List<EmployeeInfo> findByDeptId(int id) {
		return jdbcTemplate.query(
		"select e.first_name, d.department_name, d.location from departments d, employees e where d.department_id=? and e.department_id=?",
		new Object[]{id,id},
		new BeanPropertyRowMapper(EmployeeInfo.class));
	}
}
