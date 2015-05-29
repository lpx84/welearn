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

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.model.MsgReceive;
import com.welearn.util.WechatConfig;

@Controller
public class WechatHandler {

	@Resource(name="wechatConfig")
	WechatConfig wechatConfig;
	
	@RequestMapping(name="/welearn/wechat/handler")
	@ResponseBody
	public String signature(
			@RequestParam(value="signature")String signature,
			@RequestParam(value="timestamp")String timestamp,
			@RequestParam(value="nonce")String nonce,
			@RequestParam(value="echostr")String echostr,
			HttpServletRequest request) {
		
		if(request.getMethod().equals("GET")) {
			return this.signature(signature, timestamp, nonce, echostr);
		} else if(request.getMethod().equals("POST")) {
			try {
				MsgReceive msg = MsgReceiveFactory.getReceiveMsg(request);
				return new MsgReplyFactory().getReplyMsg(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return "error!";
		} else {
			return "wechat signate error!";
		}
	}
	
	
	private String signature(String signature,String timestamp,String nonce,String echostr) {
		if(signature == null ||
			timestamp == null ||
			nonce == null ||
			echostr == null) {
			return "null parameters";
		}
		String [] arr = { wechatConfig.getWxToken(), nonce, timestamp};
		Arrays.sort(arr); //字典序排序
		String bigStr = arr[0]+arr[1]+arr[2];
		String digest = this.SHA1(bigStr);
		if (digest.equals(signature)) {
			return echostr;
		} else {
			return "invalid signature";
		}
	}
	
	public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
	
}
