package com.welearn.model;

/**
 * 这是失物招领类
 * 
 * @author SikentKim
 *
 */
public class LostThing {
	private String thing;//物品
	private String state;//状态
	private String describe;//描述
	private String time;//时间
	private String place;//地点

	public String getThing() {
		return thing;
	}

	public void setThing(String thing) {
		this.thing = thing;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
