package com.welearn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.welearn.dao.CourseDao;
import com.welearn.entity.CourseTime;
import com.welearn.model.Course;
import com.welearn.model.CourseGrade;
import com.welearn.service.intef.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public String getCourseList(String keyword, int pageNo, int academyId) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCourseList(String keyword, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryCourseScheduleByWeek(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List queryCourseScheduleByWeekDay(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course queryCourse(int courseid) {
		// return courseDao.getCourse(courseid);
		// 这里应该通过学习的接口查询课程,先进行模拟
		Course course = new Course();
		course.setCapacity("80");
		course.setDescription("这是张奶奶的课");
		course.setName("系统分析");
		course.setPlace("逸夫楼 yf104");
		course.setSchool("软件学院");
		course.setTeacher("张红延");
		course.setTime("1-16周 周一第4节");

		return course;
	}
    //根据openid获取该同学各门课的成绩
	public Map<String, ArrayList<CourseGrade>> queryCourseGrade(String openid) {
		//新建一个Map对象来获取用户的成绩
		Map<String, ArrayList<CourseGrade>> map = new HashMap<String, ArrayList<CourseGrade>>();
		//模拟生成用户的成绩
		CourseGrade grade;
        ArrayList<CourseGrade> list = new ArrayList<CourseGrade>();
        
        for(int i=0;i<5;i++){
        	grade = new CourseGrade();
        	grade.setCredit("2学分");
        	grade.setGrade("A");
        	grade.setName("系统分析"+i);
        	grade.setSemester("2014-2015学年第二学期");
        	grade.setType("专业课");
        	list.add(grade);        	
        }
        map.put("2014-2015学年第二学期", list);
        
        
        list = new ArrayList<CourseGrade>();        
        for(int i=0;i<5;i++){
        	grade = new CourseGrade();
        	grade.setCredit("2学分");
        	grade.setGrade("A");
        	grade.setName("系统分析"+i);
        	grade.setSemester("2014-2015学年第一学期");
        	grade.setType("专业课");
        	list.add(grade);        	
        }
        map.put("2014-2015学年第一学期", list);
        
		return map;
	}

}
