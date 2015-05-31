package com.welearn.dao;

import java.util.Date;
import java.util.List;

import com.welearn.entity.AttendRecord;

public class AttendRecordDao {

	public Integer addAttendRecord(AttendRecord attendRecord) {
		return null;
	}
	
	public boolean delAttendRecord(int id) {
		return false;
	}
	
	public boolean delAttendRecordByStudent(int studentId) {
		return false;
	}
	
	public List getAttendRecordsByTask(int attendTaskId, int pageNo, int pageItemNum) {
		return null;
	}
	
	public List getAttendRecordsByStudent(int studentId, int pageNo, int pageItemNum) {
		return null;
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
		return null;
	}
	
	public boolean updateAttendRecord(AttendRecord attendRecord) {
		return false;
		
	}
}
