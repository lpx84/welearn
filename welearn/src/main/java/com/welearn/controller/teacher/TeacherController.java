package com.welearn.controller.teacher;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.Teacher;
import com.welearn.service.intef.TeacherService;
import com.welearn.view.View;

@Controller
@RequestMapping("teacher/teacher/*")
public class TeacherController {

	@Resource(name="teacherService")
	TeacherService teacherService;
	
	/**
	 * 根据老师的id获取老师信息
	 * @param teacherId
	 * @return
	 */
	@RequestMapping("getTeacherById")
	public String getTeacherById(@RequestParam(value = "teacherId") int teacherId) {
		
		int id = teacherId;
		
		Teacher teacher = teacherService.getTeacherById(id);
		System.out.println(teacher.toString());
		
		return null;
	}
	
	/**
	 * 发布作业
	 * @param content
	 * @param courseId
	 * @param title
	 * @param createTime
	 * @param deadline
	 * @return
	 */
	@RequestMapping("publishHomework")
	public String publishHomework(
			@RequestParam(value = "content") String content,
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "deadline") Date deadline
			) {
		
		CourseHomework homework = new CourseHomework(title, content, courseId, createTime, deadline);
		
		boolean flag = teacherService.publishCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}
	
	/**
	 * 根据作业的id修改作业
	 * @param id
	 * @param content
	 * @param courseId
	 * @param title
	 * @param createTime
	 * @param deadline
	 * @return
	 */
	@RequestMapping("updateHomework")
	public String updateHomework(
			@RequestParam(value = "id") int id,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "deadline") Date deadline
			) {
		
		CourseHomework homework = teacherService.getHomeworkById(id);
		
		homework.setTitle(title);
		homework.setContent(content);
		homework.setCourseId(courseId);
		homework.setCreate_time(createTime);
		homework.setDeadline(deadline);
		
		boolean flag = teacherService.updateCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}
	
	@RequestMapping("publishNotify")
	public String publishNotify(
			@RequestParam(value = "content") String content,
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "status") int status
			) {
		
		CourseNotify courseNotify = new CourseNotify();
		courseNotify.setTitle(title);
		courseNotify.setContent(content);
		courseNotify.setCourseId(courseId);
		courseNotify.setStatus(status);
		courseNotify.setCreate_time(createTime);
		
		teacherService.publisCourseNotify(courseNotify);
		
		return null;
	}
	
	@RequestMapping("test")
	public String test(
			) {
		
		teacherService.test();
		
		return null;
	}
	
}
