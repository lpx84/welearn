package com.welearn.dao;

import java.util.List;

import com.welearn.entity.MsgReplyIndex;

public class MsgReplyIndexDao extends SuperDao {

	
	public Integer addMsgReplyIndex(MsgReplyIndex index) {
		return null;
	}
	
	public boolean delMsgReplyIndex(int id) {
		return false;
	}
	
	/**
	 * 根据ID得带实体
	 * @param id
	 * @return
	 */
	public MsgReplyIndex getIndexById(int id) {
		return null;
	}
	
	/**
	 * 根据关键字得到实体
	 * @param keyword
	 * @return
	 */
	public MsgReplyIndex getIndexByKeyword(String keyword) {
		return null;
	}
	
	public List<MsgReplyIndex> getMsgReplyIndexs(int pageNo, int pageItemNum) {
		return null;
		
	}
	
	public boolean updateMsgReplyIndex(MsgReplyIndex msgReplyIndex) {
		return false;
	}
	
}
