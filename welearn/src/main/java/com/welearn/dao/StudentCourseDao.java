package com.welearn.dao;

import org.hibernate.Query;

import com.welearn.entity.MsgNewsItem;
import com.welearn.entity.StudentCourse;

public class StudentCourseDao extends SuperDao{

	/**
	 * 新增一条记录
	 * @param studentCourse
	 * @return
	 */
	public Integer addStudentCourse(StudentCourse studentCourse){
		return (Integer)this.sessionFactory.getCurrentSession().save(studentCourse);
	}
	
	/**
	 * 删除一条记录
	 * @param studentCourse
	 * @return
	 */
	public boolean delStudentCourse(StudentCourse studentCourse){
		int courseid = studentCourse.getCourseId();
		int studentid = studentCourse.getStudentId();
		this.hql = "DELETE FROM StudentCourse AS u WHERE u.courseId=? AND u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setInteger(1, studentid);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 删除一条记录
	 * @param studentID
	 * @param courseID
	 * @return
	 */
	public boolean delStudentCourse(int studentID, int courseID){
		this.hql = "DELETE FROM StudentCourse AS u WHERE u.courseId=? AND u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseID);
		query.setInteger(1, studentID);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 更新一条数据
	 * @param studentCourse
	 * @return
	 */
	public boolean updateStudentCourse(StudentCourse studentCourse){
		this.sessionFactory.getCurrentSession().update(studentCourse);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 判断记录是否存在
	 * @param studentCourse
	 * @return
	 */
	public boolean isExist(StudentCourse studentCourse){
		int courseid = studentCourse.getCourseId();
		int studentid = studentCourse.getStudentId();
		this.hql = "FROM StudentCourse AS u WHERE u.courseId=? AND u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setInteger(1, studentid);
		return query.uniqueResult() != null;
	}
	
	/**
	 * 获得一条记录
	 * @param studentID
	 * @param courseID
	 * @return
	 */
	public StudentCourse getStudentCourse(int studentID, int courseID){
		this.hql = "FROM StudentCourse AS u WHERE u.courseId=? AND u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseID);
		query.setInteger(1, studentID);
		return (StudentCourse) query.uniqueResult();
	}
}
