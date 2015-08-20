package com.welearn.service.intef;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.StudentCourse;
import com.welearn.entity.Teacher;
import com.welearn.view.View;

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
	public List<StudentCourse> getStudentList();
	
	public List<StudentCourse> getStudentListByCourseId(int id);
	
	/**
	 * 添加签到任务
	 * @param attendTask
	 * @return
	 */
	public boolean publishAttendTask(AttendTask attendTask);
	
	public AttendTask getAttendTaskById(int id);

	public boolean updateAttendTask(AttendTask attendTask);
	
	//签到记录
	public AttendRecord getAttendRecordByAttendTaskId(int id);
	
	//课程通知
	public boolean publisCourseNotify(CourseNotify courseNotify);
	
	public CourseNotify getCourseNotifyById(int id);
	
	public boolean updateCourseNotify(CourseNotify courseNotify);
	
    /**
     * 根据openid来判断是否已经绑定
     * @param openid
     * @return
     */
    public boolean checkBindByOpenId(String openid);
	
    /**
     * 根据用户的openid验证用户是否登录，返回相应的界面，若界面为空，则返回null
     * @param openid
     * @return
     */
	public View checkUser(String openid);
	
	/**
	 * 设置session
	 * @param session
	 * @param openid
	 */
	public void setSession(HttpSession session,String openid);

	/**
	 * 根据教师NO获取教师信息
	 * @param teacherNo
	 * @return
	 */
	public Teacher getTeacherByTeacherNo(String teacherNo);
	
	/**
	 * 更新teacher信息
	 * @param teacher
	 * @return
	 */
	public boolean updateTeacher(Teacher teacher);
		
	/**
	 * 获取这门课的所有签到任务
	 * @param courseId
	 * @return
	 */
	public ArrayList<com.welearn.model.AttendTask> getAttendTasks(int courseId);
	
	/**
	 * 获取该签到任务的具体签到记录
	 * @param taskId
	 * @param courseId
	 * @return
	 */
	public ArrayList<com.welearn.model.AttendRecord> getAttendRecords(int taskId,int courseId);
	
	/**
	 * 获取各个状态的数量
	 * @param taskId
	 * @return
	 */
	public int[] getAttendStateNum(int taskId);
	
	/**
	 * 一键通过
	 * @param taskId
	 * @return
	 */
	public boolean passAll(int taskId);
	
	/**
	 * 通过类型，0表示不通过，1表示通过
	 * @param recordId
	 * @param passType
	 * @return
	 */
    public boolean pass(int recordId,int passType);
	
	public void test();
	
}
