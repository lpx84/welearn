package com.welearn.handler.urp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;









import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.welearn.model.Semester;

public class UrpHandler {

	private String token;
	
	private String significantion;
	
	/**
	 * 构造方法
	 */
	public UrpHandler() {
		//产生一个token和significantion
		
	}
	
	public Elements getEmptyRoom() throws IOException {
		File input = new File("D:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/remainclassroom/index.html");
		//File input = new File("F:/empty-room-data.html");
		Document doc = Jsoup.parse(input, "UTF-8");
		Elements eles=doc.getElementsByTag("tr");

		eles.remove(1);
		eles.remove(0);	
		
		return eles;
	}
	
	public String getCalender() {
		String url = "";
		
		return "";
	}
	
	public String getExamPlan(String stuNo) {
		//得到当前学期
		String url = "";
		
		return "";
	}
	
	public String getCETGrade(String stuNo) {
		String url = "";
		
		return "";
	}
	
	public String getSemesterGrade(Semester semester, String studentNo) {
		String url = "";
		
		return "";
	}
	
	
}
