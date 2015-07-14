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
	
	@Column(name="finish_id", columnDefinition="datetime", nullable=false)
	private Integer finishId;
	
	@Column(name="score", columnDefinition="varchar(100)", nullable=false)
	private Integer score;
	
	@Column(name="status", columnDefinition="tinyint", nullable=false)
	private Integer status;
	
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

	public Integer getFinishId() {
		return finishId;
	}

	public void setFinishId(Integer finishId) {
		this.finishId = finishId;
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

	@Override
	public String toString() {
		return "CourseExam [id=" + id + ", studentId=" + studentId
				+ ", courseId=" + courseId + ", spendTime=" + spendTime
				+ ", finishId=" + finishId + ", score=" + score + ", status="
				+ status + ", studentEntity=" + studentEntity
				+ ", courseEntity=" + courseEntity + "]";
	}
	
}
