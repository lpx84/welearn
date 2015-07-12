package com.welearn.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.CourseNotify;
import com.welearn.util.TimeUtil;

public class CourseNotifyDao extends SuperDao {

	public Integer addCourseNotify(CourseNotify courseNotify){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseNotify);
	}
	
	public boolean delCourseNotifyById(int id){
		this.hql = "DELETE FROM CourseNotify AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delCourseNotifyByCourseId(int courseID){
		this.hql = "DELETE FROM CourseNotify AS u WHERE u.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseID);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateCourseNotify(CourseNotify courseNotify){
		this.sessionFactory.getCurrentSession().update(courseNotify);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public CourseNotify getCourseNotifyById(int id){
		this.hql = "FROM CourseNotify AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseNotify) query.uniqueResult();
	}
	
	public List<CourseNotify> getCourseNotifyByCourseId(int courseid, int pageNo, int pageItemNum){
		this.hql = "from CourseNotify as a where a.courseId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, courseid);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseNotify> result = query.list();
		return result;
	}
	
	public List<CourseNotify> getCourseNotifyByCreateTime(Date createTime, int pageNo, int pageItemNum){
		this.hql = "select a from CourseNotify as a where create_time=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, TimeUtil.timeFormat(createTime));
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseNotify> result = query.list();
		return result;
	}
	
	/**
	 * 根据课程号查询通知信息
	 * @param courseNo
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course AS a, bjtu_course_notify AS b where a.id = b.course_id and course_no=1;
	public List<CourseNotify> getCourseNotifyByCourseNo(String courseNo, int pageNo, int pageItemNum){
		this.hql = "select b from Course AS a, CourseNotify AS b "
				+ "where a.id = b.courseId and a.courseNo=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, courseNo);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseNotify> result = query.list();
		return result;
	}
	
	/**
	 * 通过老师的id查找提示信息
	 * @param teacherID
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<CourseNotify> getCourseNotifyByTeacherId(int teacherID, int pageNo, int pageItemNum){
		this.hql = "select b from Course AS a, CourseNotify AS b "
				+ "where a.id = b.courseId and a.teacherId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, teacherID);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseNotify> result = query.list();
		return result;
	}
	
	/**
	 * 通过课程名查找课程信息，支持模糊查询
	 * @param name
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	//select b.* from bjtu_course AS a, bjtu_course_notify AS b where a.id = b.course_id and a.name like '%方%';
	public List<CourseNotify> getCourseNotifyByCourseName(String name, int pageNo, int pageItemNum){
		this.hql = "select b from Course AS a, CourseNotify AS b "
				+ "where a.id = b.courseId and a.name like '%"+name+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setInteger(0, teacherID);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		List<CourseNotify> result = query.list();
		return result;
	}
}
