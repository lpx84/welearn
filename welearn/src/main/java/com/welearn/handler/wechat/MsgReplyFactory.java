package com.welearn.handler.wechat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.welearn.entity.MsgNewsItem;
import com.welearn.entity.MsgReplyNews;
import com.welearn.entity.MsgReplyText;
import com.welearn.entity.Student;
import com.welearn.handler.tuling.TulingHandler;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveEvent;
import com.welearn.model.MsgReceiveText;
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
			return this.getMsgReply(msg);
		} else if(msg.getMsgType().equals("image")) {
			//当上传的图片时处理代码
			
			
		} else if(msg.getMsgType().equals("voice")) {
			//当上传音频时处理代码
			
			
		} else if(msg.getMsgType().equals("event")) {
			//当触发事件时处理代码
			MsgReceiveEvent event = (MsgReceiveEvent)msg;
			if("subscribe".equals(event.getEvent())) { //订阅
//				Student s = studentService.getStudentByOpenId(event.getFromUserName());
//				s.setStatus(InfoCode.STUDENT_SUBSCRIBED);
//				studentService.updateStudent(s);
				return XmlUtil.getWelcomeReplyMsg(event.getFromUserName(), event.getToUserName());
			} else if("unsubscribe".equals(event.getEvent())) { //取消订阅
				return "unsubscribe";
			} else if("click".equals(event.getEvent().toLowerCase())) { //点击事件
				
				if("B_COURSE_ATTEND".equals(event.getEventKey())) { //点击的是签到按钮
					
				}
				
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
	
	public String getMsgReply(MsgReceive msg) {
		// TODO Auto-generated method stub
		
		String keyword = ((MsgReceiveText)msg).getContent();
		// 图灵机器人
		String tulingMsg = null;
		try {
			
			JSONObject json = JSONObject.fromObject(new TulingHandler().getTulingMsg(keyword));
			if(json.get("code").equals(100000)) { //普通文本
				tulingMsg = json.getString("text");
				
				MsgReplyText text = new MsgReplyText();
				text.setContent(tulingMsg);
				return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
				
			} else if(json.get("code").equals(308000)) { //菜谱
				//请求示例： http://www.tuling123.com/openapi/api?key=KEY&info=红烧肉怎么做
//				{
//					"code":308000,
//					"text":"********",
//					"list":[{
//					"name":"",
//					"info":"",
//					"detailurl":""
//					"icon":""
//					}]
//					}
				int itemNum = 10;
				JSONArray jsonArray = JSONArray.fromObject(json.get("list"));
				if(jsonArray.size() < 10) {
					itemNum = jsonArray.size();
				}
				
				List<MsgNewsItem> list = new ArrayList<MsgNewsItem>(); 
				for(int i=0; i<itemNum; ++i) {
					MsgNewsItem item = new MsgNewsItem();
					JSONObject o = (JSONObject)jsonArray.get(i);
					item.setTitle((String)o.get("name"));
					item.setDescription((String)o.get("info"));
					item.setPicUrl((String)o.get("icon"));
					item.setUrl((String)o.get("detailurl"));
					list.add(item);
				}
				
				MsgReplyNews news = new MsgReplyNews();
				return news.getReplyXML(msg.getFromUserName(), msg.getToUserName(), list);
			} else if(json.get("code").equals(305000)) {
//				请求示例： http://www.tuling123.com/openapi/api?key=KEY&info=北京到拉萨的火车
//				{
//				"code":305000,
//				"text":"********",
//				"list":[{
//				"trainnum":"",
//				"start":"",
//				"terminal":"",
//				"starttime":""
//				"endtime":""
//				"detailurl":""
//				"icon":""
//				}]
//				}
				int itemNum = 10;
				JSONArray jsonArray = JSONArray.fromObject(json.get("list"));
				if(jsonArray.size() < 10) {
					itemNum = jsonArray.size();
				}
				
				List<MsgNewsItem> list = new ArrayList<MsgNewsItem>(); 
				for(int i=0; i<itemNum; ++i) {
					MsgNewsItem item = new MsgNewsItem();
					JSONObject o = (JSONObject)jsonArray.get(i);
					String title = "【" + 
							(String)o.get("trainnum") + "】 " + 
							(String)o.get("start") + "--" + 
							(String)o.get("terminal") + "\n" + 
							(String)o.get("starttime") + "~" + 
							(String)o.get("endtime");
					item.setTitle(title);
					item.setDescription("");
					item.setPicUrl((String)o.get("icon"));
					item.setUrl((String)o.get("detailurl"));
					list.add(item);
				}
				
				MsgReplyNews news = new MsgReplyNews();
				return news.getReplyXML(msg.getFromUserName(), msg.getToUserName(), list);
			} else if(json.get("code").equals(306000)) {
//				请求示例： http://www.tuling123.com/openapi/api?key=KEY&info=北京到拉萨的飞机
//				{
//				"code":305000,
//				"text":"********",
//				"list":[{
//					"flight":"",
//					"route":"",
//					"starttime":"",
//					"endtime":"",
//					"state":"",
//					"detailurl":""
//					"icon":""
//				}]
//				}
				int itemNum = 10;
				JSONArray jsonArray = JSONArray.fromObject(json.get("list"));
				if(jsonArray.size() < 10) {
					itemNum = jsonArray.size();
				}
				
				List<MsgNewsItem> list = new ArrayList<MsgNewsItem>(); 
				for(int i=0; i<itemNum; ++i) {
					MsgNewsItem item = new MsgNewsItem();
					JSONObject o = (JSONObject)jsonArray.get(i);
					String title = "【" + 
							(String)o.get("flight") + "】 " + 
							(String)o.get("starttime") + "~" + 
							(String)o.get("endtime");
					item.setTitle(title);
					item.setDescription("");
					item.setPicUrl((String)o.get("icon"));
					list.add(item);
				}
				
				MsgReplyNews news = new MsgReplyNews();
				return news.getReplyXML(msg.getFromUserName(), msg.getToUserName(), list);
			} else {
				tulingMsg = "未处理的返回类型！";
				MsgReplyText text = new MsgReplyText();
				text.setContent(tulingMsg);
				return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());
		
	}
	
}
