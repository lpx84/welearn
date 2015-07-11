package com.welearn.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course_time")
public class CourseTime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="section_no", columnDefinition="int(11)")
	private int sectionNno;
	
	@Column(name="week_no", columnDefinition="int(11)")
	private Integer weekNo;
	
	@Column(name="weekday", columnDefinition="int(11)")
	private Integer weekday;
	
	@Column(name="semester", columnDefinition="tinyint")
	private Integer semester;
	
	@Column(name="course_id", columnDefinition="int(11)")
	private Integer courseId;
	
	@Column(name="year", columnDefinition="int(4)")
	private Integer year;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;

	public CourseTime() {
		
	}
	
	/**
	 * 根据时间转化为实体
	 * @param date
	 */
	public CourseTime(Date date) {
		
	}
	
	
	public Integer getWeekNo() {
		return weekNo;
	}

	public void setWeekNo(Integer weekNo) {
		this.weekNo = weekNo;
	}

	public Integer getWeekday() {
		return weekday;
	}

	public void setWeekday(Integer weekday) {
		this.weekday = weekday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getSectionNno() {
		return sectionNno;
	}

	public void setSectionNno(int sectionNno) {
		this.sectionNno = sectionNno;
	}

	public Integer getSemester() {
		return semester;
	}

	public void setSemester(Integer semester) {
		this.semester = semester;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	@Override
	public String toString() {
		return "CourseTime [id=" + id + ", sectionNno=" + sectionNno
				+ ", weekNo=" + weekNo + ", weekday=" + weekday + ", semester="
				+ semester + ", courseId=" + courseId + ", year=" + year
				+ ", courseEntity=" + courseEntity + "]";
	}

}
