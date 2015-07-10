package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseProblem;

public class CourseProblemDao extends SuperDao {
	
	public Integer addCourseProblem(CourseProblem courseProblem){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseProblem);
	}
	
	public boolean delCourseProblemById(int id){
		this.hql = "DELETE FROM CourseProblem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseProblemByAnswerId(int answerid){
		this.hql = "DELETE FROM CourseProblem AS u WHERE u.answer_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, answerid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseProblem(CourseProblem courseProblem){
		this.sessionFactory.getCurrentSession().update(courseProblem);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseProblem getCourseProblemById(int id){
		this.hql = "FROM CourseProblem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseProblem) query.uniqueResult();
	}
	
	public List<CourseProblem> getCourseProblemByAnswerId(int answerid){
		this.hql = "from CourseProblem as a where a.answer_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, answerid);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByComment(String comment){
		this.hql = "from CourseProblem as a where a.comment like '%"+comment+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByContent(String content){
		this.hql = "from CourseProblem as a where a.comment like '%"+content+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<CourseProblem> result = query.list();
		return result;
	}
	
	public List<CourseProblem> getCourseProblemByCourseId(int courseid){
		this.hql = "from CourseProblem as a where a.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseProblem> result = query.list();
		return result;
	}
}
