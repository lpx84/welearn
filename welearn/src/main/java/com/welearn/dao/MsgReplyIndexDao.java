package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.MsgReplyIndex;

public class MsgReplyIndexDao extends SuperDao {

	
	public Integer addMsgReplyIndex(MsgReplyIndex index) {
		return (Integer)this.sessionFactory.getCurrentSession().save(index);
		//return null;
	}
	
	public boolean delMsgReplyIndex(int id) {
		this.hql = "DELETE FROM MsgReplyIndex AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
		//return false;
	}
	
	/**
	 * 根据ID得带实体
	 * @param id
	 * @return
	 */
	public MsgReplyIndex getIndexById(int id) {
		this.hql = "FROM MsgReplyIndex AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (MsgReplyIndex) query.uniqueResult();
		//return null;
	}
	
	/**
	 * 根据关键字得到实体
	 * @param keyword
	 * @return
	 */
	public MsgReplyIndex getIndexByKeyword(String keyword) {
		this.hql = "FROM MsgReplyIndex AS u WHERE u.keyword=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setString(0, keyword);
		return (MsgReplyIndex) query.uniqueResult();
		//return null;
	}
	
	public List<MsgReplyIndex> getMsgReplyIndexs(int pageNo, int pageItemNum) {
		this.hql = "FROM MsgReplyIndex";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setFirstResult((pageNo - 1) * pageItemNum);
		query.setMaxResults(pageItemNum);
		return query.list();
		
	}
	
	public boolean updateMsgReplyIndex(MsgReplyIndex msgReplyIndex) {
		this.sessionFactory.getCurrentSession().update(msgReplyIndex);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
}
