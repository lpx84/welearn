package com.welearn.service.impl;

import java.util.ArrayList;

import com.welearn.dao.SchoolCalenderDao;
import com.welearn.entity.SchoolCalender;
import com.welearn.service.intef.MisService;

public class MisServiceImpl implements MisService {
	private SchoolCalenderDao schoolCalenderDao;
	
	public void setSchoolCalenderDao(SchoolCalenderDao schoolCalenderDao) {
		this.schoolCalenderDao = schoolCalenderDao;
	}

	public ArrayList<SchoolCalender> getSchoolCalender() {
		ArrayList<SchoolCalender> list = (ArrayList<SchoolCalender>) schoolCalenderDao.getSchoolCalender();
		return list;
	}

}
