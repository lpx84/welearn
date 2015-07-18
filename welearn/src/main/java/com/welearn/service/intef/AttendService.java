package com.welearn.service.intef;

import java.util.ArrayList;

import com.welearn.model.AttendRecord;

public interface AttendService {
	/**
	 * 查找学生的签到信息
	 * @param courseId
	 * @param studentId
	 * @return
	 */
    public ArrayList<AttendRecord> getAttendRecords(int courseId,int studentId);
	
}
