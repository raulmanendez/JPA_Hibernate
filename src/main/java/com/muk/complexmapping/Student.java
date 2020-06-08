package com.muk.complexmapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

//@Entity
//@SecondaryTable(name="student_address")
public class Student {

	@Id
	private int id;
	private String name;
	private String father_name;
	private String mother_name;
	
	@Column(table="student_address")
	private String address1;
	@Column(table="student_address")
	private String address2;
	@Column(table="student_address")
	private String city;
	@Column(table="student_address")
	private String zipcode;
	
	public Student(int id, String name, String father_name, String mother_name, String address1, String address2,
			String city, String zipcode) {
		super();
		this.id = id;
		this.name = name;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.zipcode = zipcode;
	}
	
	
}
