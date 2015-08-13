package com.welearn.service.intef;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.qq.weixin.mp.aes.AesException;
import com.welearn.model.MsgReceive;
import com.welearn.model.WechatTypeEnum;

public interface WechatMsgService {

	/**
	 * 根据关键字得到消息回复
	 * @param msg
	 * @return
	 */
	//public String getMsgReply(MsgReceive msg);
	
	public String getReplyMsg(MsgReceive msg, boolean isEncode, String timestamp, String nonce) throws AesException;
	
	/**
	 * 根据code获得对应的openid
	 * @param code
	 * @return
	 */
	public String getOpenIdByCode(String code, WechatTypeEnum type);
	
	
	public List test();
}
