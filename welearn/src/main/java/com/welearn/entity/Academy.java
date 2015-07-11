package com.welearn.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_academy")
public class Academy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(100)", nullable=false)
	private String name;
	
	@Column(name="dean", columnDefinition="varchar(50)")
	private String dean; //院长姓名
	
	@Column(name="tel", columnDefinition="varchar(255)")
	private String tel;
	
	@Column(name="comment", columnDefinition="varchar(1024)")
	private String comment; //学院说明  备注
	
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	public Academy() {}

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

	public String getDean() {
		return dean;
	}

	public void setDean(String dean) {
		this.dean = dean;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
