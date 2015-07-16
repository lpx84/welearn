package com.welearn.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StrUtil {
	public static String formatDate(Date date) {
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		return myFormat.format(date );
	}

}
