package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Student;

public class StudentDao extends SuperDao {

	public Integer addStudent(Student student) {
		return (Integer)sessionFactory.getCurrentSession().save(student);
	}
	
	public boolean delStudent(int id) {
		hql = "delete from Student as s where s.id=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, id);
		return q.executeUpdate() > 0;
	}
	
	public boolean delStudentByOpenID(String openID) {
		hql = "delete from Student as s where s.openId=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, openID);
		return q.executeUpdate() > 0;
	}
	
	public boolean delStudentByStudentNo(String studentNo) {
		hql = "delete from Student as s where s.studentNo=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, studentNo);
		return q.executeUpdate() > 0;
	}
	
	public Student getStudent(int id) {
		hql = "from Student as s where s.id=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setInteger(0, id);
		return (Student)q.uniqueResult();
	}
	
	public Student getStudentByOpenID(String openID) {
		hql = "from Student as s where s.openId=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, openID);
		return (Student)q.uniqueResult();
	}
	
	public Student getStudentByFakeID(String fakeID) {
		hql = "from Student as s where s.fakeId=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, fakeID);
		return (Student)q.uniqueResult();
	}
	
	public List getStudentsByTrueName(String trueName) {
		hql = "from Student as s where s.trueName=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, trueName);
		return q.list();
	}
	
	public Student getStudentByStudentNo(String studentNo) {
		hql = "from Student as s where s.studentNo=?";
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		q.setString(0, studentNo);
		return (Student)q.uniqueResult();
	}
	
	public List getStudents(int pageNo, int pageItemNum) {
		return null;
	}
	
	public boolean updateStudent(Student student) {
		
		return true;
	}
	
	/**
	 * 在学生表里取出这个学生所有的课程信息，这里需要确认多对多的关系是否正确
	 * @return
	 */
	public List getCourseList() {
		return null;
	}
	
	
}
