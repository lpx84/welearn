package com.welearn.service.intef;

import java.util.List;

import com.welearn.entity.CourseTime;

public interface CourseService {

	
	public String getCourseList(String keyword, int pageNo, int academyId);
	
	public String getCourseList(String keyword, int pageNo);
	
	/**
	 * 根据周，查询当前学期的课表
	 */
	public List queryCourseScheduleByWeek(int id, CourseTime time);
	
	/**
	 * 根据天，查询当前学期的课表
	 */
	public List queryCourseScheduleByWeekDay(int id, CourseTime time);
	
	
}
