package com.welearn.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.welearn.view.View;
/**
 * 管理员类
 * 
 * @author SikentKim
 *
 */
@Controller
@RequestMapping("public/*")
public class AdminController {
	@RequestMapping("admin-index")
	public ModelAndView AdminIndex() {	
		//返回教师页面的课程页面
       View  view = new View("admin", "admin", "admin-index", "课程首页");
		// 默认当前周试图
		return view;
	}

	@RequestMapping("admin-notify")
	public ModelAndView AdminNotify() {	
		//返回教师页面的课程页面
       View  view = new View("admin", "admin", "admin-notify", "课程首页");
		// 默认当前周试图
		return view;
	}

}
