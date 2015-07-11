package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_school_calender")
public class SchoolCalender {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(255)")
	private String name;

	@Column(name="content", columnDefinition="varchar(255)")
	private String content;

	public SchoolCalender() {
		super();
	}

	public SchoolCalender(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SchoolCalender [id=" + id + ", name=" + name + ", content="
				+ content + "]";
	}
	
	
}
