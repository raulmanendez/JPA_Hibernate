package com.muk;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

//@Entity
public class Employee {

	@Id
	private Long id;
	private String fname;
	private String lname;
	
	@ManyToMany
	private List<Address> address;
}
