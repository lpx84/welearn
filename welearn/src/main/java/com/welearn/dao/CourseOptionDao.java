package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseOption;

public class CourseOptionDao extends SuperDao {

	public Integer addCourseOption(CourseOption courseOption){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseOption);
	}
	
	public boolean delCourseOptionById(int id){
		this.hql = "DELETE FROM CourseOption AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseOptionByProblemId(int problemid){
		this.hql = "DELETE FROM CourseOption AS u WHERE u.problem_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, problemid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseOption(CourseOption courseOption){
		this.sessionFactory.getCurrentSession().update(courseOption);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseOption getCourseOptionById(int id){
		this.hql = "FROM CourseOption AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseOption) query.uniqueResult();
	}
	
	public List<CourseOption> getCourseOptionByProblemId(int problemId){
		this.hql = "from CourseOption as a where a.problem_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseOption> result = query.list();
		return result;
	}
	
	public List<CourseOption> getCourseOptionByContent(String content){
		this.hql = "from CourseOption as a where a.content like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseOption> result = query.list();
		return result;
	}
}
