package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

public class CourseComment extends SuperDao {

	public Integer addCourseComment(CourseComment courseComment){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseComment);
	}
	
	public boolean delCourseCommentById(int id){
		this.hql = "DELETE FROM CourseComment AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseComment(CourseComment courseComment){
		this.sessionFactory.getCurrentSession().update(courseComment);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseComment getCourseCommentById(int id){
		this.hql = "FROM CourseComment AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseComment) query.uniqueResult();
	}
	
	public List<CourseComment> getTeachersByStudentId(int student_id, int pageNo, int pageItemNum) {
		this.hql = "FROM CourseComment AS u WHERE u.student_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, student_id);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<CourseComment> getTeachersByCourseId(int course_id, int pageNo, int pageItemNum) {
		this.hql = "FROM CourseComment AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, course_id);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
}
