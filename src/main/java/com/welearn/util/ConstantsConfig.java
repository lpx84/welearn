package com.welearn.util;
/**
 * 系统常量类
 * @author Tracy
 *
 */
public class ConstantsConfig {

	/**
	 * 默认页面的标题
	 */
	private String defaultPageTitle;
	
	/**
	 * 默认每页显示条目数
	 */
	private Integer defaultPageItemNum;
	
	/**
	 * 学校的名称英文简称，用于在face++中建立group作为group name
	 */
	private String schoolShortName;
	
	public ConstantsConfig() {
		super();
	}

	public String getDefaultPageTitle() {
		return defaultPageTitle;
	}

	public void setDefaultPageTitle(String defaultPageTitle) {
		this.defaultPageTitle = defaultPageTitle;
	}

	public Integer getDefaultPageItemNum() {
		return defaultPageItemNum;
	}

	public void setDefaultPageItemNum(Integer defaultPageItemNum) {
		this.defaultPageItemNum = defaultPageItemNum;
	}

	public String getSchoolShortName() {
		return schoolShortName;
	}

	public void setSchoolShortName(String schoolShortName) {
		this.schoolShortName = schoolShortName;
	}
	
}
