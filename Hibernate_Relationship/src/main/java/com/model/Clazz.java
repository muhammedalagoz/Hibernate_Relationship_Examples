package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Clazz")
public class Clazz {

	@Id
	@GeneratedValue
	@Column(name = "Clazz_ID")
	private long clazzId;
	
	@Column(name = "Clazz_Number")
	private String classNumber;

	@ManyToOne
	Student student;
	
	public Clazz(String classNumber, Student student) {
		super();
		this.classNumber = classNumber;
		this.student = student;
	}

	public long getClazzId() {
		return clazzId;
	}

	public void setClazzId(long clazzId) {
		this.clazzId = clazzId;
	}

	public String getClassNumber() {
		return classNumber;
	}

	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
