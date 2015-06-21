package com.welearn.service.intef;

import java.util.Date;
import java.util.List;

import com.welearn.model.Building;
import com.welearn.model.EmptyRoom;

public interface EmptyRoomService {
    
	/**
	 * 获得所有的教学楼列表
	 * @return
	 */
	public abstract List<Building> getBuildings();
	
	/**
	 * 获得空教室的列表
	 * @return
	 */
	public abstract List<EmptyRoom> getEmptyRooms(Date date);
}
