package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_time_course")
public class TimeCourse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="course_id", columnDefinition="int(11)", nullable=false)
	private Integer courseID;
	
	@Column(name="time_id", columnDefinition="int(11)", nullable=false)
	private Integer timeID;
	
	public TimeCourse() {
		super();
	}
	
	public TimeCourse(Integer courseID, Integer timeID) {
		super();
		this.courseID = courseID;
		this.timeID = timeID;
	}

	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public Integer getTimeID() {
		return timeID;
	}
	public void setTimeID(Integer timeID) {
		this.timeID = timeID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
