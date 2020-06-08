package com.muk.optimization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentSubject {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String subject_name;

	
	@ManyToOne
	@JoinColumn(name="student_id")
	private GradeStudent student = new GradeStudent();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getSubject_name() {
		return subject_name;
	}


	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public GradeStudent getStudent() {
		return student;
	}


	public void setStudent(GradeStudent student) {
		this.student = student;
	}

	

}
