package com.welearn.dao;

import java.util.List;

import com.welearn.entity.CourseTime;

public class CourseTimeDao {

	/**
	 * 新增一条记录
	 * @param courseTime
	 * @return
	 */
	public Integer addCourseTime(CourseTime courseTime){
		return null;
	}
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delCourseTime(int id){
		return false;
	}
	
	/**
	 * 更新记录
	 * @param courseTime
	 * @return
	 */
	public boolean updateCourseTime(CourseTime courseTime){
		return false;
	}
	
	/**
	 * 查询记录
	 * @param id
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public CourseTime getCourseTime(int id, int pageNo, int pageItemNum){
		return null;
	}
	
	/**
	 * 根据某个非主属性查找某条记录
	 * @param section_id
	 * @return
	 */
	public List<CourseTime> getCourseTimeBySection(int section_id){
		return null;
	}
}
