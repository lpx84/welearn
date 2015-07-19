package com.welearn.model;

import java.util.ArrayList;

import com.welearn.entity.CourseOption;

public class CourseProblem {

	private Integer id;

	/**
	 * 显示顺序 即题号
	 */

	private Integer displayNo;

	/**
	 * 题目内容
	 */

	private String content;

	/**
	 * 所占分数
	 */

	private Integer score;

	/**
	 * 题目解释
	 */

	private String comment;

	/**
	 * 回复课程的ID
	 */

	private Integer courseId;

	/**
	 * 答案选项的ID
	 */

	private String answer;

	/**
	 * 选项
	 */
	private ArrayList<CourseOption> options;

	/**
	 * 状态；0 已被删除 1存在
	 */

	private Integer status;

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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public ArrayList<CourseOption> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<CourseOption> options) {
		this.options = options;
	}

}
