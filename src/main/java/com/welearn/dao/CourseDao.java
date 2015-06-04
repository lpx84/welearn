package com.welearn.dao;

import java.util.List;

import com.welearn.entity.Course;

public class CourseDao  extends SuperDao {

	public Integer addCourse(Course course) {
		return null;
		
	}
	
	public boolean delCourse(int id) {
		return false;
	}
	
	public boolean delCourseByCourseNo(String courseNo) {
		return false;
		
	}
	
	public boolean updateCourse(Course course) {
		return false;
	}
	
	/**
	 * 根据课程主键查询实体
	 * @param id 课程主键
	 * @return
	 */
	public Course getCourse(int id) {
		return null;
		
	}
	
	/**
	 * 根据课程号查询实体
	 * @param courseNo 课程号
	 * @return
	 */
	public Course getCourseByCourseNo(String courseNo) {
		return null;
	}
	
	/**
	 * 老师的课程列表
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List getCoursesByTeacher(int teacherId, int pageNo, int pageItemNum) {
		return null;
	}
}
