package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@GeneratedValue
	@Column(name="Project_ID")
	private Long projectId;
	
	@Column(name="Project_Name")
	private String projectName;
	
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private Student student;

	public Project(String projectName, Student student) {
		super();
		this.projectName = projectName;
		this.student = student;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
}
