package com.welearn.service.impl;

import java.util.Date;
import java.util.List;

import com.welearn.entity.CourseTime;
import com.welearn.model.Course;
import com.welearn.service.intef.CourseService;

public class CourseServiceImpl implements CourseService {

	public String getCourseList(String keyword, int pageNo, int academyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCourseList(String keyword, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryCourseScheduleByWeek(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryCourseScheduleByWeekDay(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course queryCourse(int courseid) {
		// TODO Auto-generated method stub
		//这里应该通过学习的接口查询课程,先进行模拟
		Course course = new Course();
		course.setCapacity("80");
		course.setDescription("这是张奶奶的课");
		course.setName("系统分析");
		course.setPlace("逸夫楼 yf104");
		course.setSchool("软件学院");
		course.setTeacher("张红延");
		course.setTime("1-16周 周一第4节");
		
		
		return course;
	}



}
