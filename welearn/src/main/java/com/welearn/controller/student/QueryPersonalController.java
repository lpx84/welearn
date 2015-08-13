package com.welearn.controller.student;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.welearn.aop.Authentication;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseGrade;
import com.welearn.model.Ecard;
import com.welearn.model.ExamPlan;
import com.welearn.model.NetFlow;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.util.WechatTypeEnum;
import com.welearn.view.View;

@Controller
@RequestMapping("student/query/personal/*")
public class QueryPersonalController {
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "courseService")
	CourseService courseService;
	@Resource(name = "misService")
	MisService misService;

	/**查看当前课表
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("course-schedule")
	public ModelAndView CourseScheduleQuery(@RequestParam("code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}

		studentService.setSession(session, openid);

		// 默认当前周试图
		return new View("student", "query-private", "course-schedule", "我的课表");
	}

	/**根据周 查询当前课表
	 * 
	 * @param weekNo
	 * @return
	 */
	@RequestMapping("course-schedule-week")
	@Authentication(role = InfoCode.ROLE_STUDENT)
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
	@Authentication(role = InfoCode.ROLE_STUDENT)
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("weekNo") Integer weekNo,
			@RequestParam("weekday") Integer weekday) {

		return null;
	}

	/**查看考试安排
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("exam-plan")
	public ModelAndView examPlan(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}

		studentService.setSession(session, openid);
		// 获取考试安排
		ArrayList<ExamPlan> list = courseService.queryExamPlan(openid);
		view = new View("student", "query-private", "exam-plan", "考试安排");
		view.addObject("list", list);
		return view;
	}

	/** 查看四六级考试成绩
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("cet-grade")
	public ModelAndView cetGrade(@RequestParam(value = "code") String code) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}

		// 获取四六级成绩的list
		ArrayList<CETGrade> list = courseService.queryCETGrade(openid);

		// 如果没有查到成绩，则显示没有 查到成绩
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}

		// 把四六级分开成两个List
		ArrayList<CETGrade> cet4List = new ArrayList<CETGrade>();
		ArrayList<CETGrade> cet6List = new ArrayList<CETGrade>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getType().equals("英语四级")) {
				cet4List.add(list.get(i));
			} else {
				cet6List.add(list.get(i));
			}
		}
		// 返回四六级成绩列表
		view = new View("student", "query-private", "grade-english", "四六级成绩");
		view.addObject("cet4List", cet4List);
		view.addObject("cet6List", cet6List);
		return view;
	}

	/**查看各个学期的课程成绩
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("course-grade")
	public ModelAndView courseGrade(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取课程成绩的信息，以map的形式存储
		Map<String, ArrayList<CourseGrade>> map = courseService
				.queryCourseGrade(openid);
		if (map.isEmpty()) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}

		studentService.setSession(session, openid);
		// 返回课程成绩
		view = new View("student", "query-private", "grade-course", "课程成绩");
		view.addObject("gradeMap", map);
		return view;
	}

	/**剩余流量查询
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("net-flow")
	public ModelAndView netFlowDetail(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view = null;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取当月流量
		NetFlow netFlow = misService.getNetFlow(openid);
		// 表示获取当月流量出错，则返回至错误页面
		if (netFlow == null) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}

		studentService.setSession(session, openid);
		// 生成当月流量显示页面并显示
		view = new View("student", "query-private", "net-flow", "本月流量");
		view.addObject("netFlow", netFlow);
		return view;
	}

	/**
	 * 一卡通自助查询 返回一卡通的基本信息
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("ecard")
	public ModelAndView eCard(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view = null;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.STUDENT);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取当月流量
		NetFlow netFlow = misService.getNetFlow(openid);
		// 表示获取当月流量出错，则返回至错误页面
		if (netFlow == null) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}
      
		studentService.setSession(session, openid);
		//从misService中取出一卡通信息
        Ecard ecard = misService.getEcard(openid);
		view = new View("student", "query-private", "ecard", "一卡通查询");
        view.addObject("ecard", ecard);
		return view;
	}

	/**一卡通自助查询 返回一卡通的基本信息
	 * 
	 * @return
	 */
	@RequestMapping("ecard-detail")
	public ModelAndView eCardDetail() {
		// 查询余额
		View view = new View("student", "query-private", "ecard-detail",
				"一卡通查询");

		return view;
	}

}
