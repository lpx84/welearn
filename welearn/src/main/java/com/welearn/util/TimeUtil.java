package com.welearn.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	static public String getCurrentDateStrYMD() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}
	
	/**
	 * 得到当前日期，格式MM月dd日
	 * @return String
	 */
	static public String getCurrentDateStrMD() {
		SimpleDateFormat df = new SimpleDateFormat("MM月dd日");
		return df.format(new Date());
	}
	
	/** * 获取指定日期是星期几
	  * 参数为null时表示获取当前日期是星期几
	  * @param date
	  * @return
	*/
	public static String getWeekOfDate(Date date) { 
	    String[] weekOfDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};        
	    Calendar calendar = Calendar.getInstance();      
	    if(date != null){        
	         calendar.setTime(date);      
	    }        
	    int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;      
	    if (w < 0){        
	        w = 0;      
	    }      
	    return weekOfDays[w];    
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
	
	/**
	 * 把date类型转换成yyyy-MM-dd HH:mm格式
	 * @param date
	 * @return
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return myFormat.format(date );
	}
	
	/**
	 * 把date类型转换成yyyy-MM-dd HH:mm:ss格式
	 * @param date
	 * @return
	 */
	public static String formatDate1(Date date){
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return myFormat.format(date );
	}
	
	/**
	 * 把date类型转换成MM-dd HH:mm格式
	 * @param date
	 * @return
	 */
	public static String formatDate2(Date date){
		SimpleDateFormat myFormat = new SimpleDateFormat("MM-dd HH:mm");
		return myFormat.format(date );
	}
	/**
	 * 将Int型的所花时间转化为时分秒形式
	 * @param time
	 * @return
	 */
	public static String transSpendTime(int time){
		int hour;
		int minite;
		int second;
		hour = time /3600;
		minite = (time - hour*3600)/60;
		second = time % 60;
		
		String string="";
		if(hour>0)
			string = string+hour+"时";
		if(minite>0)
			string = string+minite+"分";
		string = string+second+"秒";
		
		return string;
	}
}
