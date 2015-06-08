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
}
