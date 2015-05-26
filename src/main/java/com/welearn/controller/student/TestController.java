package com.welearn.controller.student;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.LoginVerify;
import com.welearn.util.InfoCode;
import com.welearn.util.WechatConfig;
import com.welearn.view.View;

@Controller
@RequestMapping("/test/*")
public class TestController {

	@Resource(name="wechatConfig")
	WechatConfig wechatConfig;
	
	@RequestMapping("test")
	@LoginVerify(role=InfoCode.ROLE_STUDENT)
	@ResponseBody
	public String test(@RequestParam("name")String str) {
		
		return wechatConfig.getWxEmail();
	}
	
}
