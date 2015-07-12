package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.Academy;
import com.welearn.entity.CourseReply;
import com.welearn.entity.SchoolCalender;



public class SchoolCalenderDao extends SuperDao{
	
	public Integer addSchoolCalender(SchoolCalender schoolCalender){
		return (Integer)this.sessionFactory.getCurrentSession().save(schoolCalender);
	}
	
	public boolean delSchoolCalender(int id){
		this.hql = "DELETE FROM SchoolCalender AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	public boolean updateSchoolCalender(SchoolCalender schoolCalender){
		this.sessionFactory.getCurrentSession().update(schoolCalender);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	public SchoolCalender getSchoolCalenderById(int id){
		this.hql = "FROM SchoolCalender AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (SchoolCalender) query.uniqueResult();
	}
	
	public SchoolCalender getSchoolCalenderByName(String name){
		this.hql = "FROM SchoolCalender AS u WHERE u.name like '%"+name+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setString(0, name);
		//query.setFirstResult((pageNo - 1) * pageItemNum);
		//query.setMaxResults(pageItemNum);
		return (SchoolCalender) query.uniqueResult();
	}
	
	public List<SchoolCalender> getSchoolCalender(){
		this.hql = "select a from SchoolCalender as a order by id desc";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		//query.setString(0, name);
		//query.setFirstResult((pageNo - 1) * pageItemNum);
		//query.setMaxResults(pageItemNum);
		List<SchoolCalender> result = query.list();
		return result;
	}
	
}
