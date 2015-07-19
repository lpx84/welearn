package com.welearn.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;

import com.welearn.model.CourseAnswer;

public class AlgorithmUtil {

	/**
	 * 
	 * @param decript
	 * @return
	 */
	public static String SHA1(String decript) {
		try {
			MessageDigest digest = java.security.MessageDigest
					.getInstance("SHA-1");
			digest.update(decript.getBytes());
			byte messageDigest[] = digest.digest();
			// Create Hex String
			StringBuffer hexString = new StringBuffer();
			// 字节数组转换为 十六进制 数
			for (int i = 0; i < messageDigest.length; i++) {
				String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 将答案的字符串转化为相应的对象
	 * 
	 * @param answer
	 * @return
	 */
	public static ArrayList<CourseAnswer> getCourseAnswers(String answer) {
		ArrayList<CourseAnswer> list = new ArrayList<CourseAnswer>();
		String[] strings = answer.split(";");
		for (int i = 0; i < strings.length; i++) {
			String[] strs = strings[i].split(":");
			CourseAnswer courseAnswer = new CourseAnswer();
			courseAnswer.setDisplayNo(strs[0]);
			courseAnswer.setProblemId(Integer.valueOf(strs[1]));
			courseAnswer.setAnswer(strs[2]);
			list.add(courseAnswer);
		}

		return list;

	}
	
	/**
	 * 获取两个时间之间的相隔秒数
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static int getSpendTime(Date startTime,Date endTime){
		int	time =(int)(endTime.getTime()-startTime.getTime())/1000;
		
		return time;
	}

}
