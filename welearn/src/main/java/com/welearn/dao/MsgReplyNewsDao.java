package com.welearn.dao;

import java.util.List;

import com.welearn.entity.MsgReplyNews;

public class MsgReplyNewsDao {
	/**
	 * 新增一条记录
	 * @param msgReplyNews
	 * @return
	 */
	public Integer addMsgReplyNews(MsgReplyNews msgReplyNews){
		return null;
	}
	
	/**
	 * 根据id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delMsgReplyNews(int id){
		return false;
	}
	
	/**
	 * 根据index_id删除记录
	 * @param indexId
	 * @return
	 */
	public boolean delMsgReplyNewsByIndexId(int indexId){
		return false;
	}
	
	/**
	 * 更新一条记录
	 * @param msgReplyNews
	 * @return
	 */
	public boolean updateMsgReplyNews(MsgReplyNews msgReplyNews){
		return false;
	}
	
	/**
	 * 查找一条记录
	 * @param id
	 * @param pageNo
	 * @param pageItemNum
	 * @return
	 */
	public MsgReplyNews getMsgReplyNewsById(int id, int pageNo, int pageItemNum){
		return null;
	}
	
	/**
	 * 根据index_id查询，可能存在多条记录，返回一个list
	 * @param indexID
	 * @return
	 */
	public List<MsgReplyNews> getMsgReplyNewsByIndexID(int indexID){
		return null;
	}
}
