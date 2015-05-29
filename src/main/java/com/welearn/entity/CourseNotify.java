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

import com.welearn.util.InfoCode;

@Entity
@Table(name="bjtu_course_notify")
public class CourseNotify {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 通知标题
	 */
	@Column(name="title", columnDefinition="varchar(100)", nullable=false)
	private String title;
	
	/**
	 * 通知的具体内容
	 */
	@Column(name="content", columnDefinition="varchar(2048)")
	private String content;
	
	/**
	 * 所属课程的ID
	 */
	@Column(name="course_id", columnDefinition="int", nullable=false)
	private Integer courseId;
	
	/**
	 * 发布时间
	 */
	@Column(name="create_time", columnDefinition="datetime", nullable=false)
	private Date create_time;
	
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;

	public CourseNotify() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}
	
	
}

