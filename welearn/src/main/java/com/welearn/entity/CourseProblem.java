package com.welearn.entity;

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

@Entity
@Table(name="bjtu_course_problem")
public class CourseProblem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * 显示顺序 即题号
	 */
	@Column(name="display_no", columnDefinition="int default 0", nullable=false)
	private Integer displayNo;
	
	/**
	 * 题目内容
	 */
	@Column(name="content", columnDefinition="varchar(1024) default ''", nullable=false)
	private String content;
	
	/**
	 * 所占分数
	 */
	@Column(name="score", columnDefinition="int default 0", nullable=false)
	private Integer score;
	
	
	/**
	 * 题目解释
	 */
	@Column(name="comment", columnDefinition="varchar(1024)")
	private String comment;
	
	/**
	 * 回复课程的ID
	 */
	@Column(name="course_id", columnDefinition="int", nullable=false)
	private Integer courseId;
	
	/**
	 * 答案选项的ID
	 */
	@Column(name="answer", columnDefinition="int")
	private Integer answer;
	
	/**
	 * 状态；0 已被删除  1存在
	 */
	@Column(name="status", columnDefinition="tinyint(1) default 1", nullable=false)
	private Integer status;
	
	/**
	 * 所属的课程实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;

	public CourseProblem() {
		super();
	}

	public CourseProblem(Integer displayNo, String content, Integer score,
			Integer courseId) {
		super();
		this.displayNo = displayNo;
		this.content = content;
		this.score = score;
		this.courseId = courseId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getAnswerId() {
		return answer;
	}

	public void setAnswerId(Integer answer) {
		this.answer = answer;
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

	public Integer getAnswer() {
		return answer;
	}

	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

}
