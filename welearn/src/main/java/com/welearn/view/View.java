package com.welearn.view;

import org.springframework.web.servlet.ModelAndView;

import com.welearn.util.ConstantsConfig;

public class View extends ModelAndView {

	public View(String viewPath, String title) {
		super(viewPath);
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param sectionName
	 *            --部分名称：一般分为home，admin
	 * @param modelName
	 *            --模块名：系统具体划分的模块
	 * @param fileName
	 *            --模板文件名
	 * @param title
	 *            --模板文件页面的标题
	 */
	public View(String sectionName, String modelName, String fileName,
			String title) {
		super(sectionName + "/" + modelName + "/" + fileName);
		this.addObject("title", title);
		init();
	}

	/**
	 * 构造函数
	 * 
	 * @param sectionName
	 *            --部分名称：一般分为home，admin
	 * @param modelName
	 *            --模块名：系统具体划分的模块
	 * @param fileName
	 *            --模板文件名
	 */
	public View(String sectionName, String modelName, String fileName) {
		super(sectionName + "/" + modelName + "/" + fileName);
		this.addObject("title", ConstantsConfig.defaultPageTitle); // 这里传入默认title
		init();
	}

	private void init() {
		this.addObject("dftItemNum", ConstantsConfig.defaultPageItemNum);
	}
}
