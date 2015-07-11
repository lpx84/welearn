package com.welearn.util;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class MyHttpClient {
	
	
	
	//HttpClient
	private volatile static AbstractHttpClient client = new DefaultHttpClient();
	private volatile static MyHttpClient instance;
	
	public List<Cookie> getCookies() {
		return client.getCookieStore().getCookies();
	}
	
	private  MyHttpClient() {}
	
	public static MyHttpClient getInstance() {
		if(instance == null) {
			synchronized (client) {
				if(instance == null) {
					instance = new MyHttpClient();
				}
			}
		}
		
		return instance;
	}
	
	/**
	 * 执行get请求
	 * @param header 包含url和一些基本的header属性
	 * @param params 请求的参数
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResponse doHttpGet(RequestHeader header, Map<String,Object> params) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(header.getHeaderUrl());
		// Set Header
		for(Entry<String, String> entry : header.getHeaderMap().entrySet()) {
			get.setHeader(entry.getKey(), entry.getValue());
		}
		HttpParams httpParams = new BasicHttpParams();
		if(params != null) {
			for(Entry<String, Object> entry : params.entrySet()) {
				httpParams.setParameter(entry.getKey(), entry.getValue());
			}
			get.setParams(httpParams);
		}
		
		HttpResponse response = client.execute(get);
		//get.abort();
		return response;
	}
	
	/**
	 * Post请求
	 * @param header 包含url和一些基本的header属性
	 * @param params 请求的参数
	 * @return
	 */
	public HttpResponse doHttpPost(RequestHeader header, Map<String,Object> params) {
		
		HttpPost post = new HttpPost(header.getHeaderUrl());
		// Set Header
		for(Entry<String, String> entry : header.getHeaderMap().entrySet()) {
			post.setHeader(entry.getKey(), entry.getValue());
		}
		// Set request parameters
		List<NameValuePair> formParams = new ArrayList<NameValuePair>();
		if(params != null) {
			for(Entry<String, Object> entry: params.entrySet()) {
				formParams.add(new BasicNameValuePair(entry.getKey(),(String)entry.getValue()));
			}
		}
		UrlEncodedFormEntity entity;
		HttpResponse response = null;
		//Document doc = null;
		try {
			entity = new UrlEncodedFormEntity(formParams,"UTF-8");
			post.setEntity(entity);
			
			response = client.execute(post);
			//response.getEntity();
			//doc = responseToDocument(response);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//post.abort();
		return response;
	}
	
	/**
	 * 将response转化成response
	 * @param response
	 * @param charset
	 * @return
	 * @throws ParseException
	 * @throws IOException
	 */
	public Document responseToDocument(HttpResponse response, String charset) throws ParseException, IOException {
		HttpEntity httpEntity = response.getEntity();
		
        String content = EntityUtils.toString(httpEntity, charset);
		return Jsoup.parse(content);
	}
}
