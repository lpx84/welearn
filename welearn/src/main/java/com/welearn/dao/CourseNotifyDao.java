package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseNotify;

public class CourseNotifyDao extends SuperDao {

	public Integer addCourseNotify(CourseNotify courseNotify){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseNotify);
	}
	
	public boolean delCourseNotifyById(int id){
		this.hql = "DELETE FROM CourseNotify AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseNotifyByCourseId(int courseID){
		this.hql = "DELETE FROM CourseNotify AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseID);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseNotifyByCreateTime(Date createTime){
		this.hql = "DELETE FROM CourseNotify AS u WHERE u.create_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, createTime);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseNotify(CourseNotify courseNotify){
		this.sessionFactory.getCurrentSession().update(courseNotify);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseNotify getCourseNotifyById(int id){
		this.hql = "FROM CourseNotify AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseNotify) query.uniqueResult();
	}
	
	public List<CourseNotify> getCourseNotifyByCourseId(int courseid){
		this.hql = "from CourseNotify as a where a.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseNotify> result = query.list();
		return result;
	}
	
	public List<CourseNotify> getCourseNotifyByCreateTime(Date createTime){
		this.hql = "from CourseNotify as a where a.create_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, createTime);
		List<CourseNotify> result = query.list();
		return result;
	}
}
