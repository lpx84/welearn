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
@Table(name="bjtu_course_exam")
public class CourseExam {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="student_id", columnDefinition="int(11)", nullable=false)
	private Integer studentId;
	
	@Column(name="course_id", columnDefinition="int(11)", nullable=false)
	private Integer courseId;
	
	@Column(name="spend_time", columnDefinition="int(11)", nullable=false)
	private Integer spendTime;
	
	@Column(name="finish_time", columnDefinition="datetime", nullable=false)
	private Date finishTime;
	
	@Column(name="score", columnDefinition="varchar(100)", nullable=false)
	private Integer score;
	
	@Column(name="status", columnDefinition="tinyint", nullable=false)
	private Integer status;
	
	@Column(name="answer", columnDefinition="text")
	private String answer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id",insertable=false,updatable=false)
	private Student studentEntity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;

	public CourseExam() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getSpendTime() {
		return spendTime;
	}

	public void setSpendTime(Integer spendTime) {
		this.spendTime = spendTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Student getStudentEntity() {
		return studentEntity;
	}

	public void setStudentEntity(Student studentEntity) {
		this.studentEntity = studentEntity;
	}

	public Course getCourseEntity() {
		return courseEntity;
	}

	public void setCourseEntity(Course courseEntity) {
		this.courseEntity = courseEntity;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "CourseExam [id=" + id + ", studentId=" + studentId
				+ ", courseId=" + courseId + ", spendTime=" + spendTime
				+ ", finishTime=" + finishTime + ", score=" + score + ", status="
				+ status + ", answer=" + answer + ", studentEntity="
				+ studentEntity + ", courseEntity=" + courseEntity + "]";
	}

	
}
