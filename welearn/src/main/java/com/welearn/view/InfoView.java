package com.welearn.view;

import org.springframework.web.servlet.ModelAndView;

public class InfoView extends ModelAndView {

	/**
	 * 
	 * @param modal
	 * @param fileName
	 * @param info
	 */
	public InfoView(String modal, String fileName, String info) {
		super("error/"+modal+"/"+fileName);
		this.addObject("info", info);
	}
	
	/**
	 * 默认将提示信息显示到"error/wechat/info.jsp"页面
	 * @param info
	 */
	public InfoView(String info) {
		super("error/wechat/info");
		this.addObject("info", info);
	}
	
}
