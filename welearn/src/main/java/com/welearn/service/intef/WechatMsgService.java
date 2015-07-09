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
	
	/**
	 * 根据code获得对应的openid
	 * @param code
	 * @return
	 */
	public abstract String getOpenIdByCode(String code);
	
}
