package com.welearn.controller.student;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.dao.AcademyDao;
import com.welearn.entity.Academy;
import com.welearn.entity.Course;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.TestAmoseService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.util.WechatConfig;
import com.welearn.view.View;

@Controller
@RequestMapping("/test/*")
public class TestController {

	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;

	@Resource(name = "courseService")
	CourseService courseService;

	/*
	 * @Resource(name = "testAmoseService") TestAmoseService testAmoseService;
	 */

	@RequestMapping("test")
	@Authentication(role = InfoCode.ROLE_STUDENT)
	@ResponseBody
	public String test(@RequestParam("name") String str) {

		return WechatConfig.token;
	}

	@RequestMapping("testHql")
	@Authentication(role = InfoCode.ROLE_STUDENT)
	@ResponseBody
	public String testHql() {
		List<Course> course = courseService.getCourses();
		System.out.println("--------------");
		for (int i = 0; i < course.size(); i++) {
			System.out.println(course.get(i).toString());
		}
		System.out.println("--------------");
		return null;
	}

}
