package com.welearn.dao;

import java.util.Date;
import java.util.List;

import com.welearn.entity.AttendTask;

public class AttendTaskDao {

	public Integer addAttendTask(AttendTask task) {
		return null;
	}
	
	public boolean delAttendTask(int id) {
		return false;
	}
	
	public boolean delAttendTaskByCourse(int courseId) {
		return false;
	}
	
	/**
	 * 指定课程下的所有签到任务
	 * @param courseId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List getAttendTasksByCourse(int courseId, int pageNo, int pageItemNum) {
		return null;
		
	}
	
	/**
	 * 查询在某个时间段内的所有签到
	 * @param start
	 * @param end
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List getAttendTasksByTime(Date start, Date end, int pageNo, int pageItemNum) {
		return null;
	}
	
	public boolean updateAttendTask(AttendTask attendTask) {
		return false;
		
	}
	
}
