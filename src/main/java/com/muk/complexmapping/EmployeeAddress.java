package com.muk.complexmapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

//@Entity
public class EmployeeAddress {

	@Id
	private int id;
	private String city;
	private String zipcode;
	
	
	public EmployeeAddress(String city, String zipcode, Employee employee) {
		super();
		this.city = city;
		this.zipcode = zipcode;
		this.employee = employee;
	}

	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="emp_first_name",referencedColumnName="firstname"),
		@JoinColumn(name="emp_last_name",referencedColumnName="lastname"),
	})
	private Employee employee;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
