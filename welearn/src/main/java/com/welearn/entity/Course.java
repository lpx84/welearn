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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bjtu_course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", columnDefinition="varchar(100)", nullable=false)
	private String name; //课程名称
	
	@Column(name="course_no", columnDefinition="varchar(100)", nullable=false)
	private String courseNo; //课程号
	
	@Column(name="description", columnDefinition="varchar(1024)")
	private String description;
	
	//课程和中间表对应
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<StudentCourse> StudentCourseList;
	
	//课程和签到任务
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<AttendTask> AttendTaskList;
	
	//课程和课程评价
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseComment> CourseCommentList;
	
	//课程和课程问题
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseProblem> CourseProblemList;
	
	//课程和课程通知
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseNotify> CourseNotifyList;
	
	//课程和课程回复
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseReply> CourseReplyList;
	
	//课程和课程作业
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseHomework> CourseHomeworkList;
	
	//课程和学期
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="id",insertable=false,updatable=false)
	private List<CourseTime> CourseTimekList;

	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_student_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="student_id", referencedColumnName="id")
    )*/
	
//	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY) 
//	@JoinTable(name="bjtu_student_course",
//		joinColumns=@JoinColumn(name="course_id"),
//		inverseJoinColumns={
//			@JoinColumn(name="student_id",
//			referencedColumnName="id"),
//			@JoinColumn(name="course_id",
//			referencedColumnName="id")
//		}
//	)
	//private Set<Student> studentList;
	
	
	/*@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
            name="bjtu_time_course",
            joinColumns=@JoinColumn(name="course_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="time_id", referencedColumnName="id")
    )*/
	//private Set<CourseTime> courseTimeList;
	
	public Course() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<StudentCourse> getStudentCourseList() {
		return StudentCourseList;
	}

	public void setStudentCourseList(List<StudentCourse> studentCourseList) {
		StudentCourseList = studentCourseList;
	}

	public List<AttendTask> getAttendTaskList() {
		return AttendTaskList;
	}

	public void setAttendTaskList(List<AttendTask> attendTaskList) {
		AttendTaskList = attendTaskList;
	}

	public List<CourseComment> getCourseCommentList() {
		return CourseCommentList;
	}

	public void setCourseCommentList(List<CourseComment> courseCommentList) {
		CourseCommentList = courseCommentList;
	}

	public List<CourseProblem> getCourseProblemList() {
		return CourseProblemList;
	}

	public void setCourseProblemList(List<CourseProblem> courseProblemList) {
		CourseProblemList = courseProblemList;
	}

	public List<CourseNotify> getCourseNotifyList() {
		return CourseNotifyList;
	}

	public void setCourseNotifyList(List<CourseNotify> courseNotifyList) {
		CourseNotifyList = courseNotifyList;
	}

	public List<CourseReply> getCourseReplyList() {
		return CourseReplyList;
	}

	public void setCourseReplyList(List<CourseReply> courseReplyList) {
		CourseReplyList = courseReplyList;
	}

	public List<CourseHomework> getCourseHomeworkList() {
		return CourseHomeworkList;
	}

	public void setCourseHomeworkList(List<CourseHomework> courseHomeworkList) {
		CourseHomeworkList = courseHomeworkList;
	}
	
	public List<CourseTime> getCourseTimekList() {
		return CourseTimekList;
	}

	public void setCourseTimekList(List<CourseTime> courseTimekList) {
		CourseTimekList = courseTimekList;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", courseNo=" + courseNo
				+ ", description=" + description + ", StudentCourseList="
				+ StudentCourseList + ", AttendTaskList=" + AttendTaskList
				+ ", CourseCommentList=" + CourseCommentList
				+ ", CourseProblemList=" + CourseProblemList
				+ ", CourseNotifyList=" + CourseNotifyList
				+ ", CourseReplyList=" + CourseReplyList
				+ ", CourseHomeworkList=" + CourseHomeworkList + "]";
	}

}
