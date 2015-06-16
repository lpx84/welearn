package com.welearn.controller.student;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.model.Building;
import com.welearn.model.EmptyRoom;
import com.welearn.service.impl.StudentServiceImpl;
import com.welearn.service.impl.WechatMsgServiceImpl;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.InfoView;
import com.welearn.view.View;

@Controller
@RequestMapping("student/query/public/*")
public class QueryPublicController {

	/**
	 * 查询学校的空教室
	 * @param code
	 * @return
	 */
	@RequestMapping("empty-room")
	public View queryEmptyRoom(@RequestParam(value="code")String code) {
		//创建一个学生服务类，来判断学生是否登录
		StudentService studentService = new StudentServiceImpl();
		WechatMsgService wechatService = new WechatMsgServiceImpl();
		String openid = wechatService.getOpenIdByCode(code);
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","请用微信登录！");
			view.addObject("info", "请用微信登录！");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!studentService.checkBindByOpenId(openid)){			
			View view = new View("student","user-course","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		
        
		
		
		
		//
		//从教务处获取
		//List
		View view = new View("student","query-public","empty-room","空教室查询");
		
		List<EmptyRoom> roomList = new ArrayList<EmptyRoom>();
		List<Building> buildingList = new ArrayList<Building>();
		buildingList.add(new Building("yf","逸夫楼"));
		view.addObject("roomList", roomList);
		view.addObject("buildingList", buildingList);
		return view;
	}
	
	@RequestMapping("calender")
	public View calender(@RequestParam(value="code")String code) {
		//创建一个学生服务类，来判断学生是否登录
		StudentService studentService = new StudentServiceImpl();
		WechatMsgService wechatService = new WechatMsgServiceImpl();
		String openid = wechatService.getOpenIdByCode(code);
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","请用微信登录！");
			view.addObject("info", "请用微信登录！");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!studentService.checkBindByOpenId(openid)){			
			View view = new View("student","user-course","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//
		//从教务处获取
		//List
		View view = new View("student","query-public","empty-room","空教室");
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
		//创建一个学生服务类，来判断学生是否登录
		StudentService studentService = new StudentServiceImpl();
		WechatMsgService wechatService = new WechatMsgServiceImpl();
		String openid = wechatService.getOpenIdByCode(code);
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","请用微信登录！");
			view.addObject("info", "请用微信登录！");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!studentService.checkBindByOpenId(openid)){			
			View view = new View("student","user-course","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		
		
		
		
		
		View view = new View("student","query-public","empty-room","空教室");
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
		//创建一个学生服务类，来判断学生是否登录
		StudentService studentService = new StudentServiceImpl();
		WechatMsgService wechatService = new WechatMsgServiceImpl();
		String openid = wechatService.getOpenIdByCode(code);
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","请用微信登录！");
			view.addObject("info", "请用微信登录！");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!studentService.checkBindByOpenId(openid)){			
			View view = new View("student","user-course","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		
		
		
		
		View view = new View("student","query-public","empty-room","空教室");
		return view;
	}
	
	@RequestMapping("lost-thing/query")
	@Authentication()
	@ResponseBody
	public String lostThingQuery(@RequestParam("pageNo")Integer pageNo) {
		
		return null;
	}
	
}
