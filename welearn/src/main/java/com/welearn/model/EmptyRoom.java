package com.welearn.model;


import java.util.List;

public class EmptyRoom {


	private String building;//教学楼名称
	
	private String buildingCode;//教学楼代号
	
	private String roomName;//教室名
		
	private List<String> status;//各个节次的状态

	public EmptyRoom(String jsonObjStr) {
		//把json串解析之后给每个属性赋值
		
		
	}

	public EmptyRoom() {
		
	}
	
	
	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getBuildingCode() {
		return buildingCode;
	}

	public void setBuildingCode(String buildingCode) {
		this.buildingCode = buildingCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<String> getStatus() {
		return status;
	}

	public void setStatus(List<String> status) {
		this.status = status;
	}
	
}
