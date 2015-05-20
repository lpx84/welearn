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
@Table(name="bjtu_course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(100)", nullable=false)
	private String name; //课程名称
	
	@Column(name="course_no", columnDefinition="varchar(100)", nullable=false)
	private String courseNo; //课程号
	
	@Column(name="description", columnDefinition="varchar(1024)")
	private String description;
	
	@Column(name="teacher_id", columnDefinition="int", nullable=false)
	private Integer teacherId; //授课老师
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="teacher_id",insertable=false,updatable=false)
	private Teacher teacherEntity;

	public Course() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Teacher getTeacherEntity() {
		return teacherEntity;
	}

	public void setTeacherEntity(Teacher teacherEntity) {
		this.teacherEntity = teacherEntity;
	}
	
	
}
