package com.welearn.dao;

import com.welearn.entity.StudentCourse;

public class StudentCourseDao {

	/**
	 * 新增一条记录
	 * @param studentCourse
	 * @return
	 */
	public Integer addStudentCourse(StudentCourse studentCourse){
		return null;
	}
	
	/**
	 * 删除一条记录
	 * @param studentCourse
	 * @return
	 */
	public boolean delStudentCourse(StudentCourse studentCourse){
		return false;
	}
	
	/**
	 * 删除一条记录
	 * @param studentID
	 * @param courseID
	 * @return
	 */
	public boolean delStudentCourse(int studentID, int courseID){
		return false;
	}
	
	/**
	 * 更新一条数据
	 * @param studentCourse
	 * @return
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse){
		return false;
	}
	
	/**
	 * 判断记录是否存在
	 * @param studentCourse
	 * @return
	 */
	public boolean isExist(StudentCourse studentCourse){
		return false;
	}
	
	/**
	 * 获得一条记录
	 * @param studentID
	 * @param courseID
	 * @return
	 */
	public StudentCourse getStudentCourse(int studentID, int courseID){
		return null;
	}
}
