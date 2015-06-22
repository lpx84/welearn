package com.welearn.service.impl;

import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.UserService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;

public class UserServiceImpl implements UserService {

	public View checkUser(String openid) {
		//创建一个学生服务类，来判断学生是否登录
		StudentService studentService = new StudentServiceImpl();

		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","请用微信登录！");
			view.addObject("info", "请用微信登录！");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!studentService.checkBindByOpenId(openid)){			
			View view = new View("student","user-course","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		//用户已经登录，返回null
		return null;
	}

}
