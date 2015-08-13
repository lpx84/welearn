package com.welearn.controller.teacher;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;

@Controller
@RequestMapping("teacher/course/*")
public class CourseController {
	@Resource(name="teacherService")
	TeacherService teacherService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "courseService")
	CourseService courseService;
	
	
}
