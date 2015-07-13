package com.welearn.controller.teacher;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.CourseHomework;
import com.welearn.entity.Teacher;
import com.welearn.service.intef.TeacherService;
import com.welearn.view.View;

@Controller
@RequestMapping("teacher/teacher/*")
public class TeacherController {

	@Resource(name="teacherService")
	TeacherService teacherService;
	
	@RequestMapping("getTeacherById")
	public String getTeacherById(@RequestParam(value = "teacherId") int teacherId) {
		
		int id = teacherId;
		
		Teacher teacher = teacherService.getTeacherById(id);
		System.out.println(teacher.toString());
		
		
		return null;
	}
	
	@RequestMapping("publishHomework")
	public String getTeacherBy(
			) {
		
		CourseHomework homework = new CourseHomework("作业一", "预习第二章", 1, new Date(), new Date());
		
		
		boolean flag = teacherService.publishCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}
	
	@RequestMapping("test")
	public String test(
			) {
		
		teacherService.test();
		
		return null;
	}
	
}
