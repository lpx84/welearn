package com.welearn.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.entity.Student;
import com.welearn.entity.Teacher;
import com.welearn.model.WechatTypeEnum;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.view.InfoView;
import com.welearn.view.View;

@Controller
@RequestMapping("student/account/*")
public class StudentController {

	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "teacherService")
	TeacherService teacherService;

	@RequestMapping("bind")
	public View bind(@RequestParam(value = "code") String code) {
		String openId = wechatMsgService.getOpenIdByCode(code,
				WechatTypeEnum.STUDENT);
		View v = new View("student", "account", "bind", "绑定学号");
		v.addObject("openId", openId);
		v.addObject("type", WechatTypeEnum.STUDENT);
		return v;
	}

	@RequestMapping("bind.act")
	public InfoView bindAction(@RequestParam("studentNo") String studentNo,
			@RequestParam("pwd") String pwd,
			@RequestParam("type") WechatTypeEnum type,
			@RequestParam("openId") String openId) {
		if (null == studentNo || null == pwd || "".equals(studentNo)
				|| "".equals(pwd)) {
			return new InfoView("学号和密码不能为空！");
		} else if (null == openId) {
			return new InfoView("请从微信进入！");
		} else {
			if (type == WechatTypeEnum.STUDENT) {
				if (studentNo.length() != 8) {
					return new InfoView("学号必须为8位！");
				} else {
					Student s = studentService.getStudentByStudentNo(studentNo);
					if (null == s) {
						return new InfoView("学号不存在！");
					} else if (s.getPwd().equals(pwd)) {
						s.setOpenId(openId);
						s.setStatus(InfoCode.STUDENT_BINDED);
						studentService.updateStudent(s);
						return new InfoView("绑定学号成功，请关闭本页面，体验其他操作！");
					} else {
						return new InfoView("密码错误，请返回重新输入！");
					}
				}
			} else if (type == WechatTypeEnum.TEACHER) {
				if (studentNo.length() != 4) {
					return new InfoView("工号必须为8位！");
				} else {
					Teacher t = teacherService.getTeacherByTeacherNo(studentNo);
					if (null == t) {
						return new InfoView("工号不存在！");
					} else if (t.getPwd().equals(pwd)) {
						t.setOpenId(openId);
						t.setStatus(InfoCode.STUDENT_BINDED);
						if(teacherService.updateTeacher(t))
						return new InfoView("绑定学号成功，请关闭本页面，体验其他操作！");
						else 
							return new InfoView("数据库更新错误");
					} else {
						return new InfoView("密码错误，请返回重新输入！");
					}
				}
			} else {
				return new InfoView("未从数据等");
			}

		}

	}

	@RequestMapping("test")
	// @Authentication()
	@ResponseBody
	public String test() {
		// Student s = studentService.getStudentByStudentNo("12301124");
		// return s.getTrueName();
		// return new View("teacher","teacher","course-home","sample");
		// List<AttendRecord> r = wechatMsgService.test();

		return "ok: ";
	}

}
