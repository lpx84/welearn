package com.welearn.model;
/**
 * 用于签到任务的显示
 * @author SilentKim
 *
 */
public class AttendTask {
	private int attendId;
	private String content;
	private String startTime;
	private String endTime;
	private int attendNum;
	private int stuNum;

	public int getAttendId() {
		return attendId;
	}

	public void setAttendId(int attendId) {
		this.attendId = attendId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(int attendNum) {
		this.attendNum = attendNum;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

}
