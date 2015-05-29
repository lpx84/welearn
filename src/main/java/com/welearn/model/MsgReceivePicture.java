package com.welearn.model;

public class MsgReceivePicture extends MsgReceive {

	private String picUrl;
	
	private String mediaId;

	public MsgReceivePicture(String toUserName, String fromUserName,
					String createTime, String msgType, String msgId) {
		super(toUserName, fromUserName, createTime, msgType, msgId);
		//super.msgType = "image";
	}
	
	public String getPicUrl() {
		return picUrl;
	}
	
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	
}
