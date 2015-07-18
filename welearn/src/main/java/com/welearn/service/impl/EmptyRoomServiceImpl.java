package com.welearn.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.select.Elements;

import com.welearn.handler.urp.UrpHandler;
import com.welearn.model.Building;
import com.welearn.model.EmptyRoom;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.util.BuildingUtil;

public class EmptyRoomServiceImpl implements EmptyRoomService {

	public List<Building> getBuildings() {
		List<Building> buildingList = new ArrayList<Building>();
		Map<String, String> map = BuildingUtil.getBuildingLabel();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			map.get(key);
			buildingList.add(new Building(map.get(key), key));
		}

		return buildingList;
	}

	public List<EmptyRoom> getEmptyRooms(Date date) {
		UrpHandler urpHandler = new UrpHandler();
		Map<String, String> map = BuildingUtil.getBuildingLabel();
		// 生成空教室list
		List<EmptyRoom> emptyRooms = new ArrayList<EmptyRoom>();

		try {
			Elements eles = urpHandler.getEmptyRoom();

			for (int i = 0; i < eles.size(); i++) {
				Elements eles1 = eles.get(i).getElementsByTag("td");
				EmptyRoom emptyRoom = new EmptyRoom();

				emptyRoom.setBuilding(eles1.get(0).text());
				emptyRoom.setBuildingCode(map.get(eles1.get(0).text()));
				emptyRoom.setRoomName(eles1.get(1).text());
				ArrayList<String> status = new ArrayList<String>();
				status.add(eles1.get(2).text());
				status.add(eles1.get(3).text());
				status.add(eles1.get(4).text());
				status.add(eles1.get(5).text());
				status.add(eles1.get(6).text());
				status.add(eles1.get(7).text());
				status.add(eles1.get(8).text());

				emptyRoom.setStatus(status);
				emptyRooms.add(emptyRoom);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// EmptyRoom emptyRoom = new EmptyRoom();
		// emptyRoom.setBuilding("逸夫楼");
		// emptyRoom.setBuildingCode("yf");
		// emptyRoom.setRoomName("yf101");
		// ArrayList<String> status= new ArrayList<String>();
		// status.add("有课");
		// status.add("有课");
		// status.add("有课");
		// status.add("空");
		// status.add("借用");
		// status.add("有课");
		// status.add("有课");
		// emptyRoom.setStatus(status);
		// emptyRooms.add(emptyRoom);
		//
		// emptyRoom = new EmptyRoom();
		// emptyRoom.setBuilding("思源楼");
		// emptyRoom.setBuildingCode("sy");
		// emptyRoom.setRoomName("sy102");
		// status= new ArrayList<String>();
		// status.add("有课");
		// status.add("有课");
		// status.add("有课");
		// status.add("空");
		// status.add("借用");
		// status.add("有课");
		// status.add("有课");
		// emptyRoom.setStatus(status);
		// emptyRooms.add(emptyRoom);
		return emptyRooms;
	}

}
