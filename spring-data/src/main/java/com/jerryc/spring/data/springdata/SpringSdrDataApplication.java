package com.jerryc.spring.data.springdata;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jerryc.spring.data.springdata.entity.Person;
import com.jerryc.spring.data.springdata.sdr.MultiPersonDbOpersOneTrans;
import com.jerryc.spring.data.springdata.sdr.PersonSpringDataRepository;

//@SpringBootApplication
public class SpringSdrDataApplication implements CommandLineRunner { // requires run() method
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSdrDataApplication.class, args);
	}

	@Override  // Launched after the Application Context is ready
	public void run(String... args) throws Exception {
		
		try {
			
//			MultiPersonDbOpersOneTrans multiPersonDbOpersOneTrans = new MultiPersonDbOpersOneTrans(repository);
//			
//			multiPersonDbOpersOneTrans.doMultiPersonCrudOpers();
			//multiPersonDbOpersOneTrans.insertPerson("Tara", "Paris", new Date());
			//multiPersonDbOpersOneTrans.deletePerson(15);
			//multiPersonDbOpersOneTrans.getAllPersons();
			
//			// RETRIEVE - GET - select
//			logger.info("Get all people -> {} ", repository.findAll());
//			
//			// RETRIEVE - GET A SPECIFIC PERSON
//			logger.info("Get person with id 1-> {} ", repository.findById(1));
//				
//			// CREATE - PUT - insert
//			Person personForInsert = new Person("Tara", "Paris", new Date());
//			logger.info("Insert person -> {} ", repository.save(personForInsert));
//			
//			// UPDATE - POST - update
//			Person personForUpdate = new Person(3, "Pieter", "Rome", new Date());
//			logger.info("Update person with 3-> {} ", repository.save(personForUpdate));
//			
//			// DELETE - DELETE A SPECIFIC PERSON
//			int id = 1;
//			repository.deleteById(id);
//			logger.info("Delete person with id {}", id);
//			
//			// RETRIEVE - GET ALL
//			logger.info("Get all persons -> {} ", repository.findAll());
			
			// RETRIEVE - GET - select
			logger.info("Get all people -> {} ", repository.findAll());
			logger.info("Get person with id 1-> {} ", repository.findById(1));
			
			// DELETE - DELETE - delete
			repository.deleteById(1);
			logger.info("Delete person with id 1-> {} ");
			
			// CREATE - PUT - insert
			Person personForInsert = new Person("Tara", "Paris", new Date());
			logger.info("Insert new person Tara -> {} ", repository.save(personForInsert));
			
			// UPDATE - POST - update
			Person personForUpdate = new Person(3, "Pieter", "Rome", new Date());
			logger.info("Update person Peiter with id 3-> {} ", repository.save(personForUpdate));
			
			// After the above CRUD operations, see what Person table looks like now
			logger.info("Get all people -> {} ", repository.findAll());
			
			
		} catch (Exception e) {
			logger.error("CRUD operation failed - {}", e.getMessage());
		}
	}
}
