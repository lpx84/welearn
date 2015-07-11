package com.welearn.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_student_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id")
    )*/
	
//	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
//	@JoinTable(name="bjtu_student_course",
//		joinColumns=@JoinColumn(name="course_id"),
//		inverseJoinColumns={
//			@JoinColumn(name="student_id",
//			referencedColumnName="id"),
//			@JoinColumn(name="course_id",
//			referencedColumnName="id")
//		}
//	)
	//private Set<Student> studentList;
	
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_time_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="time_id", referencedColumnName="id")
    )*/
	//private Set<CourseTime> courseTimeList;
	
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

}
