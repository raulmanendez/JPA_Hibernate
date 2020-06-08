package com.muk;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
public class Address {
	
	@Id
	private Long id;
	private String city;
	private String zipcode;
	
	@ManyToMany
	private List<Employee> employee;
	
}
