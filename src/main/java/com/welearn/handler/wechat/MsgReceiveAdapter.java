package com.welearn.handler.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceivePicture;
import com.welearn.model.MsgReceiveText;
import com.welearn.model.MsgReceiveVoice;

public class MsgReceiveAdapter {
	
	/**
	 * 把收到的消息转化成Map格式
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static Map<String,String> parseXML(HttpServletRequest request) throws IOException, DocumentException{
		Map<String,String> map = new HashMap<String,String>();
		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
		Document doc = reader.read(inputStream);
		Element root = doc.getRootElement();
		List<Element> elementList = root.elements();
		for(Element e:elementList){
			map.put(e.getName(), e.getText());
		}
		inputStream.close();
		inputStream = null;
		return map;
	}
	
	public static MsgReceive getReceiveMsg(HttpServletRequest request) throws IOException, DocumentException {
		
		Map<String,String> map = parseXML(request);
		//MsgReceive res = null;
		String toUserName = map.get("ToUserName");
		String fromUserName = map.get("FromUserName");
		String createTime = map.get("CreateTime");
		String msgId = map.get("MsgId");
		if(map.get("MsgType").equals("text")) { //文本消息
			MsgReceiveText text = new MsgReceiveText(toUserName, fromUserName, createTime, "text", msgId);
			text.setContent(map.get("Content"));
			return text;
		} else if(map.get("MsgType").equals("image")) { //图片消息
			MsgReceivePicture picture = new MsgReceivePicture(toUserName, fromUserName, createTime, "image", msgId);
			picture.setMediaId(map.get("MediaId"));
			picture.setPicUrl(map.get("PicUrl"));
			return picture;
		} else if(map.get("MsgType").equals("voice")) { //声音消息
			MsgReceiveVoice voice = new MsgReceiveVoice(toUserName, fromUserName, createTime, "voice", msgId);
			voice.setFormat(map.get("Format"));
			voice.setMediaId(map.get("MediaId"));
			return voice;
		} else {
			return new MsgReceive(toUserName, fromUserName, createTime, "other", msgId);
		}
	}
}
