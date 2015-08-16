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
	private Long attendNum;
	private Long stuNum;

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

	public Long getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(Long attendNum) {
		this.attendNum = attendNum;
	}

	public Long getStuNum() {
		return stuNum;
	}

	public void setStuNum(Long stuNum) {
		this.stuNum = stuNum;
	}

}
