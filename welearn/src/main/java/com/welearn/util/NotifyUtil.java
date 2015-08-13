package com.welearn.util;

import net.sf.json.JSONObject;


public class NotifyUtil {

	/**
	 * 给指定的用户推送消息
	 * @param openId
	 * @param message
	 * @return
	 */
	public boolean pushText(String openId, String message) {
        try {
            JSONObject textMessageJson = new JSONObject();
            textMessageJson.put("touser", openId);
            textMessageJson.put("msgtype", "text");
            JSONObject contextJson=new JSONObject();
            contextJson.put("content",message);
            textMessageJson.put("text",contextJson);
            return pushMessage(textMessageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
	
	private boolean pushMessage(JSONObject json) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + getAccessToken();
		String responseContext = new HttpClientWrap().postResponseNative(url, json.toString());
        JSONObject responseJson = JSONObject.fromObject(responseContext);
		return responseJson.getLong("errcode") == 0;
	}
	
	
	public String getAccessToken() {
		return "FbjiQXJzaukfvDjONsd7POOlW7h3W-h0nXVZdFkLp8NkdEZ6GxnMWa9e9DN2w44w0Uk4RP2vVECfrk0d2y9J6tYGRfkkS9ZlR2fmh-Po4cY";
	}
}
