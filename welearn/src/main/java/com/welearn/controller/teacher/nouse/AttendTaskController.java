package com.welearn.controller.teacher.nouse;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.entity.AttendTask;
import com.welearn.service.intef.TeacherService;

@Controller
@RequestMapping("teacher/teacher/*")
public class AttendTaskController {
	
	@Resource(name="teacherService")
	TeacherService teacherService;
	
	/**
	 * 添加签到任务，但是不发布
	 * @param courseId
	 * @param attendNum
	 * @param createTime
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @return
	 */
	@RequestMapping("addAttendTask")
	public String addAttendTask(
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "attendNum") int attendNum,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "startTime") Date startTime,
			@RequestParam(value = "endTime") Date endTime,
			@RequestParam(value = "name") String name
			) {
		AttendTask attendTask = new AttendTask();
		attendTask.setAttendNum(attendNum);
		attendTask.setCourseId(courseId);
		attendTask.setCreate_time(createTime);
		attendTask.setEndTime(new Date());
		attendTask.setName(name);
		attendTask.setStartTime(startTime);
		attendTask.setStatus(0);
		
		boolean flag = teacherService.publishAttendTask(attendTask);
		
		System.out.println(flag);
		
		return null;
	}
	/**
	 * 修改签到任务
	 * @param courseId
	 * @param attendNum
	 * @param createTime
	 * @param startTime
	 * @param endTime
	 * @param name
	 * @return
	 */
	@RequestMapping("updateAttendTask")
	public String updateAttendTask(
			@RequestParam(value = "courseId") int courseId,
			@RequestParam(value = "attendNum") int attendNum,
			@RequestParam(value = "createTime") Date createTime,
			@RequestParam(value = "startTime") Date startTime,
			@RequestParam(value = "endTime") Date endTime,
			@RequestParam(value = "name") String name
			) {
		AttendTask attendTask = new AttendTask();
		attendTask.setAttendNum(attendNum);
		attendTask.setCourseId(courseId);
		attendTask.setCreate_time(createTime);
		attendTask.setEndTime(new Date());
		attendTask.setName(name);
		attendTask.setStartTime(startTime);
		attendTask.setStatus(0);
		
		boolean flag = teacherService.publishAttendTask(attendTask);
		
		System.out.println(flag);
		
		return null;
	}
	/**
	 * 发布课程签到任务
	 * @param id
	 * @return
	 */
	@RequestMapping("publishAttendTask")
	public String publishAttendTask(
			@RequestParam(value = "id") int id
			) {
		AttendTask attendTask = teacherService.getAttendTaskById(id);
		attendTask.setStatus(1);
		teacherService.updateAttendTask(attendTask);
		return null;
	}

}
