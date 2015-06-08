package com.welearn.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course_time")
public class CourseTime {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="week_no")
	private Integer weekNo;
	@Column(name="weekday")
	private Integer weekday;
	
	/**
	 * 节次
	 */
	@Column(name="section_no")
	private Integer sectionNo;
	
	@ManyToMany(mappedBy="courseTimeList",cascade=CascadeType.ALL)
	private Set<Course> courseList;

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

	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Set<Course> getCourseList() {
		return courseList;
	}



	public void setCourseList(Set<Course> courseList) {
		this.courseList = courseList;
	}
	
}
