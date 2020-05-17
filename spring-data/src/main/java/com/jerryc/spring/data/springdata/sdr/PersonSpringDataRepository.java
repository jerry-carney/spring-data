package com.jerryc.spring.data.springdata.sdr;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jerryc.spring.data.springdata.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {

}
