package com.jerryc.spring.data.springdata.sdr;

import java.util.Date;

//import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;

import com.jerryc.spring.data.springdata.entity.Person;


public class MultiPersonDbOpersOneTrans {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	private PersonSpringDataRepository repos = null;
	
	public MultiPersonDbOpersOneTrans(PersonSpringDataRepository repository) {
		super();
		this.repos = repository;
		
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void doMultiPersonCrudOpers() {
		try {
			//getAllPersons();
			insertPerson("Tara", "Paris", new Date());
			deletePerson(15);
			getAllPersons();
		} catch (Exception e) {
			throw(e);
		}
		return;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void getAllPersons() {
		logger.info("Get all persons -> {} ", repos.findAll());
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void insertPerson(String name, String location, Date birthDate) {
		Person personForInsert = new Person(name, location, birthDate);
		logger.info("Insert person -> {} ", repos.save(personForInsert));
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deletePerson(int id) {
		repos.deleteById(id);
		logger.info("Delete person with id {}", id);
	}
	
	/*
	// RETRIEVE - GET A SPECIFIC PERSON
				logger.info("Get person with id 1-> {} ", repository.findById(1));
					
				// CREATE - PUT - insert
				Person personForInsert = new Person("Tara", "Paris", new Date());
				logger.info("Insert person -> {} ", repository.save(personForInsert));
				
				// UPDATE - POST - update
				Person personForUpdate = new Person(3, "Pieter", "Rome", new Date());
				logger.info("Update person with 3-> {} ", repository.save(personForUpdate));
				
				// DELETE - DELETE A SPECIFIC PERSON
				int id = 19;
				repository.deleteById(id);
				logger.info("Delete person with id {}", id);
				
				// RETRIEVE - GET ALL
				logger.info("Get all persons -> {} ", repository.findAll());
	*/

}
