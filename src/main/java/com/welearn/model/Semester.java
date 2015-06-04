package com.welearn.model;

public class Semester {

	private Integer year;
	
	private Integer semesterNo;

	
	/**
	 * 得到当前学期
	 * @return
	 */
	public static Semester getCurrSemester() {
		return null;
	} 
	
	public Semester(Integer year, Integer semesterNo) {
		super();
		this.year = year;
		this.semesterNo = semesterNo;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(Integer semesterNo) {
		this.semesterNo = semesterNo;
	}
	
	
}
