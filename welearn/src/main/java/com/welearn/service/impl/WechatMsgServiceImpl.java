package com.welearn.service.impl;

import java.io.IOException;

import net.sf.json.JSONObject;

import com.welearn.dao.MsgReplyIndexDao;
import com.welearn.entity.MsgReplyText;
import com.welearn.handler.tuling.TulingHandler;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveText;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.HttpUtil;
import com.welearn.util.WechatConfig;
import com.welearn.util.XmlUtil;

public class WechatMsgServiceImpl implements WechatMsgService {
	// 数据库操作对象
	private MsgReplyIndexDao msgReplyIndexDao;

	public void setMsgReplyIndexDao(MsgReplyIndexDao msgReplyIndexDao) {
		this.msgReplyIndexDao = msgReplyIndexDao;
	}

//	public String getMsgReply(MsgReceive msg) {
//		// TODO Auto-generated method stub
//		
//		String keyword = ((MsgReceiveText)msg).getContent();
//		// 图灵机器人
//		String tulingMsg = null;
//		try {
//			
//			JSONObject json = JSONObject.fromObject(new TulingHandler().getTulingMsg(keyword));
//			if(json.get("code").equals(100000)) {
//				tulingMsg = json.getString("text");
//			} else {
//				tulingMsg = "未处理的返回类型！";
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (tulingMsg != null) {
//			MsgReplyText text = new MsgReplyText();
//			text.setContent(tulingMsg);
//			return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
//		} else {
//			return XmlUtil.getNullReplyText(msg.getFromUserName(),
//					msg.getToUserName());
//		}
//
//	}

	/**
	 * 微信请求返回的格式说明 
	 * {
	 *  "access_token":"ACCESS_TOKEN", 
	 * "expires_in":7200,
	 * "refresh_token":"REFRESH_TOKEN", 
	 * "openid":"OPENID", 
	 * "scope":"SCOPE",
	 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" 
	 * }
	 * 根据code获取用户的openid，如果code不存在或者非法，则返回illegal
	 */
	public String getOpenIdByCode(String code) {
		// // 获取用户access_token的url
		// String get_access_token_url =
		// "https://api.weixin.qq.com/sns/oauth2/access_token?"
		// + "appid=" + WechatConfig.appId
		// + "&secret=" + WechatConfig.appsecret
		// + "&code=" + code
		// + "&grant_type=authorization_code";
		// //向微信发送请求，获取openid
		// String json = HttpUtil.getUrl(get_access_token_url);
		// System.out.println(json);
		// JSONObject jsonObject = JSONObject.fromObject(json);
		// String openid = "illegal";
		// try {
		// openid = jsonObject.getString("openid");
		// } catch (Exception e) {
		// System.err.println(e.toString());
		// }
		//
		// return openid;
        return code;
	}

}
