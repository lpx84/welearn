package com.welearn.service.intef;

import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveText;

public interface WechatMsgService {

	/**
	 * 根据关键字得到消息回复
	 * @param msg
	 * @return
	 */
	public String getMsgReply(MsgReceive msg);
	
	
}
