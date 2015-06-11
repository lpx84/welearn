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
	public static String defaultPageTitle;
	
	/**
	 * 默认每页显示条目数
	 */
	public static Integer defaultPageItemNum;
	
	/**
	 * 学校的名称英文简称，用于在face++中建立group作为group name
	 */
	public static String schoolShortName;
	
	public ConstantsConfig() {
		super();
	}

	public void setDefaultPageTitle(String _defaultPageTitle) {
		defaultPageTitle = _defaultPageTitle;
	}

	public void setDefaultPageItemNum(Integer _defaultPageItemNum) {
		defaultPageItemNum = _defaultPageItemNum;
	}

	public void setSchoolShortName(String _schoolShortName) {
		schoolShortName = _schoolShortName;
	}
	
}
