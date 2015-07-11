package com.welearn.handler.mis;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.cookie.Cookie;
import org.apache.http.util.EntityUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	public Element getNetFlowDetail(String stuNo, String pwd) throws ParseException, IOException {
		
		String checkCode = "";
		
		
		MyHttpClient client = MyHttpClient.getInstance();
		RequestHeader rh = new RequestHeader(this.host + "/nav_login");
		
		Document loginDoc = client.responseToDocument(client.doHttpGet(rh, null),"utf-8");
		
		Elements eles = loginDoc.getElementsByTag("script");
		String jscode = eles.get(eles.size()-1).html();
		
		Pattern p = Pattern.compile("checkcode=\"(.+?)\"");
		//System.out.println(eles);
		Matcher m = p.matcher(jscode);
		if(m.find()) {
			String str = m.group(0);
			checkCode = str.substring(11,str.length()-1);
			//System.out.println(checkCode);
		}
		
		rh = new RequestHeader(this.host + "/RandomCodeAction.action");
		client.responseToDocument(client.doHttpGet(rh, null),"utf-8");
		
		rh = new RequestHeader(this.host + "/LoginAction.action");
		//System.out.println(client.getStrCookie());
		
		rh.setCookie(client.getStrCookie());
		rh.setHost("service.bjtu.edu.cn");
		rh.setProperty("Origin", host);
		rh.setReferer(this.host + "/nav_login");
		rh.setProperty("Content-Type", "application/x-www-form-urlencoded");
		Map<String, Object> params01 = new HashMap<String, Object>();
        params01.put("account", stuNo);
        params01.put("password", pwd);
        params01.put("code", "");
        params01.put("checkcode", checkCode);
        params01.put("Submit", "登+录");
        
		HttpResponse response00= client.doHttpPost(rh,params01);
        //System.out.println(client.responseToDocument(response00,"utf-8").toString());
		EntityUtils.toString(response00.getEntity(), "utf-8");

        
        rh = new RequestHeader(this.host + "/nav_getUserInfo");
        rh.setCookie(client.getStrCookie());
        rh.setReferer(this.host + "/LoginAction.action");
        HttpResponse response02= client.doHttpGet(rh,null);
        
        
        Document doc = client.responseToDocument(response02, "UTF-8");
        //System.out.println(doc.toString());
        Element res = null;
        if(null != doc) {
        	res = doc.getElementsByTag("table").get(1); //得到含有数据的div块
        }
//        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(res);
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
