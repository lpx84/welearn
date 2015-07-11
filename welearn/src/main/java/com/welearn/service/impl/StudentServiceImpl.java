package com.welearn.service.impl;

import com.welearn.dao.StudentDao;
import com.welearn.entity.Student;
import com.welearn.model.NetFlow;
import com.welearn.service.intef.StudentService;
import com.welearn.view.View;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public boolean checkBindByOpenId(String openid) {
		Student student = studentDao.getStudentByOpenID(openid);
		//学生不存在，或者查出来的学号为空,则返回false,否则返回true		
		if(student == null){			
			return false;
		}
		return true;
	}
	
	public View checkUser(String openid) {
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","Code无效，请用公告平台访问。");
			view.addObject("info", "Code无效，请在公共平台访问。");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!checkBindByOpenId(openid)){			
			View view = new View("student","account","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		//用户已经登录，返回null
		return null;
	}

	public Student getStudentByOpenId(String openId) {
		return studentDao.getStudentByOpenID(openId);
	}

	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public Student getStudentByStudentNo(String studentNo) {
		return studentDao.getStudentByStudentNo(studentNo);
	}

	public NetFlow getNetFlow(String openid) {
		//模拟生成用户的流量使用情况
		NetFlow netFlow = new NetFlow();
		netFlow.setBalance("1.24");
		netFlow.setExtraFee("0.00");
		netFlow.setFlow("1850.42");
		netFlow.setRestFlow("18593.44");
		netFlow.setTime("6965");
		
		return netFlow;
	}
}
