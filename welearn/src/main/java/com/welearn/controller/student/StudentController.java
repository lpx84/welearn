package com.welearn.controller.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.welearn.view.InfoView;
import com.welearn.view.View;

@Controller
@RequestMapping("student/account/*")
public class StudentController {

	@RequestMapping("bind")
	public View bind() {
		return new View("student","account","bind","学生绑定账号");
	}
	
	@RequestMapping("bind.act")
	public InfoView bindAction() {
		
		return new InfoView("绑定学号成功，请关闭本页面！");
	}
}
