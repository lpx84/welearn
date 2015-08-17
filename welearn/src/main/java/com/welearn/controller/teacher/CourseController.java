package com.welearn.controller.teacher;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.welearn.model.AttendRecord;
import com.welearn.model.AttendTask;
import com.welearn.model.Course;
import com.welearn.model.WechatTypeEnum;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.view.View;

@Controller
@RequestMapping("teacher/course/*")
public class CourseController {
	@Resource(name = "teacherService")
	TeacherService teacherService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "courseService")
	CourseService courseService;

	@RequestMapping("course-index")
	public ModelAndView CourseIndex(@RequestParam("code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code,
				WechatTypeEnum.TEACHER);
		// 检验用户是否登录
		view = teacherService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}

		teacherService.setSession(session, openid);

		// 返回教师页面的课程页面
		view = new View("teacher", "manage", "course-index", "课程首页");
		view.addObject("type", InfoCode.TEACHER_COURSE);

		return view;
	}

	/**
	 * 一门课程的管理页面
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("course-manage")
	public ModelAndView CourseManage(@RequestParam("courseid") int courseid,
			HttpSession session) {
		View view;

		session.setAttribute("courseid", courseid);
		Course course = courseService.queryCourseModleByCourseId(courseid);
		// 返回教师页面的课程页面
		view = new View("teacher", "manage", "course-manage", "课程首页");
		view.addObject("type", InfoCode.TEACHER_COURSE);
		view.addObject("courseName", course.getName());

		return view;
	}

	/**
	 * 显示签到任务列表
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("attend-list")
	public ModelAndView AttendList(HttpSession session) {
		View view;
		// 从session中获取课程id
		int courseId = (Integer) session.getAttribute("courseid");
		// 获取这门课的courseId
		ArrayList<AttendTask> tasks = teacherService.getAttendTasks(courseId);

		// 返回教师页面的课程页面
		view = new View("teacher", "manage", "attend-list", "签到任务列表");
		view.addObject("list", tasks);
		
		return view;
	}

	@RequestMapping("attend-detail")
	public ModelAndView AttendDetail(HttpSession session,int taskId) {
		View view;
		// 从session中获取课程id
		int courseId = (Integer) session.getAttribute("courseid");
		int[] rate = teacherService.getAttendStateNum(taskId);
		int num = 0;
		for(int i=0;i<5;i++){
			num+= rate[i];
		}
		
		ArrayList<AttendRecord> list = teacherService.getAttendRecords(taskId, courseId);
		view = new View("teacher", "manage", "attend-detail", "签到任务列表");
        view.addObject("rate",JSONArray.fromObject(rate).toString());
        view.addObject("num",num);
		view.addObject("list",list);
		view.addObject("taskId",taskId);
		return view;
	}
	
	
	@RequestMapping("attend-verify")
	public ModelAndView AttendVerify(HttpSession session,int recordId,int passType,int taskId) {
		View view;
		// 从session中获取课程id
		int courseId = (Integer) session.getAttribute("courseid");
		int[] rate = teacherService.getAttendStateNum(taskId);
		int num = 0;
		for(int i=0;i<5;i++){
			num+= rate[i];
		}
		//通过某一个签到
		teacherService.pass(recordId, passType);
		
		ArrayList<AttendRecord> list = teacherService.getAttendRecords(taskId, courseId);
		view = new View("teacher", "manage", "attend-detail", "签到任务列表");
        view.addObject("rate",JSONArray.fromObject(rate).toString());
        view.addObject("num",num);
		view.addObject("list",list);
		view.addObject("taskId",taskId);
        System.out.println(list.size());
		return view;
	}
	
	
	@RequestMapping("attend-pass-all")
	public ModelAndView AttendPassAll(HttpSession session,int taskId) {
		View view;
		// 从session中获取课程id
		int courseId = (Integer) session.getAttribute("courseid");
		int[] rate = teacherService.getAttendStateNum(taskId);
		int num = 0;
		for(int i=0;i<5;i++){
			num+= rate[i];
		}
		//通过某一个签到
		teacherService.passAll(taskId);
		
		ArrayList<AttendRecord> list = teacherService.getAttendRecords(taskId, courseId);
		view = new View("teacher", "manage", "attend-detail", "签到任务列表");
        view.addObject("rate",JSONArray.fromObject(rate).toString());
        view.addObject("num",num);
		view.addObject("list",list);
		view.addObject("taskId",taskId);
		return view;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("test-manage")
	public ModelAndView TestManage(HttpSession session) {
		View view;
		// 从session中获取课程id
		view = new View("teacher", "manage", "test-manage", "测评管理");
        
		return view;
	}
	
	@RequestMapping("test-problem-add")
	public ModelAndView TestProblemAdd(HttpSession session) {
		View view;
		// 从session中获取课程id
		view = new View("teacher", "manage", "test-problem-add", "添加题目");
        
		return view;
	}

}
