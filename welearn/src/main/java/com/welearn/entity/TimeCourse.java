package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_time_course")
public class TimeCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="course_id", columnDefinition="int(11)")
	private int courseId;
	
	@Column(name="time_id", columnDefinition="int(11)")
	private int timeId;
	
	@Column(name="classroom", columnDefinition="varchar(255)")
	private int classroom;
	
	@Column(name="class_time", columnDefinition="varchar(255)")
	private int classTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="time_id",insertable=false,updatable=false)
	private CourseTime courseTimeEntity;

	public TimeCourse() {
		super();
	}

	public TimeCourse(int courseId, int timeId) {
		super();
		this.courseId = courseId;
		this.timeId = timeId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	public CourseTime getCourseTimeEntity() {
		return courseTimeEntity;
	}

	public void setCourseTimeEntity(CourseTime courseTimeEntity) {
		this.courseTimeEntity = courseTimeEntity;
	}

	public int getClassroom() {
		return classroom;
	}

	public void setClassroom(int classroom) {
		this.classroom = classroom;
	}

	public int getClassTime() {
		return classTime;
	}

	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}

	@Override
	public String toString() {
		return "TimeCourse [id=" + id + ", courseId=" + courseId + ", timeId="
				+ timeId + ", classroom=" + classroom + ", classTime="
				+ classTime + ", courseEntity=" + courseEntity
				+ ", courseTimeEntity=" + courseTimeEntity + "]";
	}

}
