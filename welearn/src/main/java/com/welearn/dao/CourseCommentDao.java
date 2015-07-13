package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

public class CourseCommentDao extends SuperDao {

	public Integer addCourseComment(CourseCommentDao courseComment){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseComment);
	}
	
	public boolean delCourseCommentById(int id){
		this.hql = "DELETE FROM CourseComment AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseComment(CourseCommentDao courseComment){
		this.sessionFactory.getCurrentSession().update(courseComment);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseCommentDao getCourseCommentById(int id){
		this.hql = "FROM CourseComment AS u inner join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseCommentDao) query.uniqueResult();
	}
	
	public List<CourseCommentDao> getCourseCommentByStudentId(int student_id, int pageNo, int pageItemNum) {
		this.hql = "FROM CourseComment AS u inner join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, student_id);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public List<CourseCommentDao> getCourseCommentByCourseId(int course_id, int pageNo, int pageItemNum) {
		this.hql = "FROM CourseComment AS u inner join fetch u.studentEntity inner join fetch u.courseEntity WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, course_id);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	/**
	 * 通过学生的学号查找学生对于课程的评价
	 * @param studentNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_student AS a, bjtu_course_comment AS b where a.id=b.student_id and a.student_no=12301111;
	public List<CourseCommentDao> getCourseCommentsByStudentNo(int studentNo, int pageNo, int pageItemNum){
		/*this.hql = "select b from Student AS a, CourseComment AS b "
				+ "inner join fetch b.studentEntity inner join fetch b.courseEntity"
				+ "where a.id=b.studentId and a.studentNo=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, studentNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 通过学生的真实姓名查找他们做过的一些评价
	 * @param truename
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseCommentDao> getCourseCommentsByStudentTruename(String truename, int pageNo, int pageItemNum){
		/*this.hql = "select b from Student AS a, CourseComment AS b "
				+ "inner join fetch b.studentEntity inner join fetch b.courseEntity"
				+ "where a.id=b.studentId and a.trueName=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, truename);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 通过课程号查找课程评价
	 * @param courseNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course AS a, bjtu_course_comment AS b where a.id=b.course_id and course_no=1;
	public List<CourseCommentDao> getCourseCommentsByCourseNo(String courseNo, int pageNo, int pageItemNum){
		/*this.hql = "select b from Course AS a, CourseComment AS b "
				+ "inner join fetch b.studentEntity inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.courseNo=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
	/**
	 * 通过课程名返回课程的评价
	 * @param name
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseCommentDao> getCourseCommentsByName(String name, int pageNo, int pageItemNum){
		/*this.hql = "select b from Course AS a, CourseComment AS b "
				+ "inner join fetch b.studentEntity inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.name=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	/**
	 * 通过老师的id获取这门课程的评价 
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseCommentDao> getCourseCommentsByTeacherId(int teacherId, int pageNo, int pageItemNum){
		/*this.hql = "select b from Course AS a, CourseComment AS b "
				+ "inner join fetch b.studentEntity inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.teacherId=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
}
