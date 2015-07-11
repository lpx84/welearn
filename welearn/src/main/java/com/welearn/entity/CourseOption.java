package com.welearn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course_option")
public class CourseOption {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code", columnDefinition="varchar(5)")
	private String code;
	
	@Column(name="content", columnDefinition="varchar(1024)", nullable=false)
	private String name;
	
	@Column(name="problem_id", columnDefinition="int(11)", nullable=false)
	private String problemid;

	public CourseOption() {
		super();
	}

	public CourseOption(Integer id, String code, String name, String problemid) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.problemid = problemid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProblemid() {
		return problemid;
	}

	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	@Override
	public String toString() {
		return "CourseOption [id=" + id + ", code=" + code + ", name=" + name
				+ ", problemid=" + problemid + "]";
	}
	
}
