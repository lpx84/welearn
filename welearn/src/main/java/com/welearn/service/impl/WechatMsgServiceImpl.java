package com.welearn.service.impl;

import java.io.IOException;

import org.apache.http.ParseException;

import com.welearn.dao.MsgReplyIndexDao;
import com.welearn.entity.MsgReplyText;
import com.welearn.handler.tuling.TulingHandler;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveText;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.XmlUtil;

public class WechatMsgServiceImpl implements WechatMsgService {

	private MsgReplyIndexDao msgReplyIndexDao;
	
	public void setMsgReplyIndexDao(MsgReplyIndexDao msgReplyIndexDao) {
		this.msgReplyIndexDao = msgReplyIndexDao;
	}

	
	public String getMsgReply(MsgReceive msg) {
		// TODO Auto-generated method stub
		String keyword = ((MsgReceiveText)msg).getContent();
		//Integer rid = msgReplyIndexDao.getIndexByKeyword(keyword).getId();
		
		
		//图灵机器人
		String tulingMsg = null;
		try {
			tulingMsg = new TulingHandler().getTulingMsg(keyword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(tulingMsg != null) {
			MsgReplyText text = new MsgReplyText();
			text.setContent(tulingMsg);
			return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
		} else {
			return XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());
		}
		
	}

	
}
