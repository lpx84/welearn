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

import com.welearn.util.TimeUtil;

@Entity
@Table(name="bjtu_course_comment")
public class CourseComment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="student_id", columnDefinition="int", nullable=false)
	private Integer studentId;

	/**
	 * 课程的ID
	 */
	@Column(name="course_id", columnDefinition="int", nullable=false)
	private Integer courseId;
	
	/**
	 * 评价分数
	 */
	@Column(name="grade", columnDefinition="int default 0", nullable=false)
	private Integer grade;
	
	/**
	 * 评价内容
	 */
	@Column(name="content", columnDefinition="varchar(255)")
	private String content;
	
	/**
	 * 评价时间
	 */
	@Column(name="log_time", columnDefinition="datetime")
	private Date logTime;

	/**
	 * 编写评价的学生实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="student_id",insertable=false,updatable=false)
	private Student studentEntity;
	
	/**
	 * 所属的课程实体
	 */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="course_id",insertable=false,updatable=false)
	private Course courseEntity;
	
	public CourseComment() {
		super();
	}
	

	public CourseComment(Integer studentId, Integer courseId, Integer grade,
			String content) {
		super();
		this.studentId = studentId;
		this.courseId = courseId;
		this.grade = grade;
		this.content = content;
		this.logTime = TimeUtil.getCurrentTime();
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

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public Date getLogTime() {
		return logTime;
	}

	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}


	@Override
	public String toString() {
		return "CourseComment [id=" + id + ", studentId=" + studentId
				+ ", courseId=" + courseId + ", grade=" + grade + ", content="
				+ content + ", logTime=" + logTime + ", studentEntity="
				+ studentEntity + ", courseEntity=" + courseEntity + "]";
	}
	
}
