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
import com.welearn.model.Semester;

public class CourseDao extends SuperDao {

	public Integer addCourse(Course course) {
		return (Integer) this.sessionFactory.getCurrentSession().save(course);
	}

	public boolean delCourse(int id) {
		this.hql = "DELETE FROM Course AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}

	public boolean delCourseByCourseNo(String courseNo) {
		this.hql = "DELETE FROM Course AS u WHERE u.courseNo=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setString(0, courseNo);
		return query.executeUpdate() > 0;
	}

	public boolean updateCourse(Course course) {
		this.sessionFactory.getCurrentSession().update(course);
		// update的返回值为空，这里怎么判断是否成功
		return true;
	}

	/**
	 * 根据课程主键查询实体
	 * 
	 * @param id
	 *            课程主键
	 * @return
	 */
	public Course getCourse(int id) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, id);
		return (Course) query.uniqueResult();
	}

	/**
	 * 根据课程号查询实体
	 * 
	 * @param courseNo
	 *            课程号
	 * @return
	 */
	public Course getCourseByCourseNo(String courseNo) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.courseNo='"
				+ courseNo + "'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		// query.setString(0, courseNo);
		return (Course) query.uniqueResult();
	}

	/**
	 * 老师的课程列表
	 * 
	 * @param teacherId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByTeacher(int teacherId, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.teacherId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, teacherId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据老师的id查找课程,全部都查出来
	 * 
	 * @param teacherId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByTeacher(int teacherId) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.teacherId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, teacherId);
		return query.list();
	}

	/**
	 * 根据上课时间查询课程
	 * 
	 * @param year
	 * @param semester
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByYearAndSemester(int year, int semester) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.year=? and u.semester=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, year);
		query.setInteger(1, semester);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByName(String name, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.name like '%"
				+ name + "%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据学院的name查找课程
	 * 
	 * @param academyName
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByAcademyName(String academyName, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity as a WHERE a.name like '%"
				+ academyName + "%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据学院的id查找课程
	 * 
	 * @param academyId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByAcademyId(int academyId, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity as a WHERE a.academyId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, academyId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据老师的真实姓名获得课程列表,精准查找
	 * 
	 * @param teacherName
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByTeacherName(String teacherName, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Teacher as u WHERE u.trueName like '%" + teacherName
				+ "%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);

		ArrayList<Integer> teachersId = new ArrayList<Integer>();
		List<Teacher> teachers = query.list();
		for (int i = 0; i < teachers.size(); i++) {
			teachersId.add(i, teachers.get(i).getId());
		}

		Set<Course> set = new HashSet<Course>();
		for (int i = 0; i < teachersId.size(); i++) {
			this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.teacherId=?";
			Query query2 = this.sessionFactory.getCurrentSession().createQuery(
					this.hql);
			query2.setInteger(0, teachersId.get(i));
			List<Course> course = query2.list();
			set.addAll(course);
		}
		List<Course> result = new ArrayList<Course>(set);

		return result;
	}

	/**
	 * 根据课程类型查找课程，支持模糊查询
	 * 
	 * @param courseType
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByCourseType(String courseType, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity as a WHERE u.courseType like '%"
				+ courseType + "%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据学分查询课程
	 * 
	 * @param credit
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Course> getCoursesByCredit(int credit, int pageNo,
			int pageItemNum) {
		this.hql = "FROM Course AS u inner join fetch u.academyEntity as a WHERE u.credit=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, credit);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
	}

	/**
	 * 根据学生的id获得他上过的课，在根据课程id，上课时间获得满足要求的课程列表
	 * 
	 * @param studentId
	 * @param year
	 * @param semester
	 * @return
	 */
	public List<Course> getCoursesByStudentIdAndSemester(int studentId,
			int year, int semester) {

		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity as a inner join fetch u.courseEntity "
				+ "WHERE a.studentId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, studentId);

		ArrayList<Integer> coursesId = new ArrayList<Integer>();
		List<StudentCourse> courses = query.list();
		for (int i = 0; i < courses.size(); i++) {
			coursesId.add(i, courses.get(i).getCourseId());
		}

		Set<Course> set = new HashSet<Course>();
		for (int i = 0; i < coursesId.size(); i++) {
			this.hql = "FROM Course AS u inner join fetch u.academyEntity WHERE u.id=? and u.year=? and u.semester=?";
			Query query2 = this.sessionFactory.getCurrentSession().createQuery(
					this.hql);
			query2.setInteger(0, coursesId.get(i));
			query2.setInteger(1, year);
			query2.setInteger(2, semester);
			List<Course> course = query2.list();
			set.addAll(course);
		}
		List<Course> result = new ArrayList<Course>(set);

		return result;
	}

	public List<Semester> getCourseTimeByStudentId(int studentId) {
		this.hql = "select distinct year,semester from bjtu_course where id in "
				+ "(select course_id from bjtu_student_course where student_id =?);";
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(
				this.hql);
		query.setInteger(0, studentId);

		List<Object[]> object = query.list();
		for (Object[] o : object) {
			int len = o.length;
			System.out.println("----------+++++++++++");
			for (int i = 0; i < len; i++) {
				System.out.println(o[i]);
			}
		}

		return null;
	}

}
