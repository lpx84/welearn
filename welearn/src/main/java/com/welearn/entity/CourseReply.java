package com.welearn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course_reply")
public class CourseReply {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 回复者姓名
	 */
	@Column(name="replyor", columnDefinition="varchar(50)", nullable=false)
	private String replyor;
	
	/**
	 * 回复课程的ID
	 */
	@Column(name="course_id", columnDefinition="int", nullable=false)
	private Integer courseId;
	
	/**
	 * 回复内容
	 */
	@Column(name="content", columnDefinition="varchar(1024)", nullable=false)
	private String content;
	
	/**
	 * 回复类型: 老师或者是学生
	 */
	@Column(name="type", columnDefinition="tinyint(1)", nullable=false)
	private Integer type;
	
	/**
	 * 回复时间
	 */
	@Column(name="reply_time", columnDefinition="datetime", nullable=false)
	private Date reply_time;
	
	/**
	 * 状态；0 已被删除  1存在
	 */
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	/**
	 * 回复的课程实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;
	
	public CourseReply() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getReplyor() {
		return replyor;
	}

	public void setReplyor(String replyor) {
		this.replyor = replyor;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	@Override
	public String toString() {
		return "CourseReply [id=" + id + ", replyor=" + replyor + ", courseId="
				+ courseId + ", content=" + content + ", type=" + type
				+ ", reply_time=" + reply_time + ", status=" + status
				+ ", courseEntity=" + courseEntity + "]";
	}
	
}
