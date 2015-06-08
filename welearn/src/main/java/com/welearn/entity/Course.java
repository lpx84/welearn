package com.welearn.entity;

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
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course",catalog="Hibernate_Many2Many")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="year", columnDefinition="int(4)")
	private Integer year;
	
	@Column(name="semester", columnDefinition="tinyint(1)")
	private Integer semester;
	
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

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_student_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id")
    )
	
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
	private Set<Student> studentList;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_time_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="time_id", referencedColumnName="id")
    )
	private Set<CourseTime> courseTimeList;
	
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

	public Set<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(Set<Student> studentList) {
		this.studentList = studentList;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Set<CourseTime> getCourseTimeList() {
		return courseTimeList;
	}

	public void setCourseTimeList(Set<CourseTime> courseTimeList) {
		this.courseTimeList = courseTimeList;
	}

}