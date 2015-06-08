package com.welearn.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.view.View;

@Controller
@RequestMapping("query/public/*")
public class QueryPublicController {

	
	@RequestMapping("empty-room")
	public View queryEmptyRoom(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		
		//
		//从教务处获取
		//List
		View view = new View("student","public","empty-room","空教室");
		view.addObject("list", null);
		return view;
	}
	
	@RequestMapping("calender")
	public View calender(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//
		//从教务处获取
		//List
		View view = new View("student","public","empty-room","空教室");
		view.addObject("list", null);
		return view;
	}
	
	/**
	 * 全校课程
	 * @param code
	 * @return
	 */
	@RequestMapping("school-course")
	public View schoolCourse(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		//登录
		
		View view = new View("student","public","empty-room","空教室");
		return view;
	}
	
	@RequestMapping("school-course-query")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("pageNo")Integer pageNo,
			@RequestParam("keyword")String keyword) {
		
		return null;
	}
	
	
	/**
	 * 失误招领页面
	 * @param code
	 * @return
	 */
	@RequestMapping("lost-thing")
	public View lostThing(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		//登录
		//返回页面
		View view = new View("student","public","empty-room","空教室");
		return view;
	}
	
	@RequestMapping("lost-thing/query")
	@Authentication()
	@ResponseBody
	public String lostThingQuery(@RequestParam("pageNo")Integer pageNo) {
		
		return null;
	}
	
}
