package com.welearn.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.model.ExamPlan;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;

@Controller
@RequestMapping("query/personal/*")
public class QueryPersonalController {
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "courseService")
	CourseService courseService;
	/**
	 * 查看当前课表
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("course-schedule")
	public View CourseScheduleQuery(@RequestParam("code") String code) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}

		// 默认当前周试图
		return null;
	}

	/**
	 * 根据周 查询当前课表
	 * 
	 * @param weekNo
	 * @return
	 */
	@RequestMapping("course-schedule-week")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("weekNo") Integer weekNo) {

		return null;
	}

	/**
	 * 查看当前课表
	 * 
	 * @param weekNo
	 *            第几周
	 * @param weekday
	 *            第几天
	 * @return json格式的字符串
	 */
	@RequestMapping("course-schedule-weekday")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("weekNo") Integer weekNo,
			@RequestParam("weekday") Integer weekday) {

		return null;
	}

	/**
	 * 查看考试时间
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("exam-plan")
	public View examPlan(@RequestParam(value = "code") String code) {
		// 用于检验用户是否登录
		View view;

		view = new View("student", "query-private", "exam-plan", "考试安排");
		ExamPlan examPlan = new ExamPlan(null);

		view.addObject("list", null);
		return view;
	}

	/**
	 * 查看四六级考试成绩
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("cet-grade")
	public View cetGrade(@RequestParam(value = "code") String code) {
        
		View view = new View("student", "public", "empty-room", "空教室");
		view.addObject("list", null);
		return view;
	}

	/**
	 * 查看各个学期的课程成绩
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("semester-grade")
	public View semesterGrade(@RequestParam(value = "code") String code) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {			
			return view;
		}
		//获取课程成绩的信息，以json的字符串形式获取
        String gradeInfo= courseService.queryCourseGrade(openid);
        //
        if(gradeInfo == null){
			view = new View("error","wechat","info","未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
        }
        
		//返回课程成绩
		view = new View("student", "query-private", "grade-course", "课程成绩");
		view.addObject("gradeInfo", gradeInfo);
		return view;
	}


	/**
	 * 一卡通自助查询 返回一卡通的基本信息
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("e-card")
	public View eCard(@RequestParam(value = "code") String code) {

		// 用一个类 验证呢身份
		// 如果false

		// return new InfoView();

		// 查询余额
		View view = new View("student", "public", "empty-room", "空教室");
		view.addObject("list", null);
		return view;
	}

	/**
	 * 一卡通消费记录查询
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@RequestMapping("e-card/consume-detail")
	@Authentication()
	@ResponseBody
	public String ecardConsumeDetail(
			@RequestParam(value = "startTime") String startTime,
			@RequestParam(value = "endTime") String endTime) {

		// 用一个类 验证呢身份
		// 如果false

		// return new InfoView();

		//
		return null;
	}

	/**
	 * 剩余流量查询
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("net-flow/detail")
	public View netFlowDetail(@RequestParam(value = "code") String code) {

		// 用一个类 验证呢身份
		// 如果false

		// return new InfoView();

		//
		return null;
	}

}
