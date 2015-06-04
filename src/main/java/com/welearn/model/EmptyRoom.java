package com.welearn.model;

public class EmptyRoom {

	private String currDate;
	
	private String week;
	
	private String builing;
	
	private String roomName;
	
	private String section; //节次
	
	private String status;

	public EmptyRoom(String jsonObjStr) {
		//把json串解析之后给每个属性赋值
		
		
	}

	public String getCurrDate() {
		return currDate;
	}

	public void setCurrDate(String currDate) {
		this.currDate = currDate;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getBuiling() {
		return builing;
	}

	public void setBuiling(String builing) {
		this.builing = builing;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
