package com.welearn.dao;

import org.hibernate.Query;

import com.welearn.entity.MsgNewsItem;
import com.welearn.entity.Role;

public class RoleDao extends SuperDao {

	public Integer addRole(Role role){
		return (Integer)this.sessionFactory.getCurrentSession().save(role);
	}
	
	public boolean delRole(int id){
		this.hql = "DELETE FROM Role AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean delRole(String name){
		this.hql = "DELETE FROM Role AS u WHERE u.name=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, name);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateRole(Role role){
		this.sessionFactory.getCurrentSession().update(role);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public Role getRoleById(int id){
		this.hql = "FROM Role AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (Role) query.uniqueResult();
	}
	
	public String[] getRolePrivilegesById(int ID){
		this.hql = "FROM Role AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, ID);
		Role role = (Role) query.uniqueResult();
		String[] privs = role.getPrivileges().split(";");
		return privs;
	}
	
}
