package com.welearn.service.impl;

import java.util.Date;
import java.util.List;

import com.welearn.dao.AttendRecordDao;
import com.welearn.dao.AttendTaskDao;
import com.welearn.dao.CourseDao;
import com.welearn.dao.CourseHomeworkDao;
import com.welearn.dao.CourseNotifyDao;
import com.welearn.dao.CourseReplyDao;
import com.welearn.dao.StudentCourseDao;
import com.welearn.dao.StudentDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseReply;
import com.welearn.entity.Student;
import com.welearn.entity.StudentCourse;
import com.welearn.entity.Teacher;
import com.welearn.model.Semester;
import com.welearn.service.intef.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherDao;
	CourseHomeworkDao courseHomeworkDao;
	CourseNotifyDao courseNotifyDao;
	CourseDao courseDao;
	AttendTaskDao attendTaskDao;
	StudentDao studentDao;
	StudentCourseDao studentCourseDao;
	CourseReplyDao courseReplyDao;
	AttendRecordDao attendRecordDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void setAttendRecordDao(AttendRecordDao attendRecordDao) {
		this.attendRecordDao = attendRecordDao;
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
	
	public void setAttendTaskDao(AttendTaskDao attendTaskDao) {
		this.attendTaskDao = attendTaskDao;
	}
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setStudentCourseDao(StudentCourseDao studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}
	
	public void setCourseReplyDao(CourseReplyDao courseReplyDao) {
		this.courseReplyDao = courseReplyDao;
	}

	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		//teacherDao.getTeacher(id);
		return teacherDao.getTeacher(1);
	}
	
	//课程作业部分
	public boolean publishCourseHomework(CourseHomework homework) {
		int result = courseHomeworkDao.addCourseHomework(homework);
		//System.out.println("result:"+result);
		return result>0;
	}

	public CourseHomework getHomeworkByTitle(String title) {
		return null;
	}

	public CourseHomework getHomeworkById(int id) {
		return courseHomeworkDao.getCourseHomeworkById(id);
	}

	public boolean updateCourseHomework(CourseHomework homework) {
		return courseHomeworkDao.updateCourseHomework(homework);
	}

	//课程管理
	public Course getCourseById(int id) {
		//courseDao.getCourse(id);
		return courseDao.getCourse(id);
	}

	public List<Course> getCourseList(int teacherId) {
		//List<Course> list = courseDao.getCoursesByTeacher(teacherId);
		return courseDao.getCoursesByTeacher(teacherId);
	}

	public Course getCourseByCourseNo(String courseNo) {
		return null;
	}

	//学生管理
	public List<StudentCourse> getStudentList() {
		List<StudentCourse> list = studentCourseDao.getStudentCourse();
		return list;
	}

	public List<StudentCourse> getStudentListByCourseId(int courseId) {
		List<StudentCourse> list = studentCourseDao.getStudentCourseByCourseId(courseId);
		return list;
	}

	//签到任务
	public List<AttendTask> getAttendTaskByCourseId(int id) {
		return null;
	}

	public AttendTask getAttendTaskById(int id) {
		//attendTaskDao.getAttendTaskById(id);
		return attendTaskDao.getAttendTaskById(id);
	}

	public boolean publishAttendTask(AttendTask attendTask) {
		//attendTaskDao.addAttendTask(attendTask);
		return attendTaskDao.addAttendTask(attendTask)>0;
	}

	public boolean updateAttendTask(AttendTask attendTask) {
		//attendTaskDao.updateAttendTask(attendTask);
		return attendTaskDao.updateAttendTask(attendTask);
	}
	
	//签到记录
	public AttendRecord getAttendRecordByAttendTaskId(int id) {
		return null;
	}

	//课程通知
	public boolean publisCourseNotify(CourseNotify courseNotify) {
		//courseNotifyDao.addCourseNotify(courseNotify);
		return courseNotifyDao.addCourseNotify(courseNotify)>0;
	}

	public CourseNotify getCourseNotifyById(int id) {
		//courseNotifyDao.getCourseNotifyById(id);
		return courseNotifyDao.getCourseNotifyById(id);
	}

	public boolean updateCourseNotify(CourseNotify courseNotify) {
		return courseNotifyDao.updateCourseNotify(courseNotify);
	}

}
