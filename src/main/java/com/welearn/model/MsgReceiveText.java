package com.welearn.model;

public class MsgReceiveText extends MsgReceive {

	private String content;

	public MsgReceiveText(String toUserName, String fromUserName,
			String createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		//super.msgType = "text";
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
