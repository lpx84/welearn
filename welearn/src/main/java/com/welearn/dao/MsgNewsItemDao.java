package com.welearn.dao;

import java.util.List;

import com.welearn.entity.MsgNewsItem;

public class MsgNewsItemDao {
	
	/**
	 * 新增一条消息
	 * return 成功或者失败
	 */
	public Integer addMsgNewsItem(MsgNewsItem newsNewsItem){
		return null;
	}
	
	/**
	 * 删除一条消息
	 * @return
	 */
	public boolean delMsgNewsItem(int id){
		return false;
	}
	
	/**
	 * 通过消息的id删除一条记录
	 * @return
	 */
	public boolean delMsgNewsItemByNewsID(int newsId){
		return false;
	}
	
	public boolean updateMsgNewsItem(MsgNewsItem msgNewsItem){
		return false;
	}
	
	/**
	 * 查找消息
	 * @param ID
	 * @return
	 */
	public MsgNewsItem getMsgNewsItemById(int ID) {
		return null;
	}
	
	/**
	 * 查找消息
	 * @param NewsID
	 * @return
	 */
	public MsgNewsItem getMsgNewsItemByNewsId(int NewsID) {
		return null;
	}
	
	/**
	 * 查找消息
	 * @param title
	 * @return
	 */
	public List<MsgNewsItem> getMsgNewsItemByTitle(String title) {
		return null;
	}
	
}
