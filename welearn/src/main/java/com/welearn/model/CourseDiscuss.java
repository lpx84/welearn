package com.welearn.model;
/**
 * 课程讨论类
 * @author SikentKim
 *
 */
public class CourseDiscuss {
	private int id;
	private String content;//内容
	private int courseId;//课程id
	private String time;//回复时间
	private int replayorId;//回复者时间
	private int type;//回复者的类型，老师，学生
	private String relayorName;//回复者姓名
	private String avatar;//回复者头像
	private boolean isMe;//是否是我（用于控制是否是左右）
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getReplayorId() {
		return replayorId;
	}
	public void setReplayorId(int replayorId) {
		this.replayorId = replayorId;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRelayorName() {
		return relayorName;
	}
	public void setRelayorName(String relayorName) {
		this.relayorName = relayorName;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public boolean isMe() {
		return isMe;
	}
	public void setMe(boolean isMe) {
		this.isMe = isMe;
	}	
	
}
