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
	
	@Column(name="teacher_id", columnDefinition="int")
	private String teacherId;
	
	/**
	 * 所属学院的ID
	 */
	@Column(name="academy_id", columnDefinition="int", nullable=false)
	private Integer academyId;
	
	@Column(name="credit", columnDefinition="int default 0", nullable=false)
	private Integer credit;
	
	@Column(name="course_type", columnDefinition="varchar(20)")
	private String courseType;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="academy_id",insertable=false,updatable=false)
	private Academy academyEntity;
	
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

	public Integer getAcademyId() {
		return academyId;
	}

	public void setAcademyId(Integer academyId) {
		this.academyId = academyId;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Academy getAcademyEntity() {
		return academyEntity;
	}

	public void setAcademyEntity(Academy academyEntity) {
		this.academyEntity = academyEntity;
	}
	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", courseNo=" + courseNo
				+ ", description=" + description + ", teacherId=" + teacherId
				+ ", academyId=" + academyId + ", credit=" + credit
				+ ", courseType=" + courseType + ", academyEntity="
				+ academyEntity + "]";
	}
	
}
