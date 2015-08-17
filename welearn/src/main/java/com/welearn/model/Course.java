package com.welearn.model;

public class Course {
	int id;// 课程id
	String courseNo;// 课程号
	String name;// 课程名
	String semester;// 学期
	String type;// 课程类型
	String school;// 开课学院
	String teacher;// 开课教师
	String place;// 上课地点
	String time;// 上课时间
	String capacity;// 课容量
	String description;// 课程简介
	String teacherTel;// 教室电话
	int credit;// 学分

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherTel() {
		return teacherTel;
	}

	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

}
