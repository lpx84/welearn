package com.welearn.util;

/**
 * 跟微信交互的配置变量
 * @author Tracy
 *
 */
public class WechatConfig {

	public static String email;
	
	public static String pwd;
	
	public static String appId;
	
	public static String encodingAesKey;
	
	public static String token;
	
	public static String appsecret;

	
	public void setEmail(String _email) {
		email = _email;
	}

	public void setPwd(String _pwd) {
		pwd = _pwd;
	}

	public void setAppId(String _appId) {
		appId = _appId;
	}

	public void setEncodingAesKey(String _encodingAesKey) {
		encodingAesKey = _encodingAesKey;
	}

	public void setToken(String _token) {
		token = _token;
	}
	
	public void setAppsecret(String _appsecret){
		appsecret = _appsecret;
	}

}
