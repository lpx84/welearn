package com.welearn.model;

/**
 * 用于签到记录的显示
 * 
 * @author SikentKim
 *
 */
public class AttendRecord {
	private String picUrl;
	private String content;
	private String time;
	private int state;

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
