package com.welearn.controller.teacher;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.CourseNotify;
import com.welearn.service.intef.TeacherService;

@Controller
@RequestMapping("teacher/teacher/*")
public class CourseNotifyConroller {

	@Resource(name="teacherService")
	TeacherService teacherService;
	
	/**
	 * 新增课程通知,但是没有发布
	 * @param content
	 * @param courseId
	 * @param title
	 * @param createTime
	 * @return
	 */
	@RequestMapping("addNotify")
	public String addNotify(
			@RequestParam(value = "content") String content,
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "createTime") Date createTime
			) {
		
		CourseNotify courseNotify = new CourseNotify();
		courseNotify.setTitle(title);
		courseNotify.setContent(content);
		courseNotify.setCourseId(courseId);
		courseNotify.setStatus(0);
		courseNotify.setCreate_time(createTime);
		
		teacherService.publisCourseNotify(courseNotify);
		
		return null;
	}
	
	@RequestMapping("publishNotify")
	public String publishNotify(
			@RequestParam(value = "id") int id
			) {
		
		CourseNotify courseNotify = teacherService.getCourseNotifyById(id);
		courseNotify.setStatus(1);
		boolean flag = teacherService.updateCourseNotify(courseNotify);
		System.out.println(flag);
		
		return null;
	}
}
