package com.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.muk.Person;
import com.muk.complexmapping.Employee;
import com.muk.complexmapping.EmployeeAddress;
import com.muk.complexmapping.Name;
import com.muk.complexmapping.Student;
import com.muk.inheritence.Advisors;
import com.muk.inheritence.RetailStores;
import com.muk.inheritence.Users;
import com.muk.optimization.Grade;
import com.muk.optimization.GradeStudent;
import com.muk.optimization.StudentSubject;

public class Test {

public static void Persist() {
	
		System.out.println("0...creating EntityManagerFactory...");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");
		System.out.println("1...EntityManagerFactory created...");
		EntityManager manager= factory.createEntityManager();
		System.out.println("2...EntityManager created...");
		EntityTransaction transaction=manager.getTransaction();
		System.out.println("3...EntityTransaction created...");
		transaction.begin();
		System.out.println("4...Transaction Begin...");
			
			Person person=new Person("Mohit", "Nirwaan");
			System.out.println("5...persist person...");
			manager.persist(person);
			System.out.println("6...persist person done...");
			
		transaction.commit();
		System.out.println("7...transaction commit...");
		manager.close();
		System.out.println("8...manager closed...");
		factory.close();
		System.out.println("9...factory closed...");
				
	}

public static void inheritence() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");	
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Users user=new Advisors(1200, "No");
	user.setUser_name("Deep Chand");
	user.setUser_code("110111");
	user.setPassword("dc0009776");
	manager.persist(user);
	
	Users user1=new RetailStores(200, "ABC");
	user1.setUser_name("raipur rani RS");
	user1.setUser_code("89632976");
	user1.setPassword("bh67576");
	manager.persist(user1);
	
	transaction.commit();
	manager.close();
	factory.close();
	
}

public static void secondarytable() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");	
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Student stud=new Student(1, "Bhupesh", "Dev Dutt", "Pinki Devi", "address1", "address2", "city", "zipcode");
	manager.persist(stud);
	
	transaction.commit();
	manager.close();
	factory.close();
	
}

public static void complexPK() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");	
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Employee emp=new Employee();
	emp.setDepartment("haulage");
	emp.setDob(LocalDate.of(2020, 4, 21));
	emp.setName(new Name("Vishal", "Thakur"));
	emp.getAddresses().add(new EmployeeAddress("solan", "173024", emp));
	manager.persist(emp);
	
	transaction.commit();
	manager.close();
	factory.close();
	
}

public static void optimizationinsert() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");	
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	
	Grade grade1=new Grade();
	grade1.setGrade_name("Tenth");
	
	GradeStudent stud1=new GradeStudent();
	stud1.setGrade(grade1);
	stud1.setName("Meena");
	
	StudentSubject sub1=new StudentSubject();
	sub1.setSubject_name("Sanskrit");
	sub1.setStudent(stud1);
	
	stud1.getSubjects().add(sub1);
	grade1.getStudents().add(stud1);
	
	manager.persist(grade1);
	System.out.println(grade1.getStudents().size());
	System.out.println(stud1.getSubjects().size());
	
	
	transaction.commit();
	manager.close();
	factory.close();
	
}

public static void optimizationfetch() {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.muk");	
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	transaction.begin();
	TypedQuery<Grade> query_grade=null;
	List<Grade> list_grade=null;
	
	//using simple fetch
	/*query_grade=manager.createQuery("from Grade", Grade.class);
	list_grade=query_grade.getResultList();
	
	for(Grade grade:list_grade)
	{
		System.out.println(grade.getGrade_name());
		System.out.println(grade.getStudents());
	}
	
	//using join fetch
	System.out.println("Using JOIN FETCH...");
	query_grade=manager.createQuery("from Grade G JOIN FETCH G.students", Grade.class);
	list_grade=query_grade.getResultList();
	for(Grade grade:list_grade)
	{
		System.out.println(grade.getGrade_name());
		System.out.println(grade.getStudents());
	}
	
	System.out.println("Using Entity Graph...");
	query_grade=manager.createQuery("from Grade", Grade.class);
	EntityGraph<Grade> entity_graph=manager.createEntityGraph(Grade.class);
	entity_graph.addSubgraph("students");//.addAttributeNodes("subjects");
	
	query_grade.setHint("javax.persistence.fetchgraph", entity_graph);
	list_grade=query_grade.getResultList();
	for(Grade grade:list_grade)
	{
		System.out.println(grade.getGrade_name());
		System.out.println(grade.getStudents());
	}*/
	
	//System.out.println("Using @Batch Size...");
	System.out.println("Using Subselect fetch Mode...");
	query_grade=manager.createQuery("from Grade", Grade.class);
	list_grade=query_grade.getResultList();
	for(Grade grade:list_grade)
	{
		System.out.println(grade.getGrade_name());
		System.out.println(grade.getStudents());
	}
	
	transaction.commit();
	manager.close();
	factory.close();
	
}
	public static void main(String[] args) {
		
		optimizationfetch();
				
	}
}
