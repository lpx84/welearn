package com.welearn.dao;

import java.util.List;

import com.welearn.entity.MsgReplyText;

public class MsgReplyTextDao {
	
	/**
	 * 新增一条记录
	 * @param msgReplyText
	 * @return
	 */
	public Integer addMsgReplyText(MsgReplyText msgReplyText){
		return null;
	}
	
	/**
	 * 按照id删除一条记录
	 * @param id
	 * @return
	 */
	public boolean delMsgReplyText(int id){
		return false;
	}
	
	/**
	 * 按照index_id删除记录
	 * @param indexId
	 * @return
	 */
	public boolean delMsgReplyTextByIndex(int indexId){
		return false;
	}
	
	/**
	 * 更新一条记录
	 * @param msgReplyText
	 * @return
	 */
	public boolean updateMsgReplyText(MsgReplyText msgReplyText){
		return false;
	}
	
	/**
	 * 通过id查找一条记录
	 * @param id
	 * @return
	 */
	public MsgReplyText getMsgReplyTextById(int id){
		return null;
	}
	
	/**
	 * 通过index_id查找记录，由于不是一对一的主键关系，可能返回多个值，存在List中
	 * @param indexID
	 * @return
	 */
	public List<MsgReplyText> getMsgReplyTextByIndexID(int indexID){
		return null;
	}
}
