package com.muk;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity
//@Table(name="person_table")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private Long id;
	private String first_name;
	private String last_name;
	
	public Person(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	public Person(Long id, String first_name, String last_name) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
	}
	
	
}
