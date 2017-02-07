package com.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Lesson")
public class Lesson {

	@Id
	@GeneratedValue
	@Column(name = "Lesson_ID")
	private Long lessonId;

	@Column(name = "Lesson_Name")
	private String lessonName;
	
	@ManyToMany(mappedBy="lessons")
	private Set<Student> studesnts;

	public Lesson(String lessonName) {
		super();
		this.setLessonName(lessonName);
	}

	public Set<Student> getStudesnts() {
		return studesnts;
	}

	public void setStudesnts(Set<Student> studesnts) {
		this.studesnts = studesnts;
	}

	public Long getLessonId() {
		return lessonId;
	}

	public void setLessonId(Long lessonId) {
		this.lessonId = lessonId;
	}

	public String getLessonName() {
		return lessonName;
	}

	public void setLessonName(String lessonName) {
		this.lessonName = lessonName;
	}
	
}
