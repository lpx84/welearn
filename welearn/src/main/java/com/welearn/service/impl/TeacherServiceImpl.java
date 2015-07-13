package com.welearn.service.impl;

import java.util.Date;
import java.util.List;

import com.welearn.dao.CourseDao;
import com.welearn.dao.CourseHomeworkDao;
import com.welearn.dao.CourseNotifyDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.Student;
import com.welearn.entity.Teacher;
import com.welearn.service.intef.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherDao;
	CourseHomeworkDao courseHomeworkDao;
	CourseNotifyDao courseNotifyDao;
	CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}
	
	public void setCourseHomeworkDao(CourseHomeworkDao courseHomeworkDao) {
		this.courseHomeworkDao = courseHomeworkDao;
	}

	public void setCourseNotifyDao(CourseNotifyDao courseNotifyDao) {
		this.courseNotifyDao = courseNotifyDao;
	}

	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		//teacherDao.getTeacher(id);
		return teacherDao.getTeacher(1);
	}

	public boolean publishCourseHomework(CourseHomework homework) {
		// TODO Auto-generated method stub
		
		int result = courseHomeworkDao.addCourseHomework(homework);
		//System.out.println("result:"+result);
		return result>0;
	}


	public CourseHomework getHomeworkByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	public CourseHomework getHomeworkById(int id) {
		// TODO Auto-generated method stub
		return courseHomeworkDao.getCourseHomeworkById(id);
	}

	public boolean updateCourseHomework(CourseHomework homework) {
		// TODO Auto-generated method stub
		return courseHomeworkDao.updateCourseHomework(homework);
	}


	public Course getCourseById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Course getCourseByCourseNo(String courseNo) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Student> getStudentList() {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Student> getStudentListByCourseId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<AttendTask> getAttendTaskByCourseId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public AttendRecord getAttendRecordByAttendTaskId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean publisCourseNotify(CourseNotify courseNotify) {
		// TODO Auto-generated method stub
		//courseNotifyDao.addCourseNotify(courseNotify);
		return courseNotifyDao.addCourseNotify(courseNotify)>0;
	}


	public void test() {
		// TODO Auto-generated method stub
		List<Course> list = courseDao.getCoursesByTeacherName("yaoJie", 1, 1);
		System.out.println("-----------------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}
	}



}
