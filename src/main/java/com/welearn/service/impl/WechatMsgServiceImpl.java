package com.welearn.service.impl;

import com.welearn.dao.MsgReplyIndexDao;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveText;
import com.welearn.service.intef.WechatMsgService;

public class WechatMsgServiceImpl implements WechatMsgService {

	private MsgReplyIndexDao msgReplyIndexDao;
	
	public void setMsgReplyIndexDao(MsgReplyIndexDao msgReplyIndexDao) {
		this.msgReplyIndexDao = msgReplyIndexDao;
	}

	@Override
	public String getMsgReply(MsgReceive msg) {
		// TODO Auto-generated method stub
		String keyword = ((MsgReceiveText)msg).getContent();
		Integer rid = msgReplyIndexDao.getIndexByKeyword(keyword).getId();
		
		return null;
	}

	
}
