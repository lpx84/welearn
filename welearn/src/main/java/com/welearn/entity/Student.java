package com.welearn.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.welearn.util.InfoCode;


@Entity
@Table(name="bjtu_student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="student_no", columnDefinition="varchar(20)", nullable=false, unique=true)
	private String studentNo;
	
	@Column(name="true_name", columnDefinition="varchar(50)", nullable=false)
	private String trueName;
	
	/**
	 * 默认是教务处密码
	 */
	@Column(name="pwd", columnDefinition="varchar(50)", nullable=false)
	private String pwd;
	
	/**
	 * mis系统密码
	 */
	@Column(name="mis_pwd", columnDefinition="varchar(50)", nullable=false)
	private String misPwd;
	
	/**
	 * 计费网关密码
	 */
	@Column(name="gateway_pwd", columnDefinition="varchar(50)", nullable=false)
	private String gatewayPwd;
	
	
	@Column(name="open_id", columnDefinition="varchar(50)")
	private String openId;
	
	@Column(name="fake_id", columnDefinition="varchar(50)")
	private String fakeId;
	
	@Column(name="gender", columnDefinition="tinyint(1) default 0", nullable=false)
	private Integer gender;
	
	@Column(name="avatar", columnDefinition="varchar(50)")
	private String avatar;
	
	@Column(name="tel", columnDefinition="varchar(255)")
	private String tel;
	
	@Column(name="enroll_year", columnDefinition="int(4)")
	private Integer enrollYear;
	
	@Column(name="status", columnDefinition="tinyint(1) default 0", nullable=false)
	private Integer status;
	

	public Student() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getEnrollYear() {
		return enrollYear;
	}

	public void setEnrollYear(Integer enrollYear) {
		this.enrollYear = enrollYear;
	}

	public String getMisPwd() {
		return misPwd;
	}

	public void setMisPwd(String misPwd) {
		this.misPwd = misPwd;
	}

	public String getGatewayPwd() {
		return gatewayPwd;
	}

	public void setGatewayPwd(String gatewayPwd) {
		this.gatewayPwd = gatewayPwd;
	}

}
