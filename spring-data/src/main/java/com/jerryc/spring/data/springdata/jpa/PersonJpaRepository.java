package com.jerryc.spring.data.springdata.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jerryc.spring.data.springdata.entity.Person;


@Repository
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	// Get all persons, HQL (Hibernate Query Language)
	// JPQL - Java Persistence Query Language
	//@Transactional(Transactional.TxType.REQUIRED)
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	// Get Person by Id
	//@Transactional(Transactional.TxType.REQUIRED)
	public Person findById(int id) {
		
		return entityManager.find(Person.class, id);
	}
	
	// Update Person by Id, Merge is for Update or Insert
	//@Transactional(Transactional.TxType.REQUIRED)
	public Person update(Person person) { 
		return entityManager.merge(person);
	}
	
	// Insert - SAME AS ABOVE METHOD
	//@Transactional(Transactional.TxType.REQUIRED)
	public Person insert(Person person) { 
		return entityManager.merge(person);
	}
	
	// Delete person by Id
	//@Transactional(Transactional.TxType.REQUIRED)
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}

}
