package com.welearn.handler.wechat;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.ParserConfigurationException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xml.sax.SAXException;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.welearn.model.MsgReceive;
import com.welearn.util.WechatConfig;

@Controller
@RequestMapping("/wechat/*")
public class WechatHandler {

	
	
	@RequestMapping(name = "handler")
	@ResponseBody
	public String signature(HttpServletRequest request) throws IOException,
			DocumentException, AesException, ParserConfigurationException,
			SAXException {
		MsgReplyFactory reply = new MsgReplyFactory();
		MsgReceiveFactory receive = new MsgReceiveFactory();

		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String encryptType = request.getParameter("encrypt_type"); // 消息加密类型

		if (encryptType == null || encryptType.equals("raw")) { // 当url上无encrypt_type参数或者其值为raw时表示为不加密
			// 不加密时的情况
			String signature = request.getParameter("signature");
			String echostr = request.getParameter("echostr");

			if (request.getMethod().equals("GET")) {
				if (reply.signature(signature, timestamp, nonce, echostr)) {
					return echostr;
				} else {
					return "invalid!";
				}
			} else if (request.getMethod().equals("POST")) {
				if (reply.signature(signature, timestamp, nonce, echostr)) {
					MsgReceive msg = receive.getReceiveMsg(request, false,
							null, null, null);
					return reply.getReplyMsg(msg, false, null, null);
				} else {
					return "invalid!";
				}
			}

		} else {
			// 加密时的情况
			String msgSignature = request.getParameter("msg_signature"); // 消息签名
			MsgReceive msg = receive.getReceiveMsg(request, true, msgSignature,
					timestamp, nonce);
			return reply.getReplyMsg(msg, true, timestamp, nonce);
		}
		return null;

	}

}
