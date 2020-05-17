package com.jerryc.spring.data.springdata.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jerryc.spring.data.springdata.entity.Person;


@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	// Get all persons, HQL (Hibernate Query Language)
	// JPQL - Java Persistence Query Language
	public List<Person> findAll() {
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList();
	}
	
	// Get Person by Id
	public Person findById(int id) { 
		return entityManager.find(Person.class, id);
	}
	
	// Update Person by Id, Merge is for Update or Insert
	public Person update(Person person) { 
		return entityManager.merge(person);
	}
	
	// Insert - SAME AS ABOVE METHOD
	public Person insert(Person person) { 
		return entityManager.merge(person);
	}
	
	// Delete person by Id
	public void deleteById(int id) {
		Person person = findById(id);
		entityManager.remove(person);
	}
	
	
	

}
