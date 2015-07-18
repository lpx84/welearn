package com.welearn.controller.admin;

import javax.annotation.Resource;

import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;

public class AdminController {
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "courseService")
	CourseService courseService;
	@Resource(name="teacherService")
	TeacherService teacherService;

}
