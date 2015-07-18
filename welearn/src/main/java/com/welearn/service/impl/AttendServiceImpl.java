package com.welearn.service.impl;

import java.util.ArrayList;

import com.welearn.dao.AttendRecordDao;
import com.welearn.dao.AttendTaskDao;
import com.welearn.entity.AttendTask;
import com.welearn.model.AttendRecord;
import com.welearn.service.intef.AttendService;
import com.welearn.util.TimeUtil;

public class AttendServiceImpl implements AttendService {

	private AttendTaskDao attendTaskDao;
	private AttendRecordDao attendRecordDao;
	
	public void setAttendRecordDao(AttendRecordDao attendRecordDao) {
		this.attendRecordDao = attendRecordDao;
	}

	public void setAttendTaskDao(AttendTaskDao attendTaskDao) {
		this.attendTaskDao = attendTaskDao;
	}
	
	public ArrayList<AttendRecord> getAttendRecords(int courseId,
			int studentId) {
		ArrayList<AttendRecord> modelList = new ArrayList<AttendRecord>();
		ArrayList<AttendTask> taskList=(ArrayList<AttendTask>) attendTaskDao.getAttendTasksByCourseId(courseId) ;
		for(int i=0;i<taskList.size();i++){
			AttendRecord record = new AttendRecord();
			//获取该签到任务下的该学生的签到信息
			com.welearn.entity.AttendRecord record2 = attendRecordDao.getAttendRecord(studentId, taskList.get(i).getId());
			if(record2 != null){
				record.setContent(taskList.get(i).getName());
				record.setPicUrl(record2.getPicUrl());
				record.setState(record2.getStatus());
				record.setTime(TimeUtil.formatDate1(record2.getLogTime()));
				modelList.add(record);
			}	
		}		
		
		return modelList;
	}
	
	

}
