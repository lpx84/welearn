package com.welearn.dao;

import java.util.List;

import com.welearn.entity.Teacher;

public class TeacherDao  extends SuperDao {

	public Integer addTeacher(Teacher teacher) {
		return null;
	}
	
	public boolean delTeacher(int id) {
		return false;
	}
	
	public boolean delTeacherByUserName(String username) {
		return false;
	}
	
	public boolean updateTeacher(Teacher teacher) {
		return false;
		
	}
	
	public Teacher getTeacher(int id) {
		return null;
		
	}
	
	/**
	 * 
	 * @param userName 这里指的是老师的工号
	 * @return
	 */
	public Teacher getTeacherByUserName(String userName) {
		return null;
	}
	
	/**
	 * 通过名字查询教师
	 * @param trueName
	 * @return
	 */
	public List getTeachersByTrueName(String trueName) {
		return null;
	}
	
	/**
	 * 通过学院得到老师列表
	 * @param academyId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List getTeachersByAcademy(int academyId, int pageNo, int pageItemNum) {
		return null;
		
	}
	
}
