package com.welearn.service.impl;

import javax.annotation.Resource;

import com.welearn.dao.StudentDao;
import com.welearn.service.intef.StudentService;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	public boolean checkBindByOpenId(String openid) {
		// TODO Auto-generated method stub
		return false;
	}

}
