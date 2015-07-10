package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.MsgNewsItem;

public class MsgNewsItemDao extends SuperDao{
	
	/**
	 * 新增一条消息
	 * return 成功或者失败
	 */
	public Integer addMsgNewsItem(MsgNewsItem newsNewsItem){
		return (Integer)this.sessionFactory.getCurrentSession().save(newsNewsItem);
		//return null;
	}
	
	/**
	 * 删除一条消息
	 * @return
	 */
	public boolean delMsgNewsItem(int id){
		this.hql = "DELETE FROM MsgNewsItem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
		//return false;
	}
	
	/**
	 * 通过消息的id删除一条记录
	 * @return
	 */
	public boolean delMsgNewsItemByNewsID(int newsId){
		this.hql = "DELETE FROM MsgNewsItem AS u WHERE u.news_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, newsId);
		return query.executeUpdate() > 0;
		//return false;
	}
	
	public boolean updateMsgNewsItem(MsgNewsItem msgNewsItem){
		this.sessionFactory.getCurrentSession().update(msgNewsItem);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 查找消息
	 * @param ID
	 * @return
	 */
	public MsgNewsItem getMsgNewsItemById(int ID) {
		this.hql = "FROM MsgNewsItem AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, ID);
		return (MsgNewsItem) query.uniqueResult();
		//return null;
	}
	
	/**
	 * 查找消息
	 * @param NewsID
	 * @return
	 */
	public MsgNewsItem getMsgNewsItemByNewsId(int NewsID) {
		this.hql = "FROM MsgNewsItem AS u WHERE u.news_id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, NewsID);
		return (MsgNewsItem) query.uniqueResult();
		//return null;
	}
	
	/**
	 * 查找消息
	 * @param title
	 * @return
	 */
	public List<MsgNewsItem> getMsgNewsItemByTitle(String title) {
		this.hql = "from MsgNewsItem as a where a.title like '%"+title+"%'";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		List<MsgNewsItem> result = query.list();
		return result;
		//return null;
	}
	
}
