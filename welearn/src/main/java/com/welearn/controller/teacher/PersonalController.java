package com.welearn.controller.teacher;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.welearn.model.WechatTypeEnum;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.view.View;

@Controller
@RequestMapping("teacher/personal/*")
public class PersonalController {
	@Resource(name = "teacherService")
	TeacherService teacherService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	
	@RequestMapping("personal-index")
	public ModelAndView Notify(@RequestParam("code") String code,
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
		view = new View("teacher", "personal", "personal-index", "个人中心");
		view.addObject("type", InfoCode.TEACHER_PERSONAL);

		return view;
	}
}
