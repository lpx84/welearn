package com.welearn.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.welearn.entity.Course;
import com.welearn.entity.Student;
import com.welearn.entity.StudentCourse;
import com.welearn.entity.Teacher;

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
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudents(int pageNo, int pageItemNum) {
		this.hql = "from Student";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}
	
	public boolean updateStudent(Student student) {
		sessionFactory.getCurrentSession().update(student);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudentsByCourseId(int courseId){
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity AS S inner join fetch u.courseEntity "
				+ "WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseId);
		
		List<StudentCourse> students = query.list();
		ArrayList<Integer> studentsId = new ArrayList<Integer>();
		for (int i = 0; i < students.size(); i++) {
			studentsId.add(i, students.get(i).getStudentId());
		}

		Set<Student> set = new HashSet<Student>();
		for (int i = 0; i < studentsId.size(); i++) {
			this.hql = "FROM Student AS u WHERE u.id=?";
			Query query2 = this.sessionFactory.getCurrentSession().createQuery(
					this.hql);
			query2.setInteger(0, studentsId.get(i));
			List<Student> student = query2.list();
			set.addAll(student);
		}
		List<Student> result = new ArrayList<Student>(set);

		
		return result;
	}
	
	
}
