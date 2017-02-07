package com.core;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Address;
import com.model.Lesson;
import com.model.Student;
import com.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		SessionFactory hibernateSessionFactory = HibernateUtil.getSessionFactory();
		Session session = hibernateSessionFactory.openSession();
		
		session.beginTransaction();
		
//		****One_To_One
//		Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
//		Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
//		Student student1 = new Student("Eswar", address1);
//		Student student2 = new Student("Joe", address2);
		
//		****One_To_Many
//		Set<Project> set1 = new HashSet<Project>();
//		set1.add(new Project("Project1",student1));
//		set1.add(new Project("Project2",student1));
//		set1.add(new Project("Project3",student1));
//		
//		student1.setProjects(set1);
		
//		session.save(student1);
//		session.save(student2);

//		****Mayn_To_One
		
//		Student student = (Student) session.get(Student.class, 1L);
//		
//		Clazz clazz1 = new Clazz("class101", student);
//		Clazz clazz2 = new Clazz("class101", student);
//		session.save(clazz1);
//		session.save(clazz2);

//		****Mayn_To_Mayn
		Address address1 = new Address("OMR Road", "Chennai", "TN", "600097");
		Address address2 = new Address("Ring Road", "Banglore", "Karnataka", "560000");
		Student student1 = new Student("Eswar", address1);
		Student student2 = new Student("Joe", address2);
		
		Lesson lesson1 = new Lesson("lesson1");
		Lesson lesson2 = new Lesson("lesson2");
		
		Set<Student> students = new HashSet<Student>();
		students.add(student1);
		students.add(student2);
		
		Set<Lesson> lessons = new HashSet<Lesson>();
		lessons.add(lesson1);
		lessons.add(lesson2);
		
		student1.setLessons(lessons);
		student2.setLessons(lessons);
		
		session.save(student1);
		session.save(student2);
		
		session.getTransaction().commit();
		session.close();
	}
}