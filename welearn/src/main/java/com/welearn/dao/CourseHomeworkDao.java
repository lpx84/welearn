package com.welearn.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.StudentCourse;
import com.welearn.util.TimeUtil;

public class CourseHomeworkDao extends SuperDao {

	public Integer addCourseHomework(CourseHomework courseHomework){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseHomework);
	}
	
	public boolean delCourseHomeworkById(int id){
		this.hql = "DELETE FROM CourseHomework AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseHomerworkByCourseId(int courseid){
		this.hql = "DELETE FROM CourseHomework AS u WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseHomework(CourseHomework courseHomework){
		this.sessionFactory.getCurrentSession().update(courseHomework);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseHomework getCourseHomeworkById(int id){
		this.hql = "FROM CourseHomework AS u inner join fetch u.courseEntity WHERE u.id=? order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseHomework) query.uniqueResult();
	}
	
	public List<CourseHomework> getCourseHomeworkByContent(String content, int pageNo, int pageItemNum){
		this.hql = "from CourseHomework as a inner join fetch a.courseEntity where a.content like '%"+content+"%' order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByCourseId(int courseid){
		this.hql = "FROM CourseHomework AS u inner join fetch u.courseEntity WHERE u.courseId=? order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByCourseId(int courseid, int pageNo, int pageItemNum){
		this.hql = "FROM CourseHomework AS u inner join fetch u.courseEntity WHERE u.courseId=? order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getPublishedCourseHomeworkByCourseId(int courseid, int pageNo, int pageItemNum){
		this.hql = "FROM CourseHomework AS u inner join fetch u.courseEntity WHERE u.status=1 and u.courseId=? order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByTitle(String title, int pageNo, int pageItemNum){
		this.hql = "from CourseHomework as a inner join fetch a.courseEntity where a.title like '%"+title+"%' order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByDeadline(Date deadline, int pageNo, int pageItemNum){
		this.hql = "select a from CourseHomework as a inner join fetch a.courseEntity where deadline = ?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, TimeUtil.timeFormat(deadline));
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	public List<CourseHomework> getCourseHomeworkByCreateTime(Date createTime, int pageNo, int pageItemNum){
		this.hql = "select a from CourseHomework as a inner join fetch a.courseEntity where create_time = ? order by create_time desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setDate(0, createTime);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query.list();
		return result;
	}
	
	/**
	 * 根据课程号查找课程作业
	 * @param courseNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course AS a, bjtu_course_homework AS b where a.id=b.course_id and a.course_no=1;
	public List<CourseHomework> getCourseHomeworksByCourseNo(int courseNo, int pageNo, int pageItemNum) {
		/*this.hql = "select b from Course AS a, CourseHomework AS b "
				+ "inner join fetch b.courseEntity"
				+ "where a.id=b.courseId and a.courseNo=?";*/
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
	/**
	 * 根据学生的id查找课程作业
	 * @param studentId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseHomework> getCourseHomeworksByStudentId(int studentId, int pageNo, int pageItemNum) {
		
		this.hql = "FROM StudentCourse AS u inner "
				+ "join fetch u.studentEntity as a inner join fetch u.courseEntity "
				+ "WHERE a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(
				this.hql);
		query.setInteger(0, studentId);

		ArrayList<Integer> coursesId = new ArrayList<Integer>();
		List<StudentCourse> courses = query.list();
		for (int i = 0; i < courses.size(); i++) {
			coursesId.add(i, courses.get(i).getCourseId());
		}

		this.hql = "select a from CourseHomework as a inner join fetch a.courseEntity where a.courseId IN (:courseList) order by create_time desc";
		Query query2 = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query2.setParameterList("courseList", coursesId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseHomework> result = query2.list();
	
		return result;
	}
	
	
}
