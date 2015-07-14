package com.welearn.handler.tuling;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.welearn.util.HttpUtil;
import com.welearn.util.MyHttpClient;
import com.welearn.util.RequestHeader;
import com.welearn.util.TulingConfig;

public class TulingHandler {
	
	public String getTulingMsg(String keyword) throws ParseException, IOException {
		String info = URLEncoder.encode(keyword, "utf-8");
		String requesturl = "http://www.tuling123.com/openapi/api?key="+TulingConfig.key+"&info="+info; 
		//HttpGet request = new HttpGet(requesturl);
		//HttpResponse response = HttpClients.createDefault().execute(request); 
//		MyHttpClient client = MyHttpClient.getInstance();
		//
//		Map params = new HashMap();
//		params.put("key", TulingConfig.key);
//		params.put("info", keyword);
//		HttpResponse response = client.doHttpGet(new RequestHeader(requesturl), params);
//		
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(new HttpGet(requesturl));
		//System.out.println(TulingConfig.key);
		//200即正确的返回码 
		if(response.getStatusLine().getStatusCode()==200){ 
			return EntityUtils.toString(response.getEntity());
		} else {
			return null;
		}
		
		//return HttpUtil.getUrl(requesturl);
		
	}
	
}
