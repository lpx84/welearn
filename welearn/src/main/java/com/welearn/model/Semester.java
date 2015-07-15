package com.welearn.model;

import java.util.Calendar;

public class Semester {
	// 学年
	private Integer year;
	// 学期
	private Integer semesterNo;

	/**
	 * 得到当前学期
	 * 
	 * @return
	 */
	public static Semester getCurrSemester() {
		Calendar calendar = Calendar.getInstance();
		// 获取当前的年月日
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int semesterNo = 1;
		// 判断当前的学年和学期
		if ((month > 1 && month < 7) || (month == 1 && day > 10)
				|| (month == 7 && day < 15)) {
			semesterNo = 2;
		} else {
			if (month <= 1) {
				year--;
			}
		}

		Semester semester = new Semester(year, semesterNo);
		return semester;
	}

	public Semester() {
		super();
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

	@Override
	public String toString() {
		String semesterStr;
		if (semesterNo == 1) {
			semesterStr = "一";
		} else {
			semesterStr = "二";
		}
		return String.valueOf(year) + "-" + String.valueOf(year + 1) + "学年第"
				+ semesterStr + "学期";
	}

}
