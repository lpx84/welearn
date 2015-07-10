package com.welearn.handler.wechat;

import java.util.Arrays;

import javax.annotation.Resource;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.welearn.entity.Student;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveEvent;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.AlgorithmUtil;
import com.welearn.util.InfoCode;
import com.welearn.util.WechatConfig;
import com.welearn.util.XmlUtil;

public class MsgReplyFactory {

	@Resource(name="wechatMsgService")
	private WechatMsgService wechatMsgService;
	@Resource(name="studentService")
	StudentService studentService;
	
	
	/**
	 * 给回复的消息加密
	 * @param replyMsg
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException
	 */
	public String encodeReplyMsg(String replyMsg, String timestamp, String nonce) throws AesException {
		String token = WechatConfig.token;
		String encodingAesKey = WechatConfig.encodingAesKey;
		String appId = WechatConfig.appId;
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		return pc.encryptMsg(replyMsg, timestamp, nonce);
	}
	
	/**
	 * 根据接收的消息得到返回的格式化的XML文本消息
	 * @param msg 解密之后明文的消息体
	 * @param isEncode 返回消息是否加密
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException 
	 */
	public String getReplyMsg(MsgReceive msg, boolean isEncode, String timestamp, String nonce) throws AesException {

		String replyMsg = null;
		if(msg == null) {
			return replyMsg;
		}
		
		if(msg.getMsgType().equals("text")) {
			return wechatMsgService.getMsgReply(msg);
		} else if(msg.getMsgType().equals("image")) {
			//当上传的图片时处理代码
			
			
		} else if(msg.getMsgType().equals("voice")) {
			//当上传音频时处理代码
			
			
		} else if(msg.getMsgType().equals("event")) {
			//当触发事件时处理代码
			MsgReceiveEvent event = (MsgReceiveEvent)msg;
			if("subscribe".equals(event.getEvent())) { //订阅
				Student s = studentService.getStudentByOpenId(event.getFromUserName());
				s.setStatus(InfoCode.STUDENT_SUBSCRIBED);
				studentService.updateStudent(s);
				return "subscribe";
			} else if("unsubscribe".equals(event.getEvent())) { //取消订阅
				return "unsubscribe";
			} else {
				return null;
			}
			
		} else {
			replyMsg = XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());
		}
		
		if(isEncode) {
			replyMsg = this.encodeReplyMsg(replyMsg, timestamp, nonce);
		}
		
		return replyMsg;
	}
	
	/**
	 * 明文模式下，微信请求合法性认证
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	public boolean signature(String signature,String timestamp,String nonce,String echostr) {
		if(signature == null ||
			timestamp == null ||
			nonce == null) {
			return false;
		}
		String [] arr = { WechatConfig.token, nonce, timestamp};
		Arrays.sort(arr); //字典序排序
		String bigStr = arr[0]+arr[1]+arr[2];
		String digest = AlgorithmUtil.SHA1(bigStr);
		if (digest.equals(signature)) {
			return true;
		} else {
			return false;
		}
	}
}
