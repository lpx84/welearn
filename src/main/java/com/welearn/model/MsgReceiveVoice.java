package com.welearn.model;

public class MsgReceiveVoice extends MsgReceive {

	private String mediaId;
	
	private String format;
	
	public MsgReceiveVoice(String toUserName, String fromUserName,
			String createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		//super.msgType = "voice";
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}
	
}
