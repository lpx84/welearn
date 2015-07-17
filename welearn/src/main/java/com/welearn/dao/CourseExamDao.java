package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseExam;

public class CourseExamDao extends SuperDao {
	
	public Integer addCourseExam(CourseExam courseExam){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseExam);
	}
	
	public boolean delCourseExamById(int id){
		this.hql = "DELETE FROM CourseExam AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseExam(CourseExam courseExam){
		this.sessionFactory.getCurrentSession().update(courseExam);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseExam getCourseExamById(int id){
		this.hql = "FROM CourseExam AS u join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.id=? order by u.finishId desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseExam) query.uniqueResult();
	}
	
	public List<CourseExam> getCourseExamByCourseId(int courseId){
		this.hql = "FROM CourseExam AS u join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.courseId=? order by u.finishId desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.list();
	}

	public List<CourseExam> getCourseExamByCourseId(int courseId, int pageNo, int pageItemNum){
		this.hql = "FROM CourseExam AS u join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.courseId=? order by u.finishId desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	
}
