package com.welearn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.welearn.dao.CourseDao;
import com.welearn.dao.CourseExamDao;
import com.welearn.dao.CourseFeedbackDao;
import com.welearn.dao.CourseHomeworkDao;
import com.welearn.dao.CourseNotifyDao;
import com.welearn.dao.CourseOptionDao;
import com.welearn.dao.CourseProblemDao;
import com.welearn.dao.CourseReplyDao;
import com.welearn.dao.StudentDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.Course;
import com.welearn.entity.CourseExam;
import com.welearn.entity.CourseFeedback;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.CourseOption;
import com.welearn.entity.CourseReply;
import com.welearn.entity.Student;
import com.welearn.entity.Teacher;
import com.welearn.entity.TimeCourse;
import com.welearn.model.CETGrade;
import com.welearn.model.CourseAnswer;
import com.welearn.model.CourseDiscuss;
import com.welearn.model.CourseGrade;
import com.welearn.model.CourseProblem;
import com.welearn.model.CourseTestResult;
import com.welearn.model.ExamPlan;
import com.welearn.model.Semester;
import com.welearn.service.intef.CourseService;
import com.welearn.util.AlgorithmUtil;
import com.welearn.util.TimeUtil;
import com.welearn.dao.TimeCourseDao;

public class CourseServiceImpl implements CourseService {
	private CourseDao courseDao;
	private TeacherDao teacherDao;
	private TimeCourseDao timeCourseDao;
	private CourseNotifyDao courseNotifyDao;
	private CourseHomeworkDao courseHomeworkDao;
	private CourseFeedbackDao courseFeedbackDao;
	private CourseReplyDao courseReplyDao;
	private StudentDao studentDao;
	private CourseExamDao courseExamDao;
	private CourseProblemDao courseProblemDao;
	private CourseOptionDao courseOptionDao;

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

	public void setCourseFeedbackDao(CourseFeedbackDao courseFeedbackDao) {
		this.courseFeedbackDao = courseFeedbackDao;
	}

	public void setCourseReplyDao(CourseReplyDao courseReplyDao) {
		this.courseReplyDao = courseReplyDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setCourseExamDao(CourseExamDao courseExamDao) {
		this.courseExamDao = courseExamDao;
	}

	public void setCourseProblemDao(CourseProblemDao courseProblemDao) {
		this.courseProblemDao = courseProblemDao;
	}

	public void setCourseOptionDao(CourseOptionDao courseOptionDao) {
		this.courseOptionDao = courseOptionDao;
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

		// for (int i = 0; i < 5; i++) {
		// grade = new CourseGrade();
		// grade.setCredit("2学分");
		// grade.setGrade("A");
		// grade.setName("系统分析" + i);
		// grade.setSemester("2014-2015学年第二学期");
		// grade.setType("专业课");
		// list.add(grade);
		// }

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A+");
		grade.setName("软件工程专业研究方法论");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("专业限选课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A+");
		grade.setName("信息安全理论与实践");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("专业课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("1学分");
		grade.setGrade("P");
		grade.setName("前沿技术讲座");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("专业拓展课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("P");
		grade.setName("高清人文电影鉴赏与研究");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("全校任选课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("P");
		grade.setName("婚姻、家庭与继承法");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("全校任选课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A");
		grade.setName("移动应用开发技术");
		grade.setSemester("2014-2015学年第二学期");
		grade.setType("专业限选课");
		list.add(grade);

		map.put("2014-2015学年第二学期", list);

		list = new ArrayList<CourseGrade>();
		// for (int i = 0; i < 5; i++) {
		// grade = new CourseGrade();
		// grade.setCredit("2学分");
		// grade.setGrade("A");
		// grade.setName("系统分析" + i);
		// grade.setSemester("2014-2015学年第一学期");
		// grade.setType("专业课");
		// list.add(grade);
		// }

		grade = new CourseGrade();
		grade.setCredit("4学分");
		grade.setGrade("A");
		grade.setName("大型数据库应用");
		grade.setSemester("2014-2015学年第一学期");
		grade.setType("专业课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A+");
		grade.setName("Linux操作系统与网络编程");
		grade.setSemester("2014-2015学年第一学期");
		grade.setType("专业限选课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A");
		grade.setName("软件项目管理");
		grade.setSemester("2014-2015学年第一学期");
		grade.setType("专业课");
		list.add(grade);

		grade = new CourseGrade();
		grade.setCredit("2学分");
		grade.setGrade("A+");
		grade.setName("Java EE架构与应用");
		grade.setSemester("2014-2015学年第一学期");
		grade.setType("专业限选课");
		list.add(grade);

		map.put("2014-2015学年第一学期", list);

		return map;
	}

	public ArrayList<CETGrade> queryCETGrade(String openid) {
		ArrayList<CETGrade> list = new ArrayList<CETGrade>();
		CETGrade grade;
		// 模拟生成用户的成绩
		for (int i = 0; i < 1; i++) {
			grade = new CETGrade();
			grade.setExamNo("12301124");
			grade.setListen("180");
			grade.setName("李鹏翔");
			grade.setRead("223");
			grade.setSchool("北京交通大学");
			grade.setTime("2015-6-20");
			grade.setTotal("526");
			grade.setType("英语六级");
			grade.setWrite("123");
			list.add(grade);
		}
		for (int i = 0; i < 1; i++) {
			grade = new CETGrade();
			grade.setExamNo("12301121");
			grade.setListen("120");
			grade.setName("金林荣");
			grade.setRead("203");
			grade.setSchool("北京交通大学");
			grade.setTime("2015-6-20");
			grade.setTotal("475");
			grade.setType("英语四级");
			grade.setWrite("152");
			list.add(grade);
		}

		return list;
	}

	public ArrayList<ExamPlan> queryExamPlan(String openid) {
		// 模拟生成考试安排
		ArrayList<ExamPlan> list = new ArrayList<ExamPlan>();

		ExamPlan examPlan;

		for (int i = 0; i < 1; i++) {
			examPlan = new ExamPlan();
			examPlan.setBuilding("思源西楼");
			examPlan.setClassRoom("SX205");
			examPlan.setExamNo("103143254");
			examPlan.setName("软件体系结构");
			examPlan.setSection("主校区");
			examPlan.setTime("2015-07-06 9:00-11:00");
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
		ArrayList<TimeCourse> timeCourse = (ArrayList<TimeCourse>) timeCourseDao.getTimeCourseByCourseId(courseid);

		try {
			// 设置相应的信息
			courseModel.setCapacity(course.getClassSize());
			courseModel.setDescription(course.getDescription());
			courseModel.setName(course.getName());
			courseModel.setSchool(course.getAcademyEntity().getName());
			courseModel.setTeacher(teacher.getTrueName());
			if(timeCourse != null) {
				String time = "";
				String place = "";
				for(int i=0;i<timeCourse.size();i++){
					time = time +timeCourse.get(i).getClassTime()+" ";
					place = place+timeCourse.get(i).getClassroom()+" ";
				}
				
				courseModel.setTime(time);
				courseModel.setPlace(place);
			}
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

	public ArrayList<com.welearn.model.CourseNotify> queryCourseNotify(
			int courseId, int pageNo, int pageItemNo) {
		ArrayList<CourseNotify> list = (ArrayList<CourseNotify>) courseNotifyDao
				.getCourseNotifyByCourseId(courseId, pageNo, pageItemNo);
		ArrayList<com.welearn.model.CourseNotify> modelList = new ArrayList<com.welearn.model.CourseNotify>();
		for (int i = 0; i < list.size(); i++) {
			com.welearn.model.CourseNotify courseModel = new com.welearn.model.CourseNotify();
			if (list.get(i).getStatus() == 1) {
				courseModel.setContent(list.get(i).getContent());
				courseModel.setCourseId(list.get(i).getId());
				courseModel.setCourseName(list.get(i).getCourseEntity()
						.getName());
				courseModel.setCreate_time(TimeUtil.formatDate(list.get(i)
						.getCreate_time()));
				courseModel.setTitle(list.get(i).getTitle());
				modelList.add(courseModel);
			}

		}

		return modelList;
	}

	public ArrayList<com.welearn.model.CourseNotify> queryCourseNotifyNew(
			int studentid, int pageNo, int pageItemNo) {
		ArrayList<CourseNotify> list = (ArrayList<CourseNotify>) courseNotifyDao
				.getCourseNotifysByStudentId(studentid, pageNo, pageItemNo);
		ArrayList<com.welearn.model.CourseNotify> modelList = new ArrayList<com.welearn.model.CourseNotify>();
		for (int i = 0; i < list.size(); i++) {
			com.welearn.model.CourseNotify courseModel = new com.welearn.model.CourseNotify();
			if (list.get(i).getStatus() == 1) {
				courseModel.setContent(list.get(i).getContent());
				courseModel.setCourseId(list.get(i).getId());
				courseModel.setCreate_time(TimeUtil.formatDate(list.get(i)
						.getCreate_time()));
				courseModel.setCourseName(list.get(i).getCourseEntity()
						.getName());
				courseModel.setTitle(list.get(i).getTitle());
				modelList.add(courseModel);
			}

		}

		return modelList;
	}

	public ArrayList<com.welearn.model.CourseHomework> queryCourseHomework(
			int courseId, int pageNo, int pageItemNo) {
		ArrayList<CourseHomework> list = (ArrayList<CourseHomework>) courseHomeworkDao
				.getCourseHomeworkByCourseId(courseId, pageNo, pageItemNo);
		ArrayList<com.welearn.model.CourseHomework> modelList = new ArrayList<com.welearn.model.CourseHomework>();

		for (int i = 0; i < list.size(); i++) {
			com.welearn.model.CourseHomework courseHomework = new com.welearn.model.CourseHomework();
			if (list.get(i).getStatus() == 1) {
				courseHomework.setContent(list.get(i).getContent());
				courseHomework.setCourseId(list.get(i).getCourseId());
				courseHomework.setCreate_time(TimeUtil.formatDate(list.get(i)
						.getCreate_time()));
				courseHomework.setDeadline(TimeUtil.formatDate(list.get(i)
						.getDeadline()));
				courseHomework.setTitle(list.get(i).getTitle());
				modelList.add(courseHomework);
			}
		}

		return modelList;
	}

	public ArrayList<com.welearn.model.CourseHomework> queryCourseHomeworkNew(
			int studentid, int pageNo, int pageItemNo) {
		ArrayList<CourseHomework> list = (ArrayList<CourseHomework>) courseHomeworkDao
				.getCourseHomeworksByStudentId(studentid, pageNo, pageItemNo);
		ArrayList<com.welearn.model.CourseHomework> modelList = new ArrayList<com.welearn.model.CourseHomework>();

		for (int i = 0; i < list.size(); i++) {
			com.welearn.model.CourseHomework courseHomework = new com.welearn.model.CourseHomework();
			if (list.get(i).getStatus() == 1) {
				courseHomework.setContent(list.get(i).getContent());
				courseHomework.setCourseId(list.get(i).getCourseId());
				courseHomework.setCourseName(list.get(i).getCourseEntity()
						.getName());
				courseHomework.setCreate_time(TimeUtil.formatDate(list.get(i)
						.getCreate_time()));
				courseHomework.setDeadline(TimeUtil.formatDate(list.get(i)
						.getDeadline()));
				courseHomework.setTitle(list.get(i).getTitle());
				modelList.add(courseHomework);
			}
		}

		return modelList;
	}

	public boolean addFeedback(int courseid, String content, boolean anonymous,
			String studentName) {
		CourseFeedback courseFeedback = new CourseFeedback();
		courseFeedback.setContent(content);
		courseFeedback.setCourseId(courseid);
		courseFeedback.setTime(TimeUtil.formatDate1(new Date()));
		// 如果用户选择非匿名，则设置用户的id
		if (!anonymous) {
			courseFeedback.setStudentName(studentName);
		}

		int returnMode = courseFeedbackDao.addCourseFeedback(courseFeedback);

		if (returnMode > 0) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<CourseDiscuss> queryDiscussesBefore(int courseid,
			int studentid, Date date) {
		ArrayList<CourseDiscuss> modelList = new ArrayList<CourseDiscuss>();
		ArrayList<CourseReply> replyList = (ArrayList<CourseReply>) courseReplyDao
				.getCourseReplyByTimeBefore(courseid, date, 7);
		for (int i = 0; i < replyList.size(); i++) {
			CourseDiscuss courseDiscuss = new CourseDiscuss();
			CourseReply courseReply = replyList.get(i);

			courseDiscuss.setMe(false);
			if (courseReply.getType() == 1) {
				// 是学生
				Student student = studentDao.getStudent(courseReply
						.getReplyId());
				courseDiscuss.setAvatar(student.getAvatar());// 设置头像Url
				courseDiscuss.setRelayorName(student.getTrueName());// 设置姓名
				// 是学生本人
				if (courseReply.getReplyId() == studentid) {
					courseDiscuss.setMe(true);
				}
			} else {
				// 是老师
				Teacher teacher = teacherDao.getTeacher(courseReply
						.getReplyId());
				courseDiscuss.setAvatar(teacher.getAvatar());// 设置头像Url
				courseDiscuss.setRelayorName(teacher.getTrueName());// 设置名字
			}
			courseDiscuss.setContent(courseReply.getContent());
			courseDiscuss.setCourseId(courseReply.getCourseId());
			courseDiscuss.setId(courseReply.getId());
			courseDiscuss.setReplayorId(courseReply.getReplyId());
			courseDiscuss.setTime(TimeUtil.formatDate1(courseReply
					.getReply_time()));
			courseDiscuss.setType(courseReply.getType());

			modelList.add(courseDiscuss);
		}

		return modelList;
	}

	public ArrayList<CourseDiscuss> queryDiscussesAfter(int courseid,
			int studentid, Date date) {
		ArrayList<CourseDiscuss> modelList = new ArrayList<CourseDiscuss>();
		ArrayList<CourseReply> replyList = (ArrayList<CourseReply>) courseReplyDao
				.getCourseReplyByTimeAfter(courseid, date);
		for (int i = 0; i < replyList.size(); i++) {
			CourseDiscuss courseDiscuss = new CourseDiscuss();
			CourseReply courseReply = replyList.get(i);

			courseDiscuss.setMe(false);
			if (courseReply.getType() == 1) {
				// 是学生
				Student student = studentDao.getStudent(courseReply
						.getReplyId());
				courseDiscuss.setAvatar(student.getAvatar());// 设置头像Url
				courseDiscuss.setRelayorName(student.getTrueName());// 设置姓名
				// 是学生本人
				if (courseReply.getReplyId() == studentid) {
					courseDiscuss.setMe(true);
				}
			} else {
				// 是老师
				Teacher teacher = teacherDao.getTeacher(courseReply
						.getReplyId());
				courseDiscuss.setAvatar(teacher.getAvatar());// 设置头像Url
				courseDiscuss.setRelayorName(teacher.getTrueName());// 设置名字
			}
			courseDiscuss.setContent(courseReply.getContent());
			courseDiscuss.setCourseId(courseReply.getCourseId());
			courseDiscuss.setId(courseReply.getId());
			courseDiscuss.setReplayorId(courseReply.getReplyId());
			courseDiscuss.setTime(TimeUtil.formatDate1(courseReply
					.getReply_time()));
			courseDiscuss.setType(courseReply.getType());

			modelList.add(courseDiscuss);
		}

		return modelList;
	}

	public boolean addDiscussContent(int courseid, int studentid, String content) {
		CourseReply courseReply = new CourseReply();
		courseReply.setContent(content);
		courseReply.setCourseId(courseid);
		courseReply.setReply_time(new Date());
		courseReply.setReplyId(studentid);
		courseReply.setType(1);
		courseReply.setStatus(1);

		int result = courseReplyDao.AddCourseReply(courseReply);
		if (result > 0)
			return true;
		else
			return false;
	}

	public ArrayList<CourseTestResult> queryCourseExamResult(int courseid,
			int studentid, int pageNo) {
		ArrayList<CourseExam> list = (ArrayList<CourseExam>) courseExamDao
				.getCourseExamByCourseIdandStudentId(courseid, studentid,
						pageNo, 3);
		ArrayList<CourseTestResult> modelList = new ArrayList<CourseTestResult>();

		// 转化格式
		for (int i = 0; i < list.size(); i++) {
			CourseTestResult result = new CourseTestResult();
			result.setScore(String.valueOf(list.get(i).getScore()));
			result.setSpendTime(TimeUtil.transSpendTime(list.get(i)
					.getSpendTime()));
			result.setTime(TimeUtil.formatDate2(list.get(i).getFinishTime()));
			result.setResult(list.get(i).getAnswer());
			modelList.add(result);
		}

		return modelList;
	}

	public ArrayList<CourseProblem> generateCourseProblems(int courseid) {
		ArrayList<CourseProblem> modelList = new ArrayList<CourseProblem>();

		ArrayList<com.welearn.entity.CourseProblem> list = (ArrayList<com.welearn.entity.CourseProblem>) courseProblemDao
				.getCourseProblemByCourseId(courseid);
		int size = list.size();
		int randomNum = (int) Math.random() * size;

		for (int i = 0; i < 10; i++) {
			int num = (randomNum + i) % size;
			com.welearn.entity.CourseProblem problem = list.get(num);
			CourseProblem courseProblem = new CourseProblem();
			courseProblem.setAnswer(problem.getAnswer());
			courseProblem.setComment(problem.getComment());
			courseProblem.setContent(problem.getContent());
			courseProblem.setCourseId(problem.getCourseId());
			courseProblem.setId(problem.getId());
			courseProblem.setScore(problem.getScore());
			courseProblem.setStatus(problem.getStatus());

			ArrayList<CourseOption> optionList = (ArrayList<CourseOption>) courseOptionDao
					.getCourseOptionByProblemId(problem.getId());
			courseProblem.setOptions(optionList);
			modelList.add(courseProblem);
		}

		return modelList;
	}

	public boolean addCourseExamRecord(int courseid, int studentid,
			int spendTime, Date finishTime, int score, String answer) {
		CourseExam courseExam = new CourseExam();
		courseExam.setCourseId(courseid);
		courseExam.setStudentId(studentid);
		courseExam.setSpendTime(spendTime);
		courseExam.setFinishTime(finishTime);
		courseExam.setScore(score);
		courseExam.setAnswer(answer);
		courseExam.setStatus(0);

		int result = courseExamDao.addCourseExam(courseExam);
		if (result > 0)
			return true;
		else
			return false;
	}

	public int getCourseScore(String answer) {
		ArrayList<CourseAnswer> list = AlgorithmUtil.getCourseAnswers(answer);
		int score = 0;
		for (int i = 0; i < list.size(); i++) {
			CourseAnswer ans = list.get(i);
			com.welearn.entity.CourseProblem problem = courseProblemDao
					.getCourseProblemById(ans.getProblemId());
			// 如果答案正确
			if (problem.getAnswer().equals(ans.getAnswer())) {
				score = score + problem.getScore();
			}
		}

		return score;
	}

	public ArrayList<CourseProblem> getWrongCourseProblems(String answer) {
		// 存储问题的列表
		ArrayList<CourseProblem> modelList = new ArrayList<CourseProblem>();
		// 将字符串的answer转化为相应对象
		ArrayList<CourseAnswer> list = AlgorithmUtil.getCourseAnswers(answer);
		// 遍历每一个答案，把错误的答案列出来
		for (int i = 0; i < list.size(); i++) {
			CourseAnswer ans = list.get(i);
			com.welearn.entity.CourseProblem problem = courseProblemDao
					.getCourseProblemById(ans.getProblemId());
			// 如果答案错误
			if (!problem.getAnswer().equals(ans.getAnswer())) {
				CourseProblem courseProblem = new CourseProblem();
				courseProblem.setAnswer(problem.getAnswer());
				courseProblem.setComment(problem.getComment());
				courseProblem.setContent(problem.getContent());
				courseProblem.setCourseId(problem.getCourseId());
				courseProblem.setId(problem.getId());
				courseProblem.setScore(problem.getScore());
				courseProblem.setStatus(problem.getStatus());
				courseProblem.setWrongAnswer(ans.getAnswer());// 错误的答案
				courseProblem.setDisplayNo(Integer.valueOf(ans.getDisplayNo()));

				ArrayList<CourseOption> optionList = (ArrayList<CourseOption>) courseOptionDao
						.getCourseOptionByProblemId(problem.getId());
				courseProblem.setOptions(optionList);
				modelList.add(courseProblem);
			}
		}
		return modelList;
	}

}
