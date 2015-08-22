package com.welearn.service.intef;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.welearn.model.AttendRecord;

public interface AttendService {
	/**
	 * 查找学生的签到信息
	 * @param courseId
	 * @param studentId
	 * @return
	 */
    public ArrayList<AttendRecord> getAttendRecords(int courseId,int studentId);
    
    public List getAttendRecordsByStudentIdandTime(int studentId, int status, Date time);
	
}
