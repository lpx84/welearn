package com.welearn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.welearn.dao.CourseDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.Course;
import com.welearn.entity.CourseTime;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseGrade;
import com.welearn.model.ExamPlan;
import com.welearn.service.intef.CourseService;
import com.welearn.dao.TimeCourseDao;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;
	private TeacherDao teacherDao;
	private TimeCourseDao timeCourseDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;		
	}
	
	public void setTeacherDao(TeacherDao teacherDao){
		this.teacherDao = teacherDao;
	}
	
	public void setTimeCourseDao(TimeCourseDao timeCourseDao){
		this.timeCourseDao = timeCourseDao;
	}

	public List<?> queryCourseScheduleByWeek(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<?> queryCourseScheduleByWeekDay(int id, CourseTime time) {
		// TODO Auto-generated method stub
		return null;
	}

	public Course queryCourse(int courseid) {
		// 这里应该通过学习的接口查询课程,先进行模拟
		Course course = courseDao.getCourse(courseid);
		return course;
	}

	// 根据openid获取该同学各门课的成绩
	public Map<String, ArrayList<CourseGrade>> queryCourseGrade(String openid) {
		// 新建一个Map对象来获取用户的成绩
		Map<String, ArrayList<CourseGrade>> map = new HashMap<String, ArrayList<CourseGrade>>();
		// 模拟生成用户的成绩
		CourseGrade grade;
		ArrayList<CourseGrade> list = new ArrayList<CourseGrade>();

		for (int i = 0; i < 5; i++) {
			grade = new CourseGrade();
			grade.setCredit("2学分");
			grade.setGrade("A");
			grade.setName("系统分析" + i);
			grade.setSemester("2014-2015学年第二学期");
			grade.setType("专业课");
			list.add(grade);
		}
		map.put("2014-2015学年第二学期", list);

		list = new ArrayList<CourseGrade>();
		for (int i = 0; i < 5; i++) {
			grade = new CourseGrade();
			grade.setCredit("2学分");
			grade.setGrade("A");
			grade.setName("系统分析" + i);
			grade.setSemester("2014-2015学年第一学期");
			grade.setType("专业课");
			list.add(grade);
		}
		map.put("2014-2015学年第一学期", list);

		return map;
	}

	public ArrayList<CETGrade> queryCETGrade(String openid) {
		ArrayList<CETGrade> list = new ArrayList<CETGrade>();
		CETGrade grade;
		// 模拟生成用户的成绩
		for (int i = 0; i < 2; i++) {
			grade = new CETGrade();
			grade.setExamNo("1230112" + i);
			grade.setListen("120");
			grade.setName("李鹏翔" + i);
			grade.setRead("123");
			grade.setSchool("北京交通大学");
			grade.setTime("2015-6-20");
			grade.setTotal("530");
			grade.setType("英语六级");
			grade.setWrite("123");
			list.add(grade);
		}
		for (int i = 0; i < 2; i++) {
			grade = new CETGrade();
			grade.setExamNo("1230113" + i);
			grade.setListen("120");
			grade.setName("金林荣" + i);
			grade.setRead("123");
			grade.setSchool("北京交通大学");
			grade.setTime("2015-6-20");
			grade.setTotal("530");
			grade.setType("英语四级");
			grade.setWrite("123");
			list.add(grade);
		}

		return list;
	}

	public ArrayList<ExamPlan> queryExamPlan(String openid) {
		// 模拟生成考试安排
		ArrayList<ExamPlan> list = new ArrayList<ExamPlan>();

		ExamPlan examPlan;

		for (int i = 0; i < 3; i++) {
			examPlan = new ExamPlan();
			examPlan.setBuilding("逸夫楼");
			examPlan.setClassRoom("YF305");
			examPlan.setExamNo("123456789");
			examPlan.setName("系统分析与设计" + i);
			examPlan.setSection("主校区");
			examPlan.setTime("2015-6-30 9:00-11:00");
			list.add(examPlan);
		}

		return list;
	}

	public ArrayList<com.welearn.entity.Course> queryCoursesByKeyword(
			String keyword, int pageno) {
		ArrayList<com.welearn.entity.Course> list = new ArrayList<com.welearn.entity.Course>();
		// 根据课程名模糊查询
		ArrayList<com.welearn.entity.Course> listByName = (ArrayList<com.welearn.entity.Course>) courseDao
				.getCoursesByName(keyword, pageno, 10);
		// 根据学院查询
		ArrayList<com.welearn.entity.Course> listByAcadamy = (ArrayList<com.welearn.entity.Course>) courseDao
				.getCoursesByAcademyName(keyword, pageno, 10);
		ArrayList<com.welearn.entity.Course> listByTeacher = (ArrayList<com.welearn.entity.Course>) courseDao
				.getCoursesByTeacherName(keyword, pageno, 10);
        //把各个list添加到总list中
		list.addAll(listByName);
		list.addAll(listByAcadamy);
		list.addAll(listByTeacher);

		return list;
	}

	public com.welearn.model.Course queryCourseModleByCourseId(int courseid) {
		com.welearn.model.Course courseModel = new com.welearn.model.Course();
		Course course = courseDao.getCourse(courseid);
		String teacherName = teacherDao.getTeacher(
				Integer.valueOf(course.getTeacherId())).getTrueName();

		return courseModel;
	}

}
