package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Course;
import com.welearn.entity.CourseFeedback;

public class CourseFeedbackDao extends SuperDao {

	public Integer addCourseFeedback(CourseFeedback courseFeedback){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseFeedback);
	}
	
	public boolean delCourseFeedbackById(int id){
		this.hql = "DELETE FROM CourseFeedback AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseFeedback(CourseFeedback courseFeedback){
		this.sessionFactory.getCurrentSession().update(courseFeedback);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseFeedback getCourseFeedbackById(int id){
		this.hql = "FROM CourseFeedback AS u inner join fetch u.courseEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseFeedback) query.uniqueResult();
	}
	
	public List<CourseFeedback> getCourseFeedbacksByCourseId(int courseId){
		this.hql = "FROM CourseFeedback AS u inner join fetch u.courseEntity WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.list();
	}
	
	public List<CourseFeedback> getCourseFeedbacksByStudentName(String studentName){
		this.hql = "FROM CourseFeedback AS u inner join fetch u.courseEntity WHERE u.studentName="+"studentName";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		return query.list();
	} 
}
