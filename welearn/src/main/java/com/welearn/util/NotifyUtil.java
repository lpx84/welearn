package com.welearn.util;

import com.welearn.model.WechatTypeEnum;

import net.sf.json.JSONObject;


public class NotifyUtil {

	/**
	 * 给指定的用户推送消息
	 * @param platform 选择从哪个平台发送消息 分别对应的老师和学生
	 * @param openId
	 * @param message
	 * @return
	 */
	public boolean pushText(WechatTypeEnum platform, String openId, String message) {
        try {
            JSONObject textMessageJson = new JSONObject();
            textMessageJson.put("touser", openId);
            textMessageJson.put("msgtype", "text");
            JSONObject contextJson=new JSONObject();
            contextJson.put("content",message);
            textMessageJson.put("text",contextJson);
            return pushMessage(platform, textMessageJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
	
	private boolean pushMessage(WechatTypeEnum platform, JSONObject json) {
		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + TokenUtil.getAccessToken(platform);
		String responseContext = new HttpClientWrap().postResponseNative(url, json.toString());
        JSONObject responseJson = JSONObject.fromObject(responseContext);
		return responseJson.getLong("errcode") == 0;
	}
	
	
	
}
