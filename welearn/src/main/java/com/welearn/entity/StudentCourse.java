package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_student_course")
public class StudentCourse {

	@Column(name="course_id", columnDefinition="int(11)", nullable=false)
	private Integer courseId;
	
	@Column(name="student_id", columnDefinition="int(11)", nullable=false)
	private Integer studentId;

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
	
	
}
