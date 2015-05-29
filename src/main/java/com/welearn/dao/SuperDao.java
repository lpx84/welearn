package com.welearn.dao;

import org.hibernate.SessionFactory;

public class SuperDao {

protected SessionFactory sessionFactory;
	
	protected String hql;
	
	public SuperDao() {
		hql = null;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }
}
