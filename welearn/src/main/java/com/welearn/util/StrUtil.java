package com.welearn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrUtil {
	public static String formatDate(Date date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return myFormat.format(date );
	}
	
	public static String formatDate1(Date date){
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return myFormat.format(date );
	}

}
