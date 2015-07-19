package com.welearn.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.util.InfoCode;
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
		this.hql = "FROM AttendRecord AS u inner join fetch u.attendTaskEntity inner join fetch u.studentEntity WHERE u.attendTaskId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, attendTaskId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<AttendRecord> getAttendRecordsByStudent(int studentId, int pageNo, int pageItemNum) {
		this.hql = "FROM AttendRecord AS u inner join fetch u.attendTaskEntity inner join fetch u.studentEntity WHERE u.studentid=?";
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
				+ "inner join fetch b.attendTaskEntity inner join fetch b.studentEntity"
				+ "where a.startTime=? "
				+ "and a.endTime=? "
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
		
		/*this.hql = "select b from AttendTask AS a, AttendRecord AS b "
				+ "inner join fetch b.attendTaskEntity inner join fetch b.studentEntity"
				+ "where a.id = b.attendTaskId and a.courseId=?";*/
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 根据学生名字查询签到记录
	 * @param name
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByName(String name, int pageNo, int pageItemNum){
		
		/*this.hql = "select b from AttendTask AS a, AttendRecord AS b "
				+ "inner join fetch b.attendTaskEntity inner join fetch b.studentEntity"
				+ "where a.id = b.attendTaskId and a.name=?";*/
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 根据学生的学号查找学生的签到记录
	 * @param studentNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByStrudentNo(String studentNo, int pageNo, int pageItemNum){
		
		/*this.hql = "select b from Student AS a, AttendRecord AS b "
				+ "inner join fetch b.attendTaskEntity inner join fetch b.studentEntity"
				+ "where a.id = b.studentid and a.studentNo=?";*/
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, studentNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
	/**
	 * 根据学生的真实姓名查找学生的签到记录
	 * @param studentNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<AttendRecord> getAttendRecordsByStrudentTruename(String truename, int pageNo, int pageItemNum){
		
		/*this.hql = "select b from Student AS a, AttendRecord AS b "
				+ "inner join fetch b.attendTaskEntity inner join fetch b.studentEntity"
				+ "where a.id = b.studentid and a.trueName=?";*/
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, truename);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
	public boolean updateAttendRecord(AttendRecord attendRecord) {
		this.sessionFactory.getCurrentSession().update(attendRecord);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public AttendRecord getAttendRecord(int studentId, int attendTaskId) {
		hql = "from AttendRecord as a where a.studentid=? and a.attendTaskId=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, studentId);
		query.setInteger(1, attendTaskId);
		return (AttendRecord)query.uniqueResult();
	}
	
	/**
	 * 查询等待签到记录
	 * @param attendRecord
	 * @return
	 */
	public AttendRecord getWaitingAttendRecord(int stuId) {
		hql = "from AttendRecord as a where a.studentid=? and a.status=? order by a.logTime desc";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, stuId);
		query.setInteger(1, InfoCode.ATTEND_PREPARE);
		AttendRecord res = null;
		List<AttendRecord> list = query.list();
		if(list.size() > 0) { //找到该学生最近的一次签到任务
			res = list.get(0);
		}
		return res;
		
	}
	
	public List<AttendRecord> getAttendRecordsByStudentIdandTime(int studentId, int status, Date time){
		this.hql = "from AttendTask as a where a.startTime < :time and a.endTime > :timee";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("time", time);
		query.setParameter("timee", time);
		List<AttendTask> attendTasks = query.list();
		List<Integer> attendTaskIds = new ArrayList<Integer>();
		/*System.out.println("++++++++++++++++++"+attendTasks.size());
		for(int i=0;i<attendTasks.size();i++){
			attendTaskIds.add(i, attendTasks.get(i).getId());
			System.out.println(attendTasks.get(i).getId());
		}*/
		
		this.hql = "from AttendRecord AS b inner join fetch b.attendTaskEntity"
				+ " where b.studentid = :studentid and b.status = :statuss and b.attendTaskId IN (:attendtasklist)";
		Query query2 = sessionFactory.getCurrentSession().createQuery(hql);
		query2.setParameter("studentid", studentId);
		query2.setParameter("statuss", status);
		// and b.status = :statuss
		query2.setParameterList("attendtasklist", attendTaskIds);
		//and b.attendTaskId IN (:attendtasklist)
		
		List<AttendRecord> result = query2.list();
		/*System.out.println("-----------111111111111-----------"+result.size());
		for(int i=0;i<result.size();i++){
			System.out.println(result.get(i).toString());
		}*/
		
		return result;
	}
	
	public AttendRecord getAttendRecordsById(int id) {
		hql = "from AttendRecord as a inner join fetch a.attendTaskEntity where a.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, id);
		AttendRecord result = (AttendRecord) query.uniqueResult();
		//System.out.println(result.toString());
		
		return result;
	}
}
