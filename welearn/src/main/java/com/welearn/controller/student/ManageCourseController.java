package com.welearn.controller.student;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.aop.Authentication;
import com.welearn.entity.CourseNotify;
import com.welearn.model.Course;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;
/**
 * 课程管理类
 * @author SikentKim
 *
 */
@Controller
@RequestMapping("student/manage/course/*")
public class ManageCourseController {
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "emptyRoomService")
	EmptyRoomService emptyRoomService;
	@Resource(name = "courseService")
	CourseService courseService;
	@Resource(name = "misService")
	MisService misService;
	@Resource(name = "teacherService")
	TeacherService teacherService;
	
	/**
	 * 查看我的课程
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("course-list")
	public View getCourseList(@RequestParam(value = "code") String code) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}


		// 如果没有查到成绩，则显示没有 查到成绩
//		if (list.isEmpty()) {
//			view = new View("error", "wechat", "info", "未找到相应信息。");
//			view.addObject("info", "未找到相应信息。");
//			return view;
//		}		

		// 返回四六级成绩列表
		view = new View("student", "manage-course", "course-list", "我的课程");

		return view;
	}
	
	/**
	 * 进入某一门课的课程管理页面，为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */

	@RequestMapping("course-manage")
	@Authentication()
	public View courseManage(@RequestParam(value = "courseid") int courseid) {
		View view;
		// 用课程服务类查询具体的课程信息
		Course course = new Course();
		
//		if (course == null) {
//			view = new View("error", "wechat", "info", "课程不存在！");
//			view.addObject("info", "课程不存在！");
//		} else {
//			view = new View("student", "query-public", "school-course-detail",
//					course.getName());						
//			view.addObject("course", course);
//		}
		
		
		view = new View("student", "manage-course", "course-manage", course.getName());
		return view;
	}
	
	/**
	 * 进入某一门课的课程公共页面，为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */

	@RequestMapping("course-notify")
	@Authentication()
	public View courseNotify(@RequestParam(value = "courseid") int courseid) {
		View view;
		//课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 用课程服务类查询具体的课程通知
		ArrayList<CourseNotify> list = courseService.queryCourseNotify(courseid);				
		
		view = new View("student", "manage-course", "course-manage", "课程作业");
		view.addObject("courseName",courseName);
		view.addObject("list",list);
		return view;
	}
	
}
