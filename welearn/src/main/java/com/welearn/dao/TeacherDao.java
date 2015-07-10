package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;
import com.welearn.entity.Teacher;

public class TeacherDao  extends SuperDao {

	public Integer addTeacher(Teacher teacher) {
		return (Integer)this.sessionFactory.getCurrentSession().save(teacher);
	}
	
	public boolean delTeacher(int id) {
		this.hql = "DELETE FROM Teacher AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTeacherByUserName(String username) {
		this.hql = "DELETE FROM Teacher AS u WHERE u.user_name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, username);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTeacherByTrueName(String truename) {
		this.hql = "DELETE FROM Teacher AS u WHERE u.true_name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, truename);
		return query.executeUpdate() > 0;
	}
	
	public boolean delTeacherByOpenId(int openId) {
		this.hql = "DELETE FROM Teacher AS u WHERE u.open_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, openId);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateTeacher(Teacher teacher) {
		this.sessionFactory.getCurrentSession().update(teacher);
		//update的返回值为空，这里怎么判断是否成功
		return true;
		
	}
	
	public Teacher getTeacher(int id) {
		this.hql = "FROM Teacher AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (Teacher) query.uniqueResult();
	}
	
	/**
	 * 
	 * @param userName 这里指的是老师的工号
	 * @return
	 */
	public Teacher getTeacherByUserName(String userName) {
		this.hql = "FROM Teacher AS u WHERE u.user_name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, userName);
		return (Teacher) query.uniqueResult();
	}
	
	/**
	 * 通过名字查询教师
	 * @param trueName
	 * @return
	 */
	public List<Teacher> getTeachersByTrueName(String trueName) {
		this.hql = "FROM Teacher AS u WHERE u.true_name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, trueName);
		List<Teacher> result = query.list();
		return result;
	}
	
	/**
	 * 通过学院得到老师列表
	 * @param academyId
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<Teacher> getTeachersByAcademy(int academyId, int pageNo, int pageItemNum) {
		this.hql = "FROM Teacher AS u WHERE u.academy_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, academyId);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
		
	}
	
}
