package com.welearn.controller.teacher;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welearn.service.intef.TeacherService;

@Controller
@RequestMapping("teacher/teacher/*")
public class TeacherController {

	@Resource(name="teacherService")
	TeacherService teacherService;
	
	
}
