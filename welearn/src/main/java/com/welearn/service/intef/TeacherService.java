package com.welearn.service.intef;

import java.util.Date;
import java.util.List;

import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.Teacher;
import com.welearn.entity.Student;

public interface TeacherService {
	
	public Teacher getTeacherById(int id);
	
	public boolean publishCourseHomework(CourseHomework homework);
	
	public CourseHomework getHomeworkByTitle(String title);
	
	public boolean updateCourseHomework(CourseHomework homework);

	public Course getCourseById(int id);
	
	public Course getCourseByCourseNo(String courseNo);
	
	public List<Student> getStudentList();
	
	public List<Student> getStudentListByCourseId(int id);
	
	public List<AttendTask> getAttendTaskByCourseId(int id);
	
	public AttendRecord getAttendRecordByAttendTaskId(int id);
	
	public boolean publisCourseNotify(String title, String content, int courseId, Date createTime);
	
	public void test();
}
