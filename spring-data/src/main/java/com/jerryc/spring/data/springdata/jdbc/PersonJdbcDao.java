package com.jerryc.spring.data.springdata.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jerryc.spring.data.springdata.entity.Person;

@Repository   // We could have said @Component, BUT we want to take advantage of @Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;  // Creates connection to DB and facilitates queries
	
	// Inner class
	class PersonRowMapper implements RowMapper<Person> {

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			
			return person;
		}
		
	}
	
//	public List<Person> findAll() {  //  (query, mapToBean)
//		return jdbcTemplate.query("select * from person",
//				new BeanPropertyRowMapper(Person.class));
//	}
	
	public List<Person> findAll() {  //  (query, mapToBean)
		return jdbcTemplate.query("select * from person",
				new PersonRowMapper());
	}
	
	public Person findById(int id) { 
		return (Person) jdbcTemplate.queryForObject(
				"select * from person where id=?",   //looks like a prepared statement
				new Object[]{id},
				new BeanPropertyRowMapper(Person.class));
	}
	
	public int deleteById(int id) { // returns number of rows deleted
		return jdbcTemplate.update(
				"delete from person where id=?",   //looks like a prepared statement
				new Object[]{id});

	}
	
	public int insert(Person person) {  // returns number of rows inserted
		return jdbcTemplate.update(
			"insert into person (name, location, birth_date) values(?, ?, ?)",
			new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {  // returns number of rows updated
		return jdbcTemplate.update(
			"update person set name=?, location=?, birth_date=? where id=?",
			new Object[]{person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
}
