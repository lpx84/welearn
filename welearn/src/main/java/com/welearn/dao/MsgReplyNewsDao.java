package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.MsgNewsItem;
import com.welearn.entity.MsgReplyNews;

public class MsgReplyNewsDao extends SuperDao{
	/**
	 * 新增一条记录
	 * @param msgReplyNews
	 * @return
	 */
	public Integer addMsgReplyNews(MsgReplyNews msgReplyNews){
		return (Integer)this.sessionFactory.getCurrentSession().save(msgReplyNews);
	}
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delMsgReplyNews(int id){
		this.hql = "DELETE FROM MsgReplyNews AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 根据index_id删除记录
	 * @param indexId
	 * @return
	 */
	public boolean delMsgReplyNewsByIndexId(int indexId){
		this.hql = "DELETE FROM MsgReplyNews AS u WHERE u.index_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, indexId);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 更新一条记录
	 * @param msgReplyNews
	 * @return
	 */
	public boolean updateMsgReplyNews(MsgReplyNews msgReplyNews){
		this.sessionFactory.getCurrentSession().update(msgReplyNews);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 查找一条记录
	 * @param id
	 * @return
	 */
	public MsgReplyNews getMsgReplyNewsById(int id){
		this.hql = "FROM MsgReplyNews AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (MsgReplyNews) query.uniqueResult();
	}
	
	/**
	 * 根据index_id查询，可能存在多条记录，返回一个list
	 * @param indexID
	 * @return
	 */
	public List<MsgReplyNews> getMsgReplyNewsByIndexID(int indexID){
		this.hql = "from MsgReplyNews as a where a.index_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, indexID);
		List<MsgReplyNews> result = query.list();
		return result;
	}
}
