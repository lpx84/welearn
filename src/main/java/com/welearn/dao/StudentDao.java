package com.welearn.dao;

import java.util.List;

import com.welearn.entity.Student;

public class StudentDao extends SuperDao {

	public Integer addStudent(Student student) {
		return null;
	}
	
	public boolean delStudent(int id) {
		return false;
	}
	
	public boolean delStudentByOpenID(String openID) {
		return false;
	}
	
	public boolean delStudentByStudentNo(String studentNo) {
		return false;
	}
	
	public Student getStudent(int id) {
		return null;
	}
	
	public Student getStudentByOpenID(String openID) {
		return null;
	}
	
	public Student getStudentByFakeID(String fakeID) {
		return null;
	}
	
	public Student getStudentByTrueName(String trueName) {
		return null;
	}
	
	public Student getStudentByStudentNo(String studentNo) {
		return null;
	}
	
	public List getStudents(int pageNo, int pageItemNum) {
		return null;
	}
	
	public boolean updateStudent(Student student) {
		return false;
		
	}
	
	/**
	 * 在学生表里取出这个学生所有的课程信息，这里需要确认多对多的关系是否正确
	 * @return
	 */
	public List getCourseList() {
		return null;
	}
	
	
}
