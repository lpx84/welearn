package com.welearn.dao;

import org.hibernate.SessionFactory;

public class SuperDao {

    /**
     * 数据访问的代理对象，通过调用它的方法来实现数据查询
     */
    protected SessionFactory sessionFactory;
    
    /**
     * 存储hql语句的变量，在子类中直接用
     */
    protected String hql;
    
    public SuperDao() {
        hql = null;
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {  
        this.sessionFactory = sessionFactory;  
    }
}
