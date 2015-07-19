package com.welearn.model;

/**
 * 学生的答题答案
 * 
 * @author SikentKim
 *
 */
public class CourseAnswer {
	private int problemId;
	private String displayNo;
	private String answer;

	public int getProblemId() {
		return problemId;
	}

	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}

	public String getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(String displayNo) {
		this.displayNo = displayNo;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
