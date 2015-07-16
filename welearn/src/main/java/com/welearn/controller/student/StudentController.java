package com.welearn.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.entity.Student;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.InfoCode;
import com.welearn.view.InfoView;
import com.welearn.view.View;

@Controller
@RequestMapping("student/account/*")
public class StudentController {
	
	@Resource(name="studentService")
	StudentService studentService;
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;

	@RequestMapping("bind")
	public View bind(@RequestParam(value = "code") String code) {
		String openId = wechatMsgService.getOpenIdByCode(code);
		View v = new View("student","account","bind","绑定学号");
		v.addObject("openId",openId);
		return v;
	}
	
	@RequestMapping("bind.act")
	public InfoView bindAction(
			@RequestParam("studentNo")String studentNo,
			@RequestParam("pwd")String pwd,
			@RequestParam("openId")String openId) {
		if( null == studentNo ||
			null == pwd ||
			"".equals(studentNo) ||
			"".equals(pwd)) {
			return new InfoView("学号和密码不能为空！");
		} else if(null == openId) {
			return new InfoView("请从微信进入！");
		} else if(studentNo.length() != 8) {
			return new InfoView("学号必须为8位！");
		} else {
			Student s = studentService.getStudentByStudentNo(studentNo);
			if(null == s) {
				return new InfoView("学号不存在！");
			} else if(s.getPwd().equals(pwd)) {
				s.setOpenId(openId);
				s.setStatus(InfoCode.STUDENT_BINDED);
				studentService.updateStudent(s);
				return new InfoView("绑定学号成功，请关闭本页面，体验其他操作！");
			} else {
				return new InfoView("密码错误，请返回重新输入！");
			}
			
		}
		
	}
	
	@RequestMapping("test")
	@Authentication()
	@ResponseBody
	public View test() {
//		Student s = studentService.getStudentByStudentNo("12301124");
//		return s.getTrueName();
		return new View("teacher","teacher","course-home","sample");
	}
	
}
