package com.welearn.util;
import java.util.HashMap;
import java.util.Map;


public class RequestHeader {
	
	private String headerUrl = null;
	private Map<String, String> headerMap;
	
	private String UA = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36";
	
	public RequestHeader (String headerUrl) {
		this.headerUrl = headerUrl;
		headerMap = new HashMap<String, String>();
		headerMap.put("User-Agent", this.UA);
		headerMap.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		headerMap.put("Connection", "keep-alive");
		//headerMap.put("Accept-Encoding", "gzip, deflate, sdch");
		headerMap.put("Accept-Language", "zh-CN,zh;q=0.8");
	}
	
	public void setCookie(String cookie) {
		headerMap.put("Cookie", cookie);
	}
	
	public void setReferer(String referer) {
		headerMap.put("Referer", referer);
	}
	
	public void setHost(String host) {
		headerMap.put("Host", host);
	}
	
	public void setProperty(String key, String value) {
		this.headerMap.put(key, value);
	}
	
	public Map<String,String> getHeaderMap() {
		return this.headerMap;
	}

	public String getHeaderUrl() {
		return headerUrl;
	}

	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}
	
}
