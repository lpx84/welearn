package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Academy;
import com.welearn.entity.Teacher;

public class AcademyDao extends SuperDao {

	public Integer addAcademy(Academy academy){
		return (Integer)this.sessionFactory.getCurrentSession().save(academy);
	}
	
	public boolean delAcademyById(int id){
		this.hql = "DELETE FROM Academy AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delAcademyByName(String name){
		this.hql = "DELETE FROM Academy AS u WHERE u.name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateAcademy(Academy academy){
		this.sessionFactory.getCurrentSession().update(academy);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public Academy getAcademyById(int id){
		this.hql = "FROM Academy AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (Academy) query.uniqueResult();
	}
	
	public List<Academy> getAcademyByName(String name){
		this.hql = "FROM Academy AS u WHERE u.name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		List<Academy> result = query.list();
		return result;
	}
	
	public List<Academy> getAcademyByDean(String dean){
		this.hql = "FROM Academy AS u WHERE u.dean=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, dean);
		List<Academy> result = query.list();
		return result;
	}
	/**
	 * 查找某个Academy里面的所有老师信息
	 * @param id
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public List<Teacher> getTeachersByAcademyId(int id, int pageNo, int pageItemNum){
		//this.hql = "select a from Teacher as a,Academy as b where b.id=a.id and a.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return null;
	}
	
}
