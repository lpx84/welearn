package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.CourseHomework;

public class CourseHomeworkDao extends SuperDao {

	public Integer addCourseHomework(CourseHomework courseHomework){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseHomework);
	}
	
	public boolean delCourseHomeworkById(int id){
		this.hql = "DELETE FROM CourseHomework AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseHomerworkByCourseId(int courseid){
		this.hql = "DELETE FROM CourseHomework AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseHomework(CourseHomework courseHomework){
		this.sessionFactory.getCurrentSession().update(courseHomework);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseHomework getCourseHomeworkById(int id){
		this.hql = "FROM CourseHomework AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseHomework) query.uniqueResult();
	}
	
	public List<CourseHomework> getCourseHomeworkByContent(String content){
		this.hql = "from CourseHomework as a where a.content like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByCourseId(int courseid){
		this.hql = "FROM CourseHomework AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByTitle(String title){
		this.hql = "from CourseHomework as a where a.content like '%"+title+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByDeadline(Date deadline){
		this.hql = "FROM CourseHomework AS u WHERE u.deadline=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, deadline);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByCreateTime(Date createTime){
		this.hql = "FROM CourseHomework AS u WHERE u.create_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, createTime);
		List<CourseHomework> result = query.list();
		return result;
	}
}
