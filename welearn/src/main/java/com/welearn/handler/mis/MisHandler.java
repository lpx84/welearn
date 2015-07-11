package com.welearn.handler.mis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;

import com.welearn.util.MyHttpClient;
import com.welearn.util.RequestHeader;

public class MisHandler {

	private String host = "http://service.bjtu.edu.cn";
	
	/**
	 * 一卡通余额
	 * @param stuNo
	 * @return
	 */
	public String getEcardRemaing(String stuNo) {
		
		return null;
	}
	
	/**
	 * 一卡通消费明细
	 * @param stuNo
	 * @return
	 */
	public String getEcardConsumeDetail(String stuNo) {
		
		return null;
	}
	
	/**
	 * 上网流量详细
	 * @param stuNo
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public String getNetFlowDetail(String stuNo, String pwd) throws ParseException, IOException {
		RequestHeader rh = new RequestHeader(this.host + "/LoginAction.action");
		//rh.setReferer("");
		MyHttpClient client = MyHttpClient.getInstance();
		
		Map<String, Object> params01 = new HashMap<String, Object>();
        params01.put("account", stuNo);
        params01.put("password", pwd);
        params01.put("checkcode", "2043");
        params01.put("Submit", "登 录");
        
		HttpResponse response00= client.doHttpPost(rh,params01);
        client.responseToDocument(response00,"utf-8");
        
        String cookie = client.getCookies().toString();
        
        rh = new RequestHeader(this.host + "/nav_getUserInfo");
        rh.setCookie(cookie);
        rh.setReferer(this.host + "/LoginAction.action");
        HttpResponse response02= client.doHttpGet(rh,null);
        
        //EntityUtils.toString(response02.getEntity(), "utf-8");
        
        Document doc = client.responseToDocument(response02, "UTF-8");
        System.out.println(doc.toString());
        String res = null;
        if(null != doc) {
        	res = doc.attr("class","tabcontent").toString(); //得到含有数据的div块
        }
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(res);
        return res;
	}
	
	/**
	 * 通过页号 向mis系统获取数据
	 * @param pageNo 页号
	 * @return
	 */
	public String getLostThing(int pageNo) {
		
		
		return null;
	}
}
