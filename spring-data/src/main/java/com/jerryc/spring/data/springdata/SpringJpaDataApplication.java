package com.jerryc.spring.data.springdata;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jerryc.spring.data.springdata.entity.Person;
import com.jerryc.spring.data.springdata.jpa.PersonJpaRepository;

//@SpringBootApplication
public class SpringJpaDataApplication implements CommandLineRunner { // requires run() method
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDataApplication.class, args);
	}

	@Override  // Launched after the Application Context is ready
	public void run(String... args) throws Exception {
		
		try {
			// RETRIEVE - GET A SPECIFIC PERSON
			logger.info("Get person with id 1-> {} ", repository.findById(1));
				
			// CREATE - PUT - insert
			Person personForInsert = new Person("Tara", "Paris", new Date());
			logger.info("Insert person -> {} ", repository.insert(personForInsert));
			
			// UPDATE - POST - update
			Person personForUpdate = new Person(3, "Pieter", "Rome", new Date());
			logger.info("Update person with 3-> {} ", repository.update(personForUpdate));
			
			// DELETE - DELETE A SPECIFIC PERSON
			int id = 1;
			repository.deleteById(id);
			logger.info("Delete person with id {}", id);
			
			// RETRIEVE - GET ALL
			logger.info("Get all persons -> {} ", repository.findAll());
			
		} catch (Exception e) {
			logger.error("CRUD operation failed - {}", e.getMessage());
		}
		
		/*
		// **** GPC - Select with join of 2 tables Departments and Employees ****
		logger.info("Dept 1 employees -> {} ", employeeInfoDao.findByDeptId(1));
		*/
	}
}
