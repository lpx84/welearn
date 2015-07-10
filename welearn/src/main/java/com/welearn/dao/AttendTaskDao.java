package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.AttendTask;

public class AttendTaskDao extends SuperDao {

	public Integer addAttendTask(AttendTask task) {
		return (Integer)this.sessionFactory.getCurrentSession().save(task);
	}
	
	public boolean delAttendTask(int id) {
		this.hql = "DELETE FROM AttendTask AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delAttendTaskByCourse(int courseId) {
		this.hql = "DELETE FROM AttendTask AS u WHERE u.course_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 指定课程下的所有签到任务
	 * @param courseId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByCourse(int courseId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendTask AS u WHERE u.academy_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 查询在某个时间段内的所有签到
	 * @param start
	 * @param end
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByTime(Date start, Date end, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendTask AS u WHERE u.start_time=? AND u.end_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, start);
		query.setDate(1, end);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public boolean updateAttendTask(AttendTask attendTask) {
		this.sessionFactory.getCurrentSession().update(attendTask);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	
	
}
