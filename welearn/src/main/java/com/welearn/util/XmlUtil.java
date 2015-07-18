package com.welearn.util;

import java.util.ArrayList;
import java.util.List;

import com.welearn.entity.MsgNewsItem;
import com.welearn.entity.MsgReplyNews;
import com.welearn.entity.MsgReplyText;

public class XmlUtil {

	/**
	 * 当不知道该怎么回答的时候，调用此回复
	 * @param toUser
	 * @param fromUser
	 * @return
	 */
	public static String getNullReplyText(String toUser, String fromUser) {
		MsgReplyText text = new MsgReplyText("我还不知道该怎么回答你呢！",0);
		return text.getReplyXML(toUser, fromUser);
	}
	
	public static String getWelcomeReplyMsg(String toUser, String fromUser) {
		MsgReplyNews news = new MsgReplyNews();
		List<MsgNewsItem> items = new ArrayList<MsgNewsItem>();
		MsgNewsItem item = new MsgNewsItem();
		String desc = "欢迎关注北京交通大学微信教学平台，请绑定学号以获得更好的服务！\n";
		desc += "你还可以直接回复：\"北京回上海\"来查询火车或者\"北京飞上海\"来查询航班信息，甚至可以回复\"鱼香肉丝\"来查询菜谱……\n"
				+ "还有更多功能等你来发现！";
		item.setDescription(desc);
		item.setPicUrl(ConstantsConfig.hostName + "/datafile/file/img/welcome-cover.png");
		item.setTitle("北京交通大学微信教学平台");
		String welcomeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
				+ WechatConfig.appId 
				+ "&redirect_uri=http%3A%2F%2Fbdxst.bjtu.edu.cn%2F"
				+ "welearn%2Fstudent%2Faccount%2Fbind&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		item.setUrl(welcomeUrl); //绑定学号的URL
		items.add(item);
		return news.getReplyXML(toUser, fromUser, items);
	}
}
