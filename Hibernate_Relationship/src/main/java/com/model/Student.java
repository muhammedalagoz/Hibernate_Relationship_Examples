package com.model;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	private Long studentId;

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	private String studentName;

	@OneToOne(cascade = CascadeType.ALL)
	private Address studentAddress;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private Set<Project> projects;
	
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="Student_Lessons", joinColumns={@JoinColumn(referencedColumnName="STUDENT_ID")}
                                        , inverseJoinColumns={@JoinColumn(referencedColumnName="Lesson_ID")})  
    private Set<Lesson> lessons;
	
	public Student() {
	}

	public Student(String studentName, Address studentAddress) {
		this.studentName = studentName;
		this.studentAddress = studentAddress;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

}