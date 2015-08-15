package com.welearn.util;

import java.util.Date;

import net.sf.json.JSONObject;

import com.welearn.model.WechatTypeEnum;

public class TokenUtil {

	
	
	/**
	 * 把username和pwd对称加密
	 * @param username
	 * @param pwd
	 * @return
	 */
	public static String generateAuthentication(String username, String pwd) {
		return null;
	}
	
	/**
	 * 根据时间戳产生一个token
	 * @return
	 */
	public static String generateToken() {
		return null;
	}
	
	/**
	 * 获取微信的access_token
	 * @param platform
	 * @return
	 */
	public static String getAccessToken(WechatTypeEnum platform) {
		String appId = null;
		String secret = null;
		Date expiryTime = null;
		String accessToken = null;
		
		if(platform.equals(WechatTypeEnum.STUDENT)) {
			appId = WechatConfig.appId;
			secret = WechatConfig.appsecret;
			expiryTime = WechatConfig.expiryTime;
			accessToken = WechatConfig.accessToken;
		} else if(platform.equals(WechatTypeEnum.TEACHER)) {
			appId = TeacherConfig.appId;
			secret = TeacherConfig.appsecret;
			expiryTime = TeacherConfig.expiryTime;
			accessToken = TeacherConfig.accessToken;
		}
		
		if (accessToken == null || new Date().after(expiryTime)) {
			String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
			//System.out.println(url);
			String responseText = new HttpClientWrap().httpGetRequest(url);
	        //System.out.println(responseText);
	        JSONObject accessTokenJson = JSONObject.fromObject(responseText);
	        if (!accessTokenJson.has("errmsg")) {
	            accessToken = accessTokenJson.getString("access_token");
	            expiryTime = new Date(new Date().getTime() + accessTokenJson.getLong("expires_in") * 1000 - 120 * 1000);
	        }
	        
	        if(platform.equals(WechatTypeEnum.STUDENT)) {
	        	WechatConfig.expiryTime = expiryTime;
	        	WechatConfig.accessToken = accessToken;
	        } else if(platform.equals(WechatTypeEnum.TEACHER)) {
	        	TeacherConfig.expiryTime = expiryTime;
	        	TeacherConfig.accessToken = accessToken;
	        }
        }
        return accessToken;
	}
	
}
