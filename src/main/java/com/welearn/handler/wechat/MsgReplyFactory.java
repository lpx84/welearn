package com.welearn.handler.wechat;

import javax.annotation.Resource;

import com.welearn.model.MsgReceive;
import com.welearn.service.intef.WechatMsgService;

public class MsgReplyFactory {

	@Resource(name="wechatMsgService")
	private WechatMsgService wechatMsgService;
	
	/**
	 * 根据接收的消息得到返回的格式化的XML文本消息
	 * @param msg
	 * @return
	 */
	public String getReplyMsg(MsgReceive msg) {
		if(msg.getMsgType().equals("text")) {
			return wechatMsgService.getMsgReply(msg);
		} else if(msg.getMsgType().equals("image")) {
			//当上传的图片时处理代码
			
			
		} else if(msg.getMsgType().equals("voice")) {
			//当上传音频时处理代码
			
			
		}
		return "";
	}
	
	
}
