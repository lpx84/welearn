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
@Table(name="bjtu_admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="user_name", columnDefinition="varchar(50)", nullable=false)
	private String userName;
	
	@Column(name="pwd", columnDefinition="varchar(50)", nullable=false)
	private String pwd;
	
	@Column(name="true_name", columnDefinition="varchar(50)")
	private String trueName;
	
	@Column(name="tel", columnDefinition="varchar(1024)")
	private String tel;
	
	@Column(name="email", columnDefinition="varchar(255)")
	private String email;
	
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	@Column(name="role_id", columnDefinition="int")
	private Integer roleId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id",insertable=false,updatable=false)
	private Role roleEntity;

	public Admin() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRoleEntity() {
		return roleEntity;
	}

	public void setRoleEntity(Role roleEntity) {
		this.roleEntity = roleEntity;
	}
	
	
}
