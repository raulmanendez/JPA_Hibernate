package com.muk.complexmapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

//@Entity
public class Employee {
	
	@EmbeddedId
	private Name name;
	
	private String department;
	private LocalDate dob;
	
	@OneToMany(mappedBy="employee",cascade=CascadeType.ALL)
	private List<EmployeeAddress> addresses=new ArrayList<EmployeeAddress>();
	
	public Name getName() {
		return name;
	}
	public void setName(Name name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public List<EmployeeAddress> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<EmployeeAddress> addresses) {
		this.addresses = addresses;
	}

}
