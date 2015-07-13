package com.welearn.service.impl;

import com.welearn.dao.TeacherDao;
import com.welearn.entity.Teacher;
import com.welearn.service.intef.TeacherService;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherDao;

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}


	public Teacher getTeacherById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
