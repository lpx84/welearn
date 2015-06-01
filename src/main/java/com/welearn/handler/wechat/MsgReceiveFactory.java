package com.welearn.handler.wechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceivePicture;
import com.welearn.model.MsgReceiveText;
import com.welearn.model.MsgReceiveVoice;
import com.welearn.util.WechatConfig;

public class MsgReceiveFactory {

	@Resource(name = "wechatConfig")
	WechatConfig wechatConfig;

//	public String decodeReceiveMsg(String receiveMsg, String timestamp,
//			String nonce) throws ParserConfigurationException, SAXException,
//			IOException, AesException {
//
//		// StringReader sr = new StringReader(receiveMsg);
//		// InputSource is = new InputSource(sr);
//		// DocumentBuilderFactory factory =
//		// DocumentBuilderFactory.newInstance();
//		// DocumentBuilder builder=factory.newDocumentBuilder();
//		// Document document = (Document) builder.parse(is);
//
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		StringReader sr = new StringReader(receiveMsg);
//		InputSource is = new InputSource(sr);
//		Document document = (Document) db.parse(is);
//
//		Element root = document.getDocumentElement();
//		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
//		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
//
//		String encrypt = nodelist1.item(0).getNodeValue();
//		String msgSignature = nodelist2.item(0).getNodeValue();
//
//		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
//		String fromXML = String.format(format, encrypt);
//		String token = wechatConfig.getWxToken();
//		String encodingAesKey = wechatConfig.getEncodingAesKey();
//		String appId = wechatConfig.getAppId();
//		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
//		return pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
//	}

	/**
	 * 把收到的消息转化成Map格式
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @throws AesException
	 * @throws ParserConfigurationException 
	 * @throws SAXException 
	 */
	public Map<String, String> parseXML(HttpServletRequest request,
			boolean isEncode, String msgSignature, String timestamp,
			String nonce) throws DocumentException, IOException, AesException, ParserConfigurationException, SAXException {
		// Map<String,String> map = new HashMap<String,String>();
		// InputStream inputStream = request.getInputStream();
		// SAXReader reader = new SAXReader();
		// Document doc = reader.read(inputStream);
		// Element root = doc.getRootElement();
		//
		// List<Element> elementList = root.elements();
		// for(Element e:elementList){
		// map.put(e.getName(), e.getText());
		// }
		// inputStream.close();
		// inputStream = null;
		// return map;

		Map<String, String> map = new HashMap<String, String>();
		InputStream inputStream = request.getInputStream();
		SAXReader reader = new SAXReader();
		org.dom4j.Document doc = reader.read(inputStream);
		//System.out.println(this.inputStreamToString(inputStream));
		//Document doc = this.stringToDocument(this.inputStreamToString(inputStream));
		org.dom4j.Element root = doc.getRootElement();
		
		List<org.dom4j.Element> list = null;
		if (isEncode) {
			//NodeList encrypt = root.getElementsByTagName("Encrypt");
			org.dom4j.Element encrypt = root.element("Encrypt");
			if (encrypt != null) {
				String encryptMsg = encrypt.getText();
				String token = WechatConfig.token;
				String encodingAesKey = WechatConfig.encodingAesKey;
				String appId = WechatConfig.appId;
				WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey,
						appId);
				String xmlStr = pc.decryptMsg(msgSignature, timestamp, nonce,
						encryptMsg);
				
		        org.dom4j.Document plainTextDoc = DocumentHelper.parseText(xmlStr);
		        list = plainTextDoc.getRootElement().elements();
			} else {
				return null;
			}

		} else {
			list = root.elements();
		}

		for (org.dom4j.Element e : list) {
			map.put(e.getName(), e.getText());
		}
		inputStream.close();
		inputStream = null;
		return map;
	}

	public MsgReceive getReceiveMsg(HttpServletRequest request,
			boolean isEncode, String msgSignature, String timestamp,
			String nonce) throws IOException, DocumentException, AesException, 
			ParserConfigurationException, SAXException {

		Map<String, String> map = parseXML(request, isEncode, msgSignature,
				timestamp, nonce);
		// MsgReceive res = null;
		String toUserName = map.get("ToUserName");
		String fromUserName = map.get("FromUserName");
		String createTime = map.get("CreateTime");
		String msgId = map.get("MsgId");
		if (map.get("MsgType").equals("text")) { // 文本消息
			MsgReceiveText text = new MsgReceiveText(toUserName, fromUserName,
					createTime, "text", msgId);
			text.setContent(map.get("Content"));
			return text;
		} else if (map.get("MsgType").equals("image")) { // 图片消息
			MsgReceivePicture picture = new MsgReceivePicture(toUserName,
					fromUserName, createTime, "image", msgId);
			picture.setMediaId(map.get("MediaId"));
			picture.setPicUrl(map.get("PicUrl"));
			return picture;
		} else if (map.get("MsgType").equals("voice")) { // 声音消息
			MsgReceiveVoice voice = new MsgReceiveVoice(toUserName,
					fromUserName, createTime, "voice", msgId);
			voice.setFormat(map.get("Format"));
			voice.setMediaId(map.get("MediaId"));
			return voice;
		} else {
			return new MsgReceive(toUserName, fromUserName, createTime,
					"other", msgId);
		}
	}
	
	public Document stringToDocument(String str) {
		DocumentBuilderFactory factory = null;
		DocumentBuilder builder = null;
		Document ret = null;

		try {
			factory = DocumentBuilderFactory.newInstance();
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		try {
			//ret = builder.parse(new InputSource(in));
			ret = builder.parse(str);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ret;
	}
	
	public String inputStreamToString(InputStream is) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;

		try {

			while ((line = reader.readLine()) != null) {
				sb.append(line + "/n");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

//			try {
//
//				is.close();
//
//			} catch (IOException e) {
//
//				e.printStackTrace();
//
//			}

		}

		return sb.toString();

	}
}
