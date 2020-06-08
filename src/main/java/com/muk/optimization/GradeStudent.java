package com.muk.optimization;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class GradeStudent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name="grade_id")
	private Grade grade=new Grade();
	
	@OneToMany(mappedBy="student",cascade=CascadeType.ALL)
	//@BatchSize(size=2)
	@Fetch(FetchMode.SUBSELECT)
	private List<StudentSubject> subjects=new ArrayList<StudentSubject>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public List<StudentSubject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<StudentSubject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString() {
		return "GradeStudent [id=" + id + ", name=" + name + ", grade=" + grade + ", subjects=" + subjects
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getGrade()=" + getGrade()
				+ ", getSubjects()=" + getSubjects() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
