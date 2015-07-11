package com.welearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="bjtu_student_course")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="course_id", columnDefinition="int(11)", nullable=false)
	private Integer courseId;
	
	@Column(name="student_id", columnDefinition="int(11)", nullable=false)
	private Integer studentId;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id",insertable=false,updatable=false)
	private Student studentEntity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;
	
	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(Student studentEntity) {
		this.studentEntity = studentEntity;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	@Override
	public String toString() {
		return "StudentCourse [id=" + id + ", courseId=" + courseId
				+ ", studentId=" + studentId + ", studentEntity="
				+ studentEntity + ", courseEntity=" + courseEntity + "]";
	}
	
}
