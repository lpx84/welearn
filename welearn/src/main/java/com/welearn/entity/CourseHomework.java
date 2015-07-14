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
@Table(name="bjtu_course_homework")
public class CourseHomework {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 作业标题
	 */
	@Column(name="title", columnDefinition="varchar(100)", nullable=false)
	private String title;
	
	/**
	 * 作业的具体内容
	 */
	@Column(name="content", columnDefinition="varchar(2048)")
	private String content;
	
	/**
	 * 作业所属课程的ID
	 */
	@Column(name="course_id", columnDefinition="int", nullable=false)
	private Integer courseId;
	
	/**
	 * 作业发布时间
	 */
	@Column(name="create_time", columnDefinition="datetime", nullable=false)
	private Date create_time;

	/**
	 * 作业提交截止时间
	 */
	@Column(name="deadline", columnDefinition="datetime", nullable=false)
	private Date deadline;
	
	@Column(name="status", columnDefinition="tinyint", nullable=false)
	private int status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;

	public CourseHomework() {
		super();
	}

	public CourseHomework(String title, String content, Integer courseId,
			Date create_time, Date deadline) {
		super();
		this.title = title;
		this.content = content;
		this.courseId = courseId;
		this.create_time = create_time;
		this.deadline = deadline;
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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CourseHomework [id=" + id + ", title=" + title + ", content="
				+ content + ", courseId=" + courseId + ", create_time="
				+ create_time + ", deadline=" + deadline + ", status=" + status
				+ ", courseEntity=" + courseEntity + "]";
	}
	
}
