package com.welearn.controller.teacher.nouse;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.CourseHomework;
import com.welearn.service.intef.TeacherService;

@Controller
@RequestMapping("teacher/teacher/*")
public class HomeworkController {
	
	@Resource(name="teacherService")
	TeacherService teacherService;
	
	/**
	 * 新增作业，但是没有正式发布
	 * @param content
	 * @param courseId
	 * @param title
	 * @param createTime
	 * @param deadline
	 * @return
	 */
	@RequestMapping("addHomework")
	public String addHomework(
			@RequestParam(value = "content") String content,
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "title") String title,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "deadline") Date deadline
			) {
		
		//CourseHomework homework = new CourseHomework(title, content, courseId, createTime, deadline);
		CourseHomework homework = new CourseHomework();
		homework.setCourseId(courseId);
		homework.setTitle(title);
		homework.setContent(content);
		homework.setCreate_time(createTime);
		homework.setDeadline(deadline);
		homework.setStatus(0);
		
		boolean flag = teacherService.publishCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}
	
	/**
	 * 根据作业的id修改作业,修改后正式发布
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
		homework.setStatus(1);
		
		boolean flag = teacherService.updateCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}
	/**
	 * 新增作业之后，回到作业列表，点击发布，发布作业
	 * @param id
	 * @return
	 */
	@RequestMapping("publishHomework")
	public String publishHomework(
			@RequestParam(value = "id") int id
			) {
		CourseHomework homework = teacherService.getHomeworkById(id);
		homework.setStatus(1);
		boolean flag = teacherService.updateCourseHomework(homework);
		System.out.println(flag);
		
		return null;
	}

}
