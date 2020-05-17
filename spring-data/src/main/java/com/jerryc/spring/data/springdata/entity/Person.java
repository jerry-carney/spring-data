package com.jerryc.spring.data.springdata.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@Table(name="person") // not needed because Table name is the Class name
//@NamedQuery(name="find_all_persons", query="select p from Person p") - REQUIRED for Hibernate
public class Person {
	@Id   // indicates that this is a primary key
	//@GeneratedValue  // generates a unique value // not needed, table has AUTO_INCREMENT
	private int id;
	
	//@Column(name="name")  // not need because var name is column name
	private String name;
	private String location;
	@Column(name="birth_date")
	private Date birthDate;
	
	
	public Person() {}
	
	// Constructor without Id for JPA
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public Person(int id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return "\nPerson [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}

}
