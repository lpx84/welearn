package com.welearn.service.impl;

import javax.servlet.http.HttpSession;

import com.welearn.dao.StudentDao;
import com.welearn.entity.Student;
import com.welearn.service.intef.StudentService;
import com.welearn.view.View;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public boolean checkBindByOpenId(String openid) {
		Student student = studentDao.getStudentByOpenID(openid);
		// 学生不存在，或者查出来的学号为空,则返回false,否则返回true
		if (student == null) {
			return false;
		}
		return true;
	}

	public View checkUser(String openid) {
		// 如果用户的openid非法，则跳转至错误显示页面
		if (openid.equals("illegal")) {
			View view = new View("error", "wechat", "info", "Code无效，请用公告平台访问。");
			view.addObject("info", "Code无效，请在公共平台访问。");
			return view;
		}
		// 用户没有绑定账户，则跳转至绑定页面
		if (!checkBindByOpenId(openid)) {
			View view = new View("student", "account", "bind", "绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}		
		
		// 用户已经登录，返回null
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
	
	public void setSession(HttpSession session,String openid){
		Student student = studentDao.getStudentByOpenID(openid);
		session.setAttribute("sid",student.getId());
		session.setAttribute("sno", student.getStudentNo());
		session.setAttribute("sname", student.getTrueName());
		session.setAttribute("openid", openid);
		session.setAttribute("avatar", student.getAvatar());
	}

	
}
