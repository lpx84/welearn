package com.welearn.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.service.impl.StudentServiceImpl;
import com.welearn.service.impl.WechatMsgServiceImpl;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;


@Controller
@RequestMapping("query/personal/*")
public class QueryPersonalController {

	/**
	 * 查看当前课表
	 * @param code
	 * @return
	 */
	@RequestMapping("course-schedule")
	public View schoolCourseQuery(@RequestParam("code")String code) {
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
		
		
		
		//默认当前周试图
		return null;
	}
	
	/**
	 * 根据周 查询当前课表
	 * @param weekNo
	 * @return
	 */
	@RequestMapping("course-schedule-week")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("weekNo")Integer weekNo) {
		
		
		
		
		return null;
	}
	
	/**
	 * 查看当前课表
	 * @param weekNo 第几周
	 * @param weekday 第几天
	 * @return
	 */
	@RequestMapping("course-schedule-weekday")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("weekNo")Integer weekNo,
			@RequestParam("weekday")Integer weekday) {
		
		return null;
	}
	
	/**
	 * 查看考试时间
	 * @param code
	 * @return
	 */
	@RequestMapping("exam-plan")
	public View examPlan(@RequestParam(value="code")String code) {
		
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
	 * 查看四六级考试成绩
	 * @param code
	 * @return
	 */
	@RequestMapping("cet-grade")
	public View cetGrade(@RequestParam(value="code")String code) {
		
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
	 * 查看各个学期的考试成绩
	 * @param code
	 * @return
	 */
	@RequestMapping("semester-grade")
	public View semesterGrade(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//用当前学期
		//返回学期列表
		View view = new View("student","public","empty-room","空教室");
		view.addObject("list", null);
		return view;
	}
	
	/**
	 * 
	 * @param year 学年
	 * @param semester 学年的上下学期，用1，2表示
	 * @return
	 */
	@RequestMapping("semester-grade/semester")
	@Authentication()
	public String semesterGrade(
			@RequestParam(value="year")Integer year,
			@RequestParam(value="semester")Integer semester) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//
		return null;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("e-card")
	public View eCard(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//查询余额
		View view = new View("student","public","empty-room","空教室");
		view.addObject("list", null);
		return view;
	}

	@RequestMapping("e-card/consume-detail")
	@Authentication()
	public String ecardConsumeDetail(
			@RequestParam(value="startTime")String startTime,
			@RequestParam(value="endTime")String endTime) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//
		return null;
	}
	
	
	@RequestMapping("net-flow/detail")
	public View netFlowDetail(@RequestParam(value="code")String code) {
		
		//用一个类 验证呢身份
		//如果false
		
		//return new InfoView();
		
		//
		return null;
	}
	
}
