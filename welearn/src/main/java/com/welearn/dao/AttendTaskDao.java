package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.AttendTask;
import com.welearn.util.TimeUtil;

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
		this.hql = "DELETE FROM AttendTask AS u WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.executeUpdate() > 0;
	}
	/**
	 * 根据id获得签到任务
	 * @param id
	 * @return
	 */
	public AttendTask getAttendTaskById(int id){
		this.hql = "FROM AttendTask AS u inner join fetch u.courseEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setMaxResults(id);
		return (AttendTask) query.uniqueResult();
	}
	
	/**
	 * 指定课程下的所有签到任务
	 * @param courseId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByCourse(int courseId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendTask AS u inner join fetch u.courseEntity WHERE u.courseId=?";
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
		this.hql = "select a from AttendTask as a "
				+ "inner join fetch a.courseEntity"
				+ "where startTime=? and endTime=?";
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, start);
		query.setDate(1, end);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 根据课程编号查询课程任务
	 * @param courseNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByCourseNo(String courseNo, int pageNo, int pageItemNum) {
		/*this.hql = "select b from Course AS a, AttendTask AS b "
				+ "inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.courseNo=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 根据老师的ID查找签到任务
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByTeacherId(int teacherId, int pageNo, int pageItemNum) {
		/*this.hql = "select b from Course AS a, AttendTask AS b "
				+ "inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.teacherId=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 根据课程名字查找签到任务
	 * @param courseName
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByCourseName(String courseName, int pageNo, int pageItemNum) {
		/*this.hql = "select b from Course AS a, AttendTask AS b "
				+ "inner join fetch b.courseEntity"
				+ "where a.id=b.coursId and a.name=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseName);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 通过学生的id查询他所签过到的任务
	 * @param studentId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendTask> getAttendTasksByStudentId(int studentId, int pageNo, int pageItemNum) {
		/*this.hql = "select b from AttendRecord AS a, AttendTask AS b "
				+ "inner join fetch b.courseEntity"
				+ "where a.attendTaskId=b.id and a.studentid=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
	public boolean updateAttendTask(AttendTask attendTask) {
		this.sessionFactory.getCurrentSession().update(attendTask);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	
}
