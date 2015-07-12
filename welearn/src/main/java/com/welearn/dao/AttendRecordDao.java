package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.AttendRecord;
import com.welearn.util.TimeUtil;

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
		this.hql = "DELETE FROM AttendRecord AS u WHERE u.studentid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		return query.executeUpdate() > 0;
	}
	
	public List<AttendRecord> getAttendRecordsByTask(int attendTaskId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendRecord AS u WHERE u.attendTaskId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, attendTaskId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<AttendRecord> getAttendRecordsByStudent(int studentId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendRecord AS u WHERE u.studentid=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据起止时间来查询签到信息列表
	 * @param startTimeStr
	 * @param endTimeStr
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByTime(Date startTimeStr, Date endTimeStr, int pageNo, int pageItemNum) {
		this.hql = "select b from AttendTask AS a, AttendRecord AS b "
				+ "where a.start_time='?' "
				+ "and a.end_time=to_days'?' "
				+ "and a.id = b.attendTaskId";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		
		query.setDate(0, startTimeStr);
		query.setDate(1, endTimeStr);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据课程查询签到记录
	 * @param courseId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByCourseId(int courseId, int pageNo, int pageItemNum){
		
		this.hql = "select b from AttendTask AS a, AttendRecord AS b "
				+ "where a.id = b.attend_task_id and a.course_id=?";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据学生名字查询签到记录
	 * @param name
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByName(String name, int pageNo, int pageItemNum){
		
		this.hql = "select b from AttendTask AS a, AttendRecord AS b "
				+ "where a.id = b.attend_task_id and a.name=?";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据学生的学号查找学生的签到记录
	 * @param studentNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByStrudentNo(String studentNo, int pageNo, int pageItemNum){
		
		this.hql = "select b from Student AS a, AttendRecord AS b "
				+ "where a.id = b.student_id and a.student_no=?";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, studentNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	/**
	 * 根据学生的真实姓名查找学生的签到记录
	 * @param studentNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByStrudentTruename(String truename, int pageNo, int pageItemNum){
		
		this.hql = "select b from Student AS a, AttendRecord AS b "
				+ "where a.id = b.student_id and a.true_name=?";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, truename);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public boolean updateAttendRecord(AttendRecord attendRecord) {
		this.sessionFactory.getCurrentSession().update(attendRecord);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
}
