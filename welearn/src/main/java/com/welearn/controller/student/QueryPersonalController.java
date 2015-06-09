package com.welearn.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.view.View;


@Controller
@RequestMapping("query/personal/*")
public class QueryPersonalController {

	/**
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("course-schedule")
	public View schoolCourseQuery(@RequestParam("code")String code) {
		//默认当前周试图
		return null;
	}
	
	/**
	 * 根据周 查询
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
	 * 
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
