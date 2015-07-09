package com.welearn.model;

public class MsgReceiveEvent extends MsgReceive {

	private String event;
	
	private String eventKey;

	public MsgReceiveEvent(String toUserName, String fromUserName,
			String createTime, String msgType, String msgId) {
	super(toUserName, fromUserName, createTime, msgType, msgId);
	//super.msgType = "image";
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getEventKey() {
		return eventKey;
	}

	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
}
