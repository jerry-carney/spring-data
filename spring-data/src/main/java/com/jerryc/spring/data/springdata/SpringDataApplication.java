package com.jerryc.spring.data.springdata;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jerryc.spring.data.springdata.entity.Person;
import com.jerryc.spring.data.springdata.jdbc.EmployeeInfoJdbcDao;
import com.jerryc.spring.data.springdata.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner { // requires run() method
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personDao;
	
	@Autowired
	EmployeeInfoJdbcDao employeeInfoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override  // Launched after the Application Context is ready
	public void run(String... args) throws Exception {
		
		// RETRIEVE - GET - select
		logger.info("Get all people -> {} ", personDao.findAll());
		logger.info("Get person with id 10001-> {} ", personDao.findById(10001));
		
		// DELETE - DELETE - delete
		logger.info("Delete person with id 10001-> {} ", personDao.deleteById(10001));
		
		// CREATE - PUT - insert
		Person personForInsert = new Person(10008, "Tara", "Paris", new Date());
		logger.info("Insert person with id 10008-> {} ", personDao.insert(personForInsert));
		
		// UPDATE - POST - update
		Person personForUpdate = new Person(10003, "Pieter", "Rome", new Date());
		logger.info("Update person with id 10003-> {} ", personDao.update(personForUpdate));
		
		// After the above CRUD operations, see what Person table looks like now
		logger.info("Get all people -> {} ", personDao.findAll());
		
		
		// **** GPC - Select with join of 2 tables Departments and Employees ****
		logger.info("Dept 1 employees -> {} ", employeeInfoDao.findByDeptId(1));
		
	}
}
