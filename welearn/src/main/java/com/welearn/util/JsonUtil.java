/**
 * 
 */
package com.welearn.util;

import java.util.List;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/**
 * @author Tracy
 *
 */
public class JsonUtil {
	
	/**
	 * 将实体对象的list转换成json串
	 * @param obj
	 * @param filterAttrs 实体中需要过滤的属性
	 * @return
	 */
	public static String listToJSONString(List list, String[] filterAttrs) {
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.setExcludes(filterAttrs);
		return JSONArray.fromObject(list, config).toString();
	}
	
	/**
	 * 将实体对象转换成json串
	 * @param obj
	 * @param filterAttrs 实体中需要过滤的属性
	 * @return
	 */
	public static String objectToJSONString(Object obj, String[] filterAttrs) {
		JsonConfig config = new JsonConfig();
		config.setIgnoreDefaultExcludes(false);
		config.setExcludes(filterAttrs);
		return JSONObject.fromObject(obj, config).toString();
	}
	
	/**
	 * 将一个json对象的字符串转换成一个JSONObject对象
	 * @param jsonObjectStr json对象的字符串，形式必须是："{'data':{'a':[{'b1':'bb1','c1':'cc1'},{'b2':'bb2','c2':'cc2'}]}}"
	 * @return
	 */
	public static JSONObject jsonObjectStrToObject(String jsonObjectStr) {
		return JSONObject.fromObject(jsonObjectStr);
	}
	
	/**
	 * 将一个json list的字符串转换成一个JSONArray对象
	 * @param jsonListStr json list的字符串形式，如："[{'name':'lpx','sex':'male'},{'name':'ronger','sex':'female'}]";
	 * @return
	 */
	public static JSONArray jsonListStrToList(String jsonListStr) {
		return JSONArray.fromObject(jsonListStr);
	}
	
	/**
	 * 返回一个操作的结果，用json串表示
	 * @param code
	 * @param info
	 * @return
	 */
	public static String getJsonInfo(Integer code, String info) {
		return "{\"code\": "+code+", \"msg\": \""+info+"\"}";
	}
	
	/**
	 * 返回一个操作正确的结果，用json串表示
	 * @return
	 */
	public static String getJsonInfoOK() {
		return getJsonInfo(InfoCode.OK,"OK");
	}
	
	public static String getJsonLoginTimeOut() {
		return getJsonInfo(InfoCode.LOGIN_TIMEOUT,"登录超时");
	}
	
}
