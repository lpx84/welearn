package com.welearn.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.welearn.dao.CourseDao;
import com.welearn.dao.CourseHomeworkDao;
import com.welearn.dao.CourseNotifyDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseTime;
import com.welearn.entity.Teacher;
import com.welearn.entity.TimeCourse;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseGrade;
import com.welearn.model.ExamPlan;
import com.welearn.model.Semester;
import com.welearn.service.intef.CourseService;
import com.welearn.dao.TimeCourseDao;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;
	private TeacherDao teacherDao;
	private TimeCourseDao timeCourseDao;
	private CourseNotifyDao courseNotifyDao;
	private CourseHomeworkDao courseHomeworkDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setCourseNotifyDao(CourseNotifyDao courseNotifyDao) {
		this.courseNotifyDao = courseNotifyDao;
	}

	public void setTimeCourseDao(TimeCourseDao timeCourseDao) {
		this.timeCourseDao = timeCourseDao;
	}

	public void setCourseHomeworkDao(CourseHomeworkDao courseHomeworkDao) {
		this.courseHomeworkDao = courseHomeworkDao;
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
		// 把各个list添加到总list中
		list.addAll(listByName);
		list.addAll(listByAcadamy);
		list.addAll(listByTeacher);

		return list;
	}

	public com.welearn.model.Course queryCourseModleByCourseId(int courseid) {
		com.welearn.model.Course courseModel = new com.welearn.model.Course();
		Course course = courseDao.getCourse(courseid);
		Teacher teacher = teacherDao.getTeacher(Integer.valueOf(course
				.getTeacherId()));
		TimeCourse timeCourse = timeCourseDao.getTimeCourseById(courseid);

		try {
			// 设置相应的信息
			courseModel.setCapacity(course.getClassSize());
			courseModel.setDescription(course.getDescription());
			courseModel.setName(course.getName());
			courseModel.setSchool(course.getAcademyEntity().getName());
			courseModel.setTeacher(teacher.getTrueName());
			courseModel.setTime(timeCourse.getClassTime());
			courseModel.setPlace(timeCourse.getClassroom());
			courseModel.setCredit(course.getCredit());
			courseModel.setCourseNo(course.getCourseNo());
			courseModel.setId(courseid);
			courseModel.setTeacherTel(teacher.getTel());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courseModel;
	}

	public ArrayList<Semester> querySemesterByStudentId(int studentId) {
		// 获取该学生所拥有的学期
		ArrayList<Semester> semesterList = (ArrayList<Semester>) courseDao
				.getCourseTimeByStudentId(studentId);

		return semesterList;
	}

	public Map<String, ArrayList<Course>> querySemesterCourseByStudentId(
			int studentId) {
		Map<String, ArrayList<Course>> map = new HashMap<String, ArrayList<Course>>();
		// 获取该学生所拥有的学期
		ArrayList<Semester> semesterList = (ArrayList<Semester>) courseDao
				.getCourseTimeByStudentId(studentId);
		// 对 该学生的每一个学期赋值
		for (int i = 0; i < semesterList.size(); i++) {
			ArrayList<Course> courseList = (ArrayList<Course>) courseDao
					.getCoursesByStudentIdAndSemester(studentId, semesterList
							.get(i).getYear(), semesterList.get(i)
							.getSemesterNo());
			map.put(semesterList.get(i).toString(), courseList);
		}

		return map;
	}

	public ArrayList<CourseNotify> queryCourseNotify(int courseId, int pageNo,
			int pageItemNo) {
		ArrayList<CourseNotify> list = (ArrayList<CourseNotify>) courseNotifyDao
				.getCourseNotifyByCourseId(courseId, pageNo, pageItemNo);
		return list;
	}

	public ArrayList<CourseHomework> queryCourseHomework(int courseId,
			int pageNo, int pageItemNo) {
		ArrayList<CourseHomework> list = (ArrayList<CourseHomework>) courseHomeworkDao
				.getCourseHomeworkByCourseId(courseId, pageNo, pageItemNo);
		return list;
	}

}
