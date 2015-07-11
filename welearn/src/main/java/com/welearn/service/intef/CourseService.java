package com.welearn.service.intef;

import java.util.List;

import com.welearn.entity.CourseTime;
import com.welearn.model.Course;

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

	/**
	 * 根据课程id获取课程信息
	 * @param courseid
	 * @return
	 */
	public Course queryCourse(int courseid);
	
	/**
	 * 根据openid来查找学生的课程成绩
	 * @param openid
	 * @return
	 */
	public String queryCourseGrade(String openid);
	
}
