package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.TimeCourse;

public class TimeCourseDao extends SuperDao {
	
	public Integer addTimeCourse(TimeCourse timeCourse){
		return (Integer)this.sessionFactory.getCurrentSession().save(timeCourse);
	}
	
	public boolean delTimeCourseById(int id){
		this.hql = "DELETE FROM TimeCourse AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTimeCourseByCourseIdAndTimeId(int courseId, int timeId){
		this.hql = "DELETE FROM TimeCourse AS u WHERE u.courseId=? AND u.timeId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		query.setInteger(1, timeId);		
		return query.executeUpdate() > 0;
	}
	
	public boolean updateTimeCourse(TimeCourse timeCourse){
		this.sessionFactory.getCurrentSession().update(timeCourse);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public TimeCourse getTimeCourseById(int id){
		this.hql = "FROM TimeCourse AS u"
				+ " inner join fetch u.courseEntity inner join fetch u.courseTimeEntity "
				+ "WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (TimeCourse) query.uniqueResult();
	}
	

	
	@SuppressWarnings("unchecked")
	public List<TimeCourse> getTimeCourseByCourseId(int courseId){
		this.hql = "FROM TimeCourse AS u"
				+ " inner join fetch u.courseEntity as a inner join fetch u.courseTimeEntity "
				+ "WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.list();
	}

}
