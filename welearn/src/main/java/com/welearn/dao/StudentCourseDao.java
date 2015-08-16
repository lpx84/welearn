package com.welearn.dao;

import java.util.List;

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
		this.hql = "FROM StudentCourse AS u join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.courseId=? AND u.studentId=?";
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
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity inner join fetch u.courseEntity "
				+ "WHERE u.courseId=? AND u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseID);
		query.setInteger(1, studentID);
		return (StudentCourse) query.uniqueResult();
	}
	
	/**
	 * 获得所有的studentCourse表里的记录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentCourse> getStudentCourse(){
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity inner join fetch u.courseEntity ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		return query.list();
	}
	
	/**
	 * 根据课程的id获取选课记录
	 * @param courseId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentCourse> getStudentCourseByCourseId(int courseId){
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity inner join fetch u.courseEntity as a where a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		return query.list();
	}
	
	/**
	 * 根据学生的id获得他的选课记录
	 * @param studentId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<StudentCourse> getStudentCourseByStudentId(int studentId){
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity as a inner join fetch u.courseEntity where a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentId);
		return query.list();
	}
	
	/**
	 * 查询某课程选课学生数，返回Long类型的学生数量
	 * @param courseId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Long getCountByCourseId(int courseId){
		this.hql = "SELECT count(*) FROM StudentCourse AS u where u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		List count = query.list();
		return (Long)count.get(0);
	}
}
