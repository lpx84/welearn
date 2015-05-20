package com.welearn.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.welearn.util.TimeUtil;

@Entity
@Table(name="all_log")
public class Log {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user", columnDefinition="varchar(50)", nullable=false)
	private String user;
	
	@Column(name="type", columnDefinition="varchar(40)", nullable=false)
	private String type;
	
	@Column(name="content", columnDefinition="varchar(1024)", nullable=false)
	private String content; //操作详细内容
	
	@Column(name="log_time", columnDefinition="datetime", nullable=false)
	private Date logTime;

	public Log() {
		super();
	}

	public Log(String user, String type, String content) {
		super();
		this.user = user;
		this.type = type;
		this.content = content;
		this.logTime = TimeUtil.getCurrentTime();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
}
