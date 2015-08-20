package com.welearn.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="bjtu_attend_task")
@DynamicInsert(true)
@DynamicUpdate(true)
public class AttendTask {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(100)" )
	private String name; //签到任务名称
	
	@Column(name="attend_num", columnDefinition="int default 0")
	private Integer attendNum; //签到人数
	
	/**
	 * 所属课程的ID
	 */
	@Column(name="course_id", columnDefinition="int")
	private Integer courseId;
	
	/**
	 * 开始签到时间
	 */
	@Column(name="start_time", columnDefinition="datetime default now()")
	private Date startTime;
	
	/**
	 * 截止签到时间
	 */
	@Column(name="end_time", columnDefinition="datetime default now()")
	private Date endTime;
	
	/**
	 * 任务发布时间
	 */
	@Column(name="create_time", columnDefinition="datetime default now()")
	private Date create_time;
	
	@Column(name="status", columnDefinition="tinyint(1) default 1")
	private Integer status;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;
	
	public AttendTask() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAttendNum() {
		return attendNum;
	}

	public void setAttendNum(Integer attendNum) {
		this.attendNum = attendNum;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

}
