package com.welearn.service.intef;

import java.util.Date;
import java.util.List;

import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.Teacher;
import com.welearn.entity.Student;

public interface TeacherService {
	
	public Teacher getTeacherById(int id);
	
	//课程作业部分
	public boolean publishCourseHomework(CourseHomework homework);
	
	public CourseHomework getHomeworkByTitle(String title);
	
	public CourseHomework getHomeworkById(int id);

	public boolean updateCourseHomework(CourseHomework homework);

	//课程管理
	public Course getCourseById(int id);
	
	public Course getCourseByCourseNo(String courseNo);
	
	public List<Course> getCourseList(int teacherId);
	
	//学生管理
	public List<Student> getStudentList();
	
	public List<Student> getStudentListByCourseId(int id);
	
	//签到任务
	public boolean publishAttendTask(AttendTask attendTask);
	
	public AttendTask getAttendTaskById(int id);
	
	public List<AttendTask> getAttendTaskByCourseId(int id);

	public boolean updateAttendTask(AttendTask attendTask);
	
	//签到记录
	public AttendRecord getAttendRecordByAttendTaskId(int id);
	
	//课程通知
	public boolean publisCourseNotify(CourseNotify courseNotify);
	
	public CourseNotify getCourseNotifyById(int id);
	
	public boolean updateCourseNotify(CourseNotify courseNotify);
	
	public void test();
}
