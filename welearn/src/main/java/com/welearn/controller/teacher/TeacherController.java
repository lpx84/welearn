package com.welearn.controller.teacher;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.StudentCourse;
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
	 * 根据课程id获得课程
	 * @param id
	 * @return
	 */
	@RequestMapping("getCourseById")
	public String getCourseById(
			@RequestParam(value = "courseId") int id
			) {
		
		System.out.println(teacherService.getCourseById(id).toString());
		
		return null;
	}
	/**
	 * 根据老师的id查找老师的课程列表
	 * @return
	 */
	@RequestMapping("getCourseList")
	public String getCourseList(
			@RequestParam(value = "teacherId") int id
			) {
		
		List<Course> list = teacherService.getCourseList(id);
		/*System.out.println("-------------");
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).toString());
		}*/
		
		return null;
	}
	
	@RequestMapping("getStudentList")
	public String getStudentList(
			) {
		
		teacherService.getStudentList();
		
		return null;
	}
	
	@RequestMapping("getStudentListByCourseId")
	public String getStudentListByCourseId(
			) {
		
		List<StudentCourse> list = teacherService.getStudentListByCourseId(1);
		//这里在可以在model里面加一个处理类，把数据重新封装一下
		for(int i=0;i<list.size();i++){
			System.out.println("---------------");
			System.out.println(list.get(i).getCourseId() +"  "+ list.get(i).getStudentId());
		}
		
		return null;
	}
	
//	@RequestMapping("test")
//	public String test(
//			) {
//		
//		teacherService.test();
//		
//		return null;
//	}
//	
}
