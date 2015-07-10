package com.welearn.dao;

import java.util.List;
import org.hibernate.Query;
import com.welearn.entity.TimeCourse;

public class TimeCourseDao extends SuperDao {

	public Integer addTimeCourse(TimeCourse timeCourse){
		return (Integer)this.sessionFactory.getCurrentSession().save(timeCourse);
	}
	
	public boolean delTimeCourseById(int id){
		this.hql = "DELETE FROM TimeCourseById AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTimeCourseByCourseId(int courseid){
		this.hql = "DELETE FROM TimeCourseById AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTimeCourseByTimeId(int timeId){
		this.hql = "DELETE FROM TimeCourseById AS u WHERE u.time_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, timeId);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateTimeCourse(TimeCourse timeCourse){
		this.sessionFactory.getCurrentSession().update(timeCourse);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public TimeCourse getTimeCourseById(int id){
		this.hql = "FROM TimeCourse AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (TimeCourse) query.uniqueResult();
	}
	
	public List<TimeCourse> getTimeCourseByCourseId(int courseid){
		this.hql = "from TimeCourse as a where a.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<TimeCourse> result = query.list();
		return result;
	}
	
	public List<TimeCourse> getTimeCourseByTimeId(int timeid){
		this.hql = "from TimeCourse as a where a.time_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, timeid);
		List<TimeCourse> result = query.list();
		return result;
	}
}
