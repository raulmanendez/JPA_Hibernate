package com.muk.optimization;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String grade_name;

	@LazyCollection(LazyCollectionOption.EXTRA)//to enable aggregate operations
	@OneToMany(mappedBy="grade",cascade= {CascadeType.PERSIST,CascadeType.MERGE,})
	//@BatchSize(size=2)
	@Fetch(FetchMode.SUBSELECT)
	private List<GradeStudent> students = new ArrayList<GradeStudent>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrade_name() {
		return grade_name;
	}

	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}

	public List<GradeStudent> getStudents() {
		return students;
	}

	public void setStudents(List<GradeStudent> students) {
		this.students = students;
	}	
}
