package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Admin;

public class AdminDao extends SuperDao {

	public Integer addAdmin(Admin admin){
		return (Integer)this.sessionFactory.getCurrentSession().save(admin);
	}
	
	public boolean delAdminById(int id){
		this.hql = "DELETE FROM Admin AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delAdminByRoldId(int roleId){
		this.hql = "DELETE FROM Admin AS u WHERE u.role_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, roleId);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateAdmin(Admin admin){
		this.sessionFactory.getCurrentSession().update(admin);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public Admin getAdminByID(int id){
		this.hql = "FROM Admin AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (Admin) query.uniqueResult();
	}
	/**
	 * 通过用户名查找admin，由于username不具有唯一性，所以返回一个list
	 * @param username
	 * @return
	 */
	public List<Admin> getAdminByUsername(String username){
		this.hql = "from Admin as a where a.title like '%"+username+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<Admin> result = query.list();
		return result;
	}
	
}
