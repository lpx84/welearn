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
	// 获取用户access_token的url
	private String get_access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
			+ "appid=APPID"
			+ "&secret=SECRET&"
			+ "code=CODE&grant_type=authorization_code";

	public void setMsgReplyIndexDao(MsgReplyIndexDao msgReplyIndexDao) {
		this.msgReplyIndexDao = msgReplyIndexDao;
	}

	public String getMsgReply(MsgReceive msg) {
		// TODO Auto-generated method stub
		String keyword = ((MsgReceiveText) msg).getContent();
		// Integer rid = msgReplyIndexDao.getIndexByKeyword(keyword).getId();
		// 图灵机器人
		String tulingMsg = null;
		try {
			tulingMsg = new TulingHandler().getTulingMsg(keyword);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tulingMsg != null) {
			MsgReplyText text = new MsgReplyText();
			text.setContent(tulingMsg);
			return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
		} else {
			return XmlUtil.getNullReplyText(msg.getFromUserName(),
					msg.getToUserName());
		}

	}

	/**
	 * 根据code获取用户的openid，如果code不存在或者非法，则返回illegal
	 */
	public String getOpenIdByCode(String code) {
		// 替换对应的字符串
//		get_access_token_url = get_access_token_url.replace("APPID",
//				WechatConfig.appId);
//		get_access_token_url = get_access_token_url.replace("SECRET",
//				WechatConfig.appsecret);
//		get_access_token_url = get_access_token_url.replace("CODE", code);
//		String json = HttpUtil.getUrl(get_access_token_url);
//
//		JSONObject jsonObject = JSONObject.fromObject(json);
//		String openid = "illegal";
//		try {
//			openid = jsonObject.getString("openid");
//		} catch (Exception e) {
//			System.err.println(e.toString());
//		}
//
//		return openid;
		
		return code;
	}

}
