package com.welearn.util;

/**
 * 跟微信交互的配置变量
 * @author Tracy
 *
 */
public class WechatConfig {

	private String wxEmail;
	
	private String wxPwd;
	
	private String wxToken;

	public WechatConfig() {
		super();
	}

	public String getWxEmail() {
		return wxEmail;
	}

	public void setWxEmail(String wxEmail) {
		this.wxEmail = wxEmail;
	}

	public String getWxPwd() {
		return wxPwd;
	}

	public void setWxPwd(String wxPwd) {
		this.wxPwd = wxPwd;
	}

	public String getWxToken() {
		return wxToken;
	}

	public void setWxToken(String wxToken) {
		this.wxToken = wxToken;
	}
}
