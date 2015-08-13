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
@Table(name="bjtu_teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="user_name", columnDefinition="varchar(20)", nullable=false, unique=true)
	private String userName;
	
	@Column(name="true_name", columnDefinition="varchar(50)", nullable=false)
	private String trueName;
	
	@Column(name="pwd", columnDefinition="varchar(50)", nullable=false)
	private String pwd;
	
	@Column(name="open_id", columnDefinition="varchar(50)", unique=true)
	private String openId;
	
	@Column(name="fake_id", columnDefinition="varchar(50)")
	private String fakeId;
	
	@Column(name="gender", columnDefinition="tinyint(1) default 0", nullable=false)
	private Integer gender;
	
	@Column(name="avatar", columnDefinition="varchar(50)")
	private String avatar;
	
	@Column(name="academy_id", columnDefinition="int")
	private Integer academyId;
	
	@Column(name="birth", columnDefinition="date")
	private Date birth;
	
	@Column(name="title", columnDefinition="varchar(50)")
	private String title;
	
	@Column(name="description", columnDefinition="varchar(255)")
	private String description;
	
	@Column(name="tel", columnDefinition="varchar(255)")
	private String tel;
	
	@Column(name="email", columnDefinition="varchar(255)")
	private String email;
	
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="academy_id",insertable=false,updatable=false)
	private Academy academyEntity; //老师所在的学院实体
	
	public Teacher() {}

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

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getFakeId() {
		return fakeId;
	}

	public void setFakeId(String fakeId) {
		this.fakeId = fakeId;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Integer getAcademyId() {
		return academyId;
	}

	public void setAcademyId(Integer academyId) {
		this.academyId = academyId;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Academy getAcademyEntity() {
		return academyEntity;
	}

	public void setAcademyEntity(Academy academyEntity) {
		this.academyEntity = academyEntity;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", userName=" + userName + ", trueName="
				+ trueName + ", pwd=" + pwd + ", openId=" + openId
				+ ", fakeId=" + fakeId + ", gender=" + gender + ", avatar="
				+ avatar + ", academyId=" + academyId + ", birth=" + birth
				+ ", title=" + title + ", description=" + description
				+ ", tel=" + tel + ", email=" + email + ", status=" + status
				+ ", academyEntity=" + academyEntity + "]";
	}
	
}
