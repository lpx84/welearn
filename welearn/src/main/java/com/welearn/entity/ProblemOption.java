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
@Table(name="bjtu_course_option")
public class ProblemOption {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 选项字母编号 ABCD等
	 */
	@Column(name="code", columnDefinition="varchar(5)")
	private String code;
	
	/**
	 * 题目的ID
	 */
	@Column(name="problem_id", columnDefinition="int", nullable=false)
	private Integer problemId;
	
	/**
	 * 选项内容
	 */
	@Column(name="content", columnDefinition="varchar(1024)", nullable=false)
	private String content;
	
	/**
	 * 所属的问题实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="problem_id",insertable=false,updatable=false)
	private CourseProblem problemEntity;
	
	public ProblemOption() {
		super();
	}
	
	public ProblemOption(String code, Integer problemId, String content) {
		super();
		this.code = code;
		this.problemId = problemId;
		this.content = content;
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

	public Integer getProblemId() {
		return problemId;
	}

	public void setProblemId(Integer problemId) {
		this.problemId = problemId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
