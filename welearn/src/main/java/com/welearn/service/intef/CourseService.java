package com.welearn.service.intef;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.welearn.entity.Course;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseTime;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseGrade;
import com.welearn.model.ExamPlan;
import com.welearn.model.Semester;

public interface CourseService {

	

	
	/**
	 * 根据周，查询当前学期的课表
	 */
	public List<?> queryCourseScheduleByWeek(int id, CourseTime time);
	
	/**
	 * 根据天，查询当前学期的课表
	 */
	public List<?> queryCourseScheduleByWeekDay(int id, CourseTime time);

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
	public Map<String, ArrayList<CourseGrade>> queryCourseGrade(String openid);
	
	/**
	 * 根据openid来查找学生的四六级成绩
	 * @param openid
	 * @return
	 */
	public ArrayList<CETGrade> queryCETGrade(String openid);
	
	/**
	 * 根据Openid查找学生的考试安排
	 * @param openid
	 * @return
	 */
	public ArrayList<ExamPlan> queryExamPlan(String openid);
	
	/**
	 * 根据关键字查找课程信息
	 * @param keyword
	 * @param pageno
	 * @return
	 */
	public ArrayList<Course> queryCoursesByKeyword(String keyword,int pageno);
	
	/**
	 * 根据courseid获取model中的course对象
	 * @param courseid
	 * @return
	 */
	public com.welearn.model.Course queryCourseModleByCourseId(int courseid);
	
	/**
	 * 根据课程id查找课程通知
	 * @param courseId
	 * @return
	 */
	public ArrayList<CourseNotify> queryCourseNotify(int courseId,int pageNo,int pageItemNo);
	
	/**
	 * 根据学生的id获取该学生这学期上的课程
	 * @param studentId
	 * @return
	 */
	public ArrayList<Semester> querySemesterByStudentId(int studentId);
	
	/**
	 * 获取该学生各个学期的成绩
	 * @param studentId
	 * @return
	 */
	public Map<String, ArrayList<Course>> querySemesterCourseByStudentId(int studentId);
	
}
