package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.AttendRecord;

public class AttendRecordDao extends SuperDao {

	public Integer addAttendRecord(AttendRecord attendRecord) {
		return (Integer)this.sessionFactory.getCurrentSession().save(attendRecord);
	}
	
	public boolean delAttendRecord(int id) {
		this.hql = "DELETE FROM AttendRecord AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delAttendRecordByStudent(int studentId) {
		this.hql = "DELETE FROM AttendRecord AS u WHERE u.student_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		return query.executeUpdate() > 0;
	}
	
	public List<AttendRecord> getAttendRecordsByTask(int attendTaskId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendRecord AS u WHERE u.attend_task_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, attendTaskId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<AttendRecord> getAttendRecordsByStudent(int studentId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendRecord AS u WHERE u.student_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据起止时间来查询签到信息列表
	 * @param startTime
	 * @param endTime
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List getAttendRecordsByTime(Date startTime, Date endTime, int pageNo, int pageItemNum) {
		/*this.hql = "FROM AttendRecord AS u WHERE u.start_time=? AND u.end_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, startTime);
		query.setDate(1, endTime);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();*/
		return null;
	}
	
	public boolean updateAttendRecord(AttendRecord attendRecord) {
		this.sessionFactory.getCurrentSession().update(attendRecord);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
}
