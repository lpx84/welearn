package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.CourseTime;

public class CourseTimeDao extends SuperDao{

	/**
	 * 新增一条记录
	 * @param courseTime
	 * @return
	 */
	public Integer addCourseTime(CourseTime courseTime){
		return (Integer)this.sessionFactory.getCurrentSession().save(courseTime);
	}
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delCourseTime(int id){
		this.hql = "DELETE FROM CourseTime AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 更新记录
	 * @param courseTime
	 * @return
	 */
	public boolean updateCourseTime(CourseTime courseTime){
		this.sessionFactory.getCurrentSession().update(courseTime);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 查询记录
	 * @param id
	 * @return
	 */
	public CourseTime getCourseTime(int id){
		this.hql = "FROM CourseTime AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (CourseTime) query.uniqueResult();
	}
	
	/**
	 * 根据某个非主属性查找某条记录
	 * @param section_id
	 * @return
	 */
	public List<CourseTime> getCourseTimeBySection(int section_no){
		this.hql = "FROM CourseTime AS u WHERE u.section_no=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, section_no);
		List<CourseTime> result = query.list();
		return result;
	}
}
