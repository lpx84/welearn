package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Course;
import com.welearn.entity.CourseProblem;

public class CourseDao  extends SuperDao {

	public Integer addCourse(Course course) {
		return (Integer)this.sessionFactory.getCurrentSession().save(course);
	}
	
	public boolean delCourse(int id) {
		this.hql = "DELETE FROM Course AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseByCourseNo(String courseNo) {
		this.hql = "DELETE FROM Course AS u WHERE u.course_no=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourse(Course course) {
		this.sessionFactory.getCurrentSession().update(course);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 根据课程主键查询实体
	 * @param id 课程主键
	 * @return
	 */
	public Course getCourse(int id) {
		this.hql = "FROM Course AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (Course) query.uniqueResult();
	}
	
	/**
	 * 根据课程号查询实体
	 * @param courseNo 课程号
	 * @return
	 */
	public Course getCourseByCourseNo(String courseNo) {
		this.hql = "FROM Course AS u WHERE u.course_no='?'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		return (Course) query.uniqueResult();
	}
	
	/**
	 * 老师的课程列表
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<Course> getCoursesByTeacher(int teacherId, int pageNo, int pageItemNum) {
		this.hql = "FROM Course AS u WHERE u.teacher_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<Course> getCoursesByName(String name, int pageNo, int pageItemNum) {
		this.hql = "FROM Course AS u WHERE u.name like '%"+name+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 通过weekday查找课程列表
	 * @param weekday
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_time AS a, bjtu_course AS b where a.course_id=b.id and weekday=1;
	public List<Course> getCoursesByWeekday(int weekday, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_time AS a, bjtu_course AS b "
				+ "where a.course_id=b.id and a.weekday=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, weekday);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 通过weekno查找课程列表
	 * @param weekno
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 * .
	 */
	public List<Course> getCoursesByWeekNo(int weekno, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_time AS a, bjtu_course AS b "
				+ "where a.course_id=b.id and a.week_no=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, weekno);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据签到任务获得课程列表
	 * @param attendTaskId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_attend_task AS a,bjtu_course AS b where a.course_id=b.id and a.id=1;
	public List<Course> getCoursesByAttendTaskId(int attendTaskId, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_attend_task AS a,bjtu_course AS b "
				+ "where a.course_id=b.id and a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, attendTaskId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据学生的id获得课程记录，是从选课表查询
	 * @param studentId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_student_course AS a, bjtu_course AS b where a.course_id = b.id and student_id = 1;
	public List<Course> getCoursesByStudentId(int studentId, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_student_course AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.student_id =?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据作业的id获得课程信息
	 * @param homeworkId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_homework AS a, bjtu_course AS b where a.course_id = b.id and a.id = 1;
	public List<Course> getCoursesByHomeworkId(int homeworkId, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_homework AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.id = ?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, homeworkId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据作业的标题查询课程信息，支持模糊查询
	 * @param title
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_homework AS a, bjtu_course AS b where a.course_id = b.id and a.title like '%方法论%';
	public List<Course> getCoursesByHomeworkTitle(String title, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_homework AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.title like '%"+title+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setInteger(0, homeworkId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据提示的标题查找课程信息，支持模糊查询
	 * @param title
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_notify AS a, bjtu_course AS b where a.course_id = b.id and a.title like '%提示%';
	public List<Course> getCoursesByNotifyTitle(String title, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_notify AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.title like '%"+title+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setInteger(0, homeworkId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据提示的内容查找课程信息，支持模糊查询
	 * @param content
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_notify AS a, bjtu_course AS b where a.course_id = b.id and a.content like '%提示%';
	public List<Course> getCoursesByNotifyContent(String content, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_notify AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.content like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setInteger(0, homeworkId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据课程回复的replyor查找课程信息，精确查找
	 * @param replyor
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_reply AS a, bjtu_course AS b where a.course_id = b.id and a.replyor = 'Tom';
	public List<Course> getCoursesByReplyor(String replyor, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_reply AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.replyor = '?'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, replyor);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据课程回复的内容查找课程信息，支持模糊查询
	 * @param content
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_reply AS a, bjtu_course AS b where a.course_id = b.id and a.content like '%选项%';
	public List<Course> getCoursesByReplyContent(String content, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_reply AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.content like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setString(0, replyor);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据问题的id查找课程信息
	 * @param problemId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course_problem AS a, bjtu_course AS b where a.course_id = b.id and a.id=1;
	public List<Course> getCoursesByProblemId(int problemId, int pageNo, int pageItemNum) {
		this.hql = "select b from bjtu_course_problem AS a, bjtu_course AS b "
				+ "where a.course_id = b.id and a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, problemId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
}
