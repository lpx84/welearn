package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.CourseReply;

public class CourseReplyDao extends SuperDao {
	
	public Integer AddCourseReply(CourseReply courseReply){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseReply);
	}
	
	public boolean delCourseReplyById(int id){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseReplyByCourseId(int courseId){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseReplyByReplyor(String replyor){
		this.hql = "DELETE FROM CourseReply AS u WHERE u.replyor=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, replyor);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseReply(CourseReply courseReply){
		this.sessionFactory.getCurrentSession().update(courseReply);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseReply getCourseReplyById(int id){
		this.hql = "FROM CourseReply AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseReply) query.uniqueResult();
	}
	
	public List<CourseReply> getCourseReplyByCourseID(int courseid){
		this.hql = "from CourseReply as a where a.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseReply> result = query.list();
		return result;
	}
	
	public List<CourseReply> getCourseReplyByReplyor(String replyor){
		this.hql = "from CourseReply as a where a.replyor like '%"+ replyor + "%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseReply> result = query.list();
		return result;
	}

}
