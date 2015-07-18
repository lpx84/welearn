package com.welearn.model;

/**
 * 表示课程考核的结果
 * 
 * @author SikentKim
 *
 */
public class CourseTestResult {
	private String time;
	private String spendTime;
	private String score;
	private String result;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
