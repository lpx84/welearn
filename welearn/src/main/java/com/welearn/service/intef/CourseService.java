package com.welearn.service.intef;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.welearn.entity.Course;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseDiscuss;
import com.welearn.model.CourseGrade;
import com.welearn.model.CourseProblem;
import com.welearn.model.CourseTestResult;
import com.welearn.model.ExamPlan;
import com.welearn.model.Semester;

public interface CourseService {

	/**
	 * 根据课程id获取课程信息
	 * 
	 * @param courseid
	 * @return
	 */
	public Course queryCourse(int courseid);

	/**
	 * 根据openid来查找学生的课程成绩
	 * 
	 * @param openid
	 * @return
	 */
	public Map<String, ArrayList<CourseGrade>> queryCourseGrade(String openid);

	/**
	 * 根据openid来查找学生的四六级成绩
	 * 
	 * @param openid
	 * @return
	 */
	public ArrayList<CETGrade> queryCETGrade(String openid);

	/**
	 * 根据Openid查找学生的考试安排
	 * 
	 * @param openid
	 * @return
	 */
	public ArrayList<ExamPlan> queryExamPlan(String openid);

	/**
	 * 根据关键字查找课程信息
	 * 
	 * @param keyword
	 * @param pageno
	 * @return
	 */
	public ArrayList<Course> queryCoursesByKeyword(String keyword, int pageno);

	/**
	 * 根据courseid获取model中的course对象
	 * 
	 * @param courseid
	 * @return
	 */
	public com.welearn.model.Course queryCourseModleByCourseId(int courseid);

	/**
	 * 根据课程id查找课程通知
	 * @param courseId
	 * @param pageNo
	 * @param pageItemNo
	 * @return
	 */
	public ArrayList<com.welearn.model.CourseNotify> queryCourseNotify(
			int courseId, int pageNo, int pageItemNo);

    /**
     * 根据学生id查找最新课程通知
     * @param studentid
     * @param pageNo
     * @param pageItemNo
     * @return
     */
	public ArrayList<com.welearn.model.CourseNotify> queryCourseNotifyNew(
			int studentid, int pageNo, int pageItemNo);

	/**
	 * 根据课程id查找课程作业
	 * 
	 * @param courseId
	 * @return
	 */
	public ArrayList<com.welearn.model.CourseHomework> queryCourseHomework(
			int courseId, int pageNo, int pageItemNo);

	/**
	 * 根据学生id查找其作业通知
	 * @param studentid
	 * @param pageNo
	 * @param pageItemNo
	 * @return
	 */
	public ArrayList<com.welearn.model.CourseHomework> queryCourseHomeworkNew(
			int studentid, int pageNo, int pageItemNo);
	
	/**
	 * 根据学生的id获取该学生这学期上的课程
	 * 
	 * @param studentId
	 * @return
	 */
	public ArrayList<Semester> querySemesterByStudentId(int studentId);

	/**
	 * 获取该学生各个学期的成绩
	 * 
	 * @param studentId
	 * @return
	 */
	public Map<String, ArrayList<Course>> querySemesterCourseByStudentId(
			int studentId);

	/**
	 * 查询该同学上过的课程
	 * 
	 * @param studentId
	 * @return
	 */
	public ArrayList<Course> queryCoursesByStudentId(int studentId);
	
	
	/**
	 * 添加课程反馈
	 * 
	 * @param courseid
	 * @param content
	 * @param anonymous
	 * @param studentid
	 * @return
	 */
	public boolean addFeedback(int courseid, String content, boolean anonymous,
			String studentName);

	/**
	 * 查找在一个时间之前的聊天记录
	 * 
	 * @param courseid
	 * @param studentid
	 * @param date
	 * @return
	 */
	public ArrayList<CourseDiscuss> queryDiscussesBefore(int courseid,
			int studentid, Date date);

	/**
	 * 查找在一个时间之后的聊天记录
	 * 
	 * @param courseid
	 * @param studentid
	 * @param date
	 * @return
	 */
	public ArrayList<CourseDiscuss> queryDiscussesAfter(int courseid,
			int studentid, Date date);

	/**
	 * 发送一条消息
	 * 
	 * @param courseid
	 * @param studentid
	 * @param content
	 * @return
	 */
	public boolean addDiscussContent(int courseid, int studentid, String content);

	/**
	 * 查找数据库中的答题记录
	 * 
	 * @param courseid
	 * @param studentid
	 * @param pageNo
	 * @return
	 */
	public ArrayList<CourseTestResult> queryCourseExamResult(int courseid,
			int studentid, int pageNo);

	/**
	 * 生成评测的问题
	 * 
	 * @param courseid
	 * @param problemNum
	 *            生成的问题数量
	 * @return
	 */
	public ArrayList<CourseProblem> generateCourseProblems(int courseid);
	
	/**
	 * 插入一条
	 * @param courseid
	 * @param studentid
	 * @param spendTime
	 * @param finishTime
	 * @param score
	 * @param answer
	 * @return
	 */
	public boolean addCourseExamRecord(int courseid,int studentid,int spendTime,Date finishTime,int score,String answer);
	
	/**
	 * 获取课程成绩
	 * @param answer
	 * @return
	 */
	public int getCourseScore(String answer);
	
	/**
	 * 获得打错的题目信息
	 * @param answer
	 * @return
	 */
	public ArrayList<CourseProblem> getWrongCourseProblems(String answer);
}
