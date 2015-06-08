package com.welearn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	/**
	 * 得到当前时间
	 * @return Date
	 */
	static public Date getCurrentTime() {
		return new Date();
	}
	
	/**
	 * 得到当前时间的毫秒数
	 * @return long
	 * 
	 */
	static public long getAbsoluteTime() {
		return new Date().getTime();
	}
	
	/**
	 * 得到当前时间，格式yyyy-MM-dd HH:mm:ss
	 * @return String
	 */
	static public String getCurrentTimeStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date());
	}
	
	/**
	 * 得到当前日期，格式yyyy-MM-dd
	 * @return String
	 */
	static public String getCurrentDateStr() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	
	/**
	 * 把时间格式化成yyyy-MM-dd HH:mm:ss格式
	 * @param date
	 * @return
	 */
	static public String timeFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 把时间转成离当前时间的长度，显示更加友好
	 * @param date
	 * @return String
	 */
	static public String getShowTime(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String timeStr = sdf.format(date);
		long seconds = ( new Date().getTime() - date.getTime() ) / 1000;
		long num = seconds / (7*24*3600);
		if(num > 0 && num <= 4) {
			return num + "周前";
		}
		
		num = seconds / (24*3600);
		if(num > 0 && num <= 7) {
			return num + "天前";
		}
		
		num = seconds / (3600);
		if(num > 0 && num <= 24) {
			return num + "小时前";
		}
		
		num = seconds / (60);
		if(num > 0 && num <= 60) {
			return num + "分钟前";
		}
		
		if(num == 0) {
			return "刚刚";
		}
		
		
		return timeStr;
	}
	
	/**
	 * 传入的时间与现在的时间比较，判断是否超过规定的时间
	 * @param pre
	 * @return
	 */
	public static boolean isTimeout(Date pre) {
		Date curr = new Date();
		long offset = curr.getTime() - pre.getTime();
		return offset > 120*60000; //超时时限为2个小时
	}
}
