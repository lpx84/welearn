package com.welearn.entity;

public class TimeCourse {

	private Integer courseID;
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
	
}
