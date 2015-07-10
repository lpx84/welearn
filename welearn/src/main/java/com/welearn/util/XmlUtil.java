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
		item.setDescription("欢迎关注北京交通大学微信教学平台，请绑定学号以获得更好的服务！");
		item.setPicUrl(ConstantsConfig.hostName + "/datafile/file/img/welcome-cover.png");
		item.setTitle("北京交通大学微信教学平台");
		item.setUrl(ConstantsConfig.hostName + "/welearn/student/account/bind"); //绑定学号的URL
		items.add(item);
		return news.getReplyXML(toUser, fromUser, items);
	}
}
