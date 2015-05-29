package com.welearn.util;

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
}
