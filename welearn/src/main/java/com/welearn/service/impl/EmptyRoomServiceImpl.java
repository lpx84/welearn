package com.welearn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.welearn.model.Building;
import com.welearn.model.EmptyRoom;
import com.welearn.service.intef.EmptyRoomService;


public class EmptyRoomServiceImpl implements EmptyRoomService {

	
	
	public List<Building> getBuildings() {
		List<Building> buildingList = new ArrayList<Building>();
		//Todo 未全部添加所有的教学楼
		buildingList.add(new Building("yf","逸夫楼"));
		buildingList.add(new Building("sy","思源楼"));
		buildingList.add(new Building("sd","思源东楼"));
		buildingList.add(new Building("sx","思源西楼"));
		
		return buildingList;
	}

	public List<EmptyRoom> getEmptyRooms(Date date) {
//		//获取空教室的urp字符串
//		UrpHandler urpHandler = new UrpHandler();
//		String roomJsonStr = urpHandler.getEmptyRoom();
//		//将空教室字符串转换成列表
//		List<EmptyRoom> emptyRooms = JsonUtil.jsonListStrToList(roomJsonStr);
				
		//此处是模拟生成
		List<EmptyRoom> emptyRooms = new ArrayList<EmptyRoom>();
		
		EmptyRoom emptyRoom  = new EmptyRoom();
		emptyRoom.setBuilding("逸夫楼");
		emptyRoom.setBuildingCode("yf");
		emptyRoom.setRoomName("yf101");
		ArrayList<String> status= new ArrayList<String>();
		status.add("有课");
		status.add("有课");
		status.add("有课");
		status.add("空");
		status.add("借用");
		status.add("有课");
		status.add("有课");
		emptyRoom.setStatus(status);
		emptyRooms.add(emptyRoom);
		
		emptyRoom  = new EmptyRoom();
		emptyRoom.setBuilding("思源楼");
		emptyRoom.setBuildingCode("sy");
		emptyRoom.setRoomName("sy102");
		status= new ArrayList<String>();
		status.add("有课");
		status.add("有课");
		status.add("有课");
		status.add("空");
		status.add("借用");
		status.add("有课");
		status.add("有课");
		emptyRoom.setStatus(status);
		emptyRooms.add(emptyRoom);
		return emptyRooms;
	}

}
