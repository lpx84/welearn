package com.welearn.controller.teacher;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.welearn.model.WechatTypeEnum;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;

@Controller
@RequestMapping("teacher/course/*")
public class CourseController {
	@Resource(name="teacherService")
	TeacherService teacherService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "courseService")
	CourseService courseService;
	
	@RequestMapping("course-index")
	public ModelAndView CourseScheduleQuery(@RequestParam("code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code,WechatTypeEnum.TEACHER);
		// 检验用户是否登录
		view = teacherService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}

		teacherService.setSession(session, openid);
		
		
        
		// 默认当前周试图
		return new View("teacher", "manage", "course-index", "课程首页");
	}
}
