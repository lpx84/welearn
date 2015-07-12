package com.welearn.dao;

import java.util.List;

import org.hibernate.Query;

import com.welearn.entity.MsgReplyText;

public class MsgReplyTextDao extends SuperDao{
	
	/**
	 * 新增一条记录
	 * @param msgReplyText
	 * @return
	 */
	public Integer addMsgReplyText(MsgReplyText msgReplyText){
		return (Integer)this.sessionFactory.getCurrentSession().save(msgReplyText);
	}
	
	/**
	 * 按照id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delMsgReplyText(int id){
		this.hql = "DELETE FROM MsgReplyText AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 按照index_id删除记录
	 * @param indexId
	 * @return
	 */
	public boolean delMsgReplyTextByIndex(int indexId){
		this.hql = "DELETE FROM MsgReplyText AS u WHERE u.indexId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, indexId);
		return query.executeUpdate() > 0;
	}
	
	/**
	 * 更新一条记录
	 * @param msgReplyText
	 * @return
	 */
	public boolean updateMsgReplyText(MsgReplyText msgReplyText){
		this.sessionFactory.getCurrentSession().update(msgReplyText);
		//update的返回值为空，这里怎么判断是否成功
		return true;
	}
	
	/**
	 * 通过id查找一条记录
	 * @param id
	 * @return
	 */
	public MsgReplyText getMsgReplyTextById(int id){
		this.hql = "FROM MsgReplyText AS u WHERE u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, id);
		return (MsgReplyText) query.uniqueResult();
	}
	
	/**
	 * 通过index_id查找记录，由于不是一对一的主键关系，可能返回多个值，存在List中
	 * @param indexID
	 * @return
	 */
	public List<MsgReplyText> getMsgReplyTextByIndexID(int indexID){
		this.hql = "from MsgReplyText as a where a.indexId=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(this.hql);
		query.setInteger(0, indexID);
		List<MsgReplyText> result = query.list();
		return result;
	}
}
