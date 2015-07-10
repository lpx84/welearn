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
		this.hql = "FROM Course AS u WHERE u.course_no=?";
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
}
