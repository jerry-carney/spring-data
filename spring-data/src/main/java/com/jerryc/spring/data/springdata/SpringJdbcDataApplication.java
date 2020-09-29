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

@SpringBootApplication
public class SpringJdbcDataApplication implements CommandLineRunner { // requires run() method
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao personDao;
	
	@Autowired
	EmployeeInfoJdbcDao employeeInfoDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDataApplication.class, args);
	}

	@Override  // Launched after the Application Context is ready
	public void run(String... args) throws Exception {
		
		// RETRIEVE - GET - select
		logger.info("Get all people -> {} ", personDao.findAll());
		logger.info("Get person with id 1-> {} ", personDao.findById(1));
		
		// DELETE - DELETE - delete
		logger.info("Delete person with id 1-> {} ", personDao.deleteById(1));
		
		// CREATE - PUT - insert
		Person personForInsert = new Person("Tara", "Paris", new Date());
		logger.info("Insert new person Tara -> {} ", personDao.insert(personForInsert));
		
		// UPDATE - POST - update
		Person personForUpdate = new Person(3, "Pieter", "Rome", new Date());
		logger.info("Update person Peiter with id 3-> {} ", personDao.update(personForUpdate));
		
		// After the above CRUD operations, see what Person table looks like now
		logger.info("Get all people -> {} ", personDao.findAll());
		
		
		// **** GPC - Select with join of 2 tables Departments and Employees ****
		logger.info("JOIN: Department 1 employees -> {} ", employeeInfoDao.findByDeptId(1));
		
	}
}
