package com.welearn.entity;

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
@Table(name="bjtu_attend_record")
public class AttendRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="attend_task_id", columnDefinition="int", nullable=false)
	private Integer attendTaskId;
	
	@Column(name="student_id", columnDefinition="int", nullable=false)
	private Integer attendId;
	
	@Column(name="pic_url", columnDefinition="varchar(128)")
	private String picUrl;
	
	@Column(name="similarity", columnDefinition="int(3)")
	private Integer similarity; //范围0~100
	
	@Column(name="reference_res", columnDefinition="tinyint(1) default 1")
	private Integer referenceRes;
	
	@Column(name="status", columnDefinition="tinyint(1) default 1",nullable=false)
	private Integer status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="attend_task_id", insertable=false, updatable=false)
	private AttendTask attendTaskEntity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="student_id", insertable=false, updatable=false)
	private Student studentEntity;
	
	public AttendRecord() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAttendTaskId() {
		return attendTaskId;
	}

	public void setAttendTaskId(Integer attendTaskId) {
		this.attendTaskId = attendTaskId;
	}

	public Integer getAttendId() {
		return attendId;
	}

	public void setAttendId(Integer attendId) {
		this.attendId = attendId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public Integer getSimilarity() {
		return similarity;
	}

	public void setSimilarity(Integer similarity) {
		this.similarity = similarity;
	}

	public Integer getReferenceRes() {
		return referenceRes;
	}

	public void setReferenceRes(Integer referenceRes) {
		this.referenceRes = referenceRes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public AttendTask getAttendTaskEntity() {
		return attendTaskEntity;
	}

	public void setAttendTaskEntity(AttendTask attendTaskEntity) {
		this.attendTaskEntity = attendTaskEntity;
	}

	public Student getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(Student studentEntity) {
		this.studentEntity = studentEntity;
	}
	
	
}
