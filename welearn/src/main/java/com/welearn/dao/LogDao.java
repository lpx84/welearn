package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Log;

public class LogDao extends SuperDao{

	/**
	 * 新增一条日志
	 * @param log
	 * @return
	 */
	public Integer addLog(Log log){
		return (Integer)this.sessionFactory.getCurrentSession().save(log);
	}
	
	/**
	 * 通过id删除日志
	 * @param id
	 * @return
	 */
	public boolean delLog(int id){
		this.hql = "DELETE FROM Log AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 通过用户删除日志
	 * @param user
	 * @return
	 */
	public boolean delLogByUser(String user){
		this.hql = "DELETE FROM Log AS u WHERE u.user=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, user);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 通过一条新日志更新日志
	 * @param newlog
	 * @return
	 */
	public boolean updateLog(Log newlog){
		this.sessionFactory.getCurrentSession().update(newlog);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 查找与用户有关的所有日志
	 * @param user
	 * @return
	 */
	public List<Log> getLogByUser(String user) {
		this.hql = "from Log as a where a.user=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, user);
		List<Log> result = query.list();
		return result;
	}
	
	/**
	 * 通过id获得日志的一条记录
	 * @param id
	 * @return
	 */
	public Log getLogById(int id){
		
		return null;
	}
	
	/**
	 * 通过实践查找log记录
	 * @param logTime
	 * @return
	 */
	public List<Log> getLogByTime(Date logTime) {
		this.hql = "from Log as a where a.log_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, logTime);
		List<Log> result = query.list();
		return result;
	}
}
