package com.welearn.dao;

import java.util.Date;
import java.util.List;

import com.welearn.entity.Log;

public class LogDao {

	/**
	 * 新增一条日志
	 * @param log
	 * @return
	 */
	public Integer addLog(Log log){
		return null;
	}
	
	/**
	 * 通过id删除日志
	 * @param id
	 * @return
	 */
	public boolean delLog(int id){
		return false;
	}
	
	/**
	 * 通过用户删除日志
	 * @param user
	 * @return
	 */
	public boolean delLogByUser(String user){
		return false;
	}
	
	/**
	 * 通过一条新日志更新日志
	 * @param newlog
	 * @return
	 */
	public boolean updateLog(Log newlog){
		return false;
	}
	
	/**
	 * 查找与用户有关的所有日志
	 * @param user
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<Log> getLogByUser(String user, int pageNo, int pageItemNum) {
		return null;
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
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<Log> getLogByTime(Date logTime, int pageNo, int pageItemNum) {
		return null;
	}
}
