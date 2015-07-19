package com.welearn.controller.student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.model.AttendRecord;
import com.welearn.model.Course;
import com.welearn.model.CourseDiscuss;
import com.welearn.model.CourseProblem;
import com.welearn.model.CourseTestResult;
import com.welearn.model.Semester;
import com.welearn.service.intef.AttendService;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.AlgorithmUtil;
import com.welearn.util.JsonUtil;
import com.welearn.util.TimeUtil;
import com.welearn.view.View;

/**
 * 课程管理类
 * 
 * @author SikentKim
 *
 */
@Controller
@RequestMapping("student/manage/course/*")
public class ManageCourseController {
	@Resource(name = "wechatMsgService")
	WechatMsgService wechatMsgService;
	@Resource(name = "studentService")
	StudentService studentService;
	@Resource(name = "emptyRoomService")
	EmptyRoomService emptyRoomService;
	@Resource(name = "courseService")
	CourseService courseService;
	@Resource(name = "misService")
	MisService misService;
	@Resource(name = "teacherService")
	TeacherService teacherService;
	@Resource(name = "attendService")
	AttendService attendService;

	/**
	 * 查看我的课程
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("course-list")
	public View getCourseList(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}

		// 获取该学生有的学期和他各学期选的课程
		int studentId = studentService.getStudentByOpenId(openid).getId();
		ArrayList<Semester> semesterList = courseService
				.querySemesterByStudentId(studentId);
		Map<String, ArrayList<com.welearn.entity.Course>> map = courseService
				.querySemesterCourseByStudentId(studentId);

		// 如果没有查到，则显示没有 查到
		if (semesterList.isEmpty()) {
			view = new View("error", "wechat", "info", "没有您的选课信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}
		studentService.setSession(session, openid);
		// 返回课程列表
		view = new View("student", "manage-course", "course-list", "我的课程");
		view.addObject("list", semesterList);
		view.addObject("map", map);

		return view;
	}

	/**
	 * 进入某一门课的课程管理页面，为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("course-manage")
	@Authentication()
	public View courseManage(@RequestParam(value = "courseid") int courseid,
			HttpSession session) {
		View view;
		// 用课程服务类查询具体的课程信息
		Course course = courseService.queryCourseModleByCourseId(courseid);
		// 将courseid存入session
		session.setAttribute("courseid", courseid);
		view = new View("student", "manage-course", "course-manage", "我的课程");
		view.addObject("course", course);
		return view;
	}

	/**
	 * 进入某一门课通知页面，为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */
	@RequestMapping("course-notify")
	@Authentication()
	public View courseNotify(HttpSession session) {
		View view = null;
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 用课程服务类查询具体的课程通知
		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotify(courseid, 1, 10);
		// 判断是否有最新通知
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "没有通知信息。");
			view.addObject("info", "没有通知信息。");
			return view;
		}
		view = new View("student", "manage-course", "course-notify", "课程公告");
		view.addObject("courseName", courseName);
		view.addObject("courseid", courseid);
		view.addObject("list", list);

		return view;
	}

	/**
	 * ajax请求更多的课程通知
	 * 
	 * @param courseid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("more-course-notify")
	@Authentication()
	@ResponseBody
	public String moreCourseNotify(@RequestParam(value = "pageNo") int pageNo,
			HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 用课程服务类查询具体的课程通知
		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotify(courseid, pageNo, 10);
		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);

		return jsonStr;
	}

	/**
	 * 获取最新的通知信息
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("course-notify-new")
	public View getCourseNotifyNew(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取该学生有的学期和他各学期选的课程
		int studentId = studentService.getStudentByOpenId(openid).getId();

		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotifyNew(studentId, 1, 10);
		studentService.setSession(session, openid);
		// 判断是否有最新通知
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "没有最新通知。");
			view.addObject("info", "没有最新通知。");
			return view;
		}
		view = new View("student", "manage-course", "course-notify-new", "课程通知");

		view.addObject("list", list);
		return view;
	}

	/**
	 * ajax请求更多的课程通知
	 * 
	 * @param courseid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("more-course-notify-new")
	@Authentication()
	@ResponseBody
	public String moreCourseNotifyNew(
			@RequestParam(value = "pageNo") int pageNo, HttpSession session) {
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		// 用课程服务类查询具体的课程通知
		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotifyNew(studentid, pageNo, 10);
		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);

		return jsonStr;
	}

	/**
	 * 进入某一门课的课程公共页面，为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */
	@RequestMapping("course-homework")
	@Authentication()
	public View courseHomework(HttpSession session) {
		View view;
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 用课程服务类查询具体的课程作业
		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomework(courseid, 1, 10);
		// 判断是否有最新通知
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "没有作业信息。");
			view.addObject("info", "没有作业信息。");
			return view;
		}
		view = new View("student", "manage-course", "course-homework", "课程作业");
		view.addObject("courseName", courseName);
		view.addObject("courseid", courseid);
		view.addObject("list", list);

		return view;
	}

	/**
	 * ajax请求更多的课程作业
	 * 
	 * @param courseid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("more-course-homework")
	@Authentication()
	@ResponseBody
	public String moreCourseHomework(HttpSession session,
			@RequestParam(value = "pageNo") int pageNo) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 用课程服务类查询具体的课程作业
		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomework(courseid, pageNo, 10);

		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);

		return jsonStr;
	}

	/**
	 * 获取最新的通知信息
	 * 
	 * @param code
	 * @param session
	 * @return
	 */
	@RequestMapping("course-homework-new")
	public View getCourseHomeworkNew(@RequestParam(value = "code") String code,
			HttpSession session) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取该学生有的学期和他各学期选的课程
		int studentId = studentService.getStudentByOpenId(openid).getId();
		// 设置session
		studentService.setSession(session, openid);

		// 用课程服务类查询具体的课程作业
		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomeworkNew(studentId, 1, 10);
		// 判断是否有最新通知
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "没有作业信息。");
			view.addObject("info", "没有作业信息。");
			return view;
		}
		view = new View("student", "manage-course", "course-homework-new",
				"最新作业");

		view.addObject("list", list);
		return view;
	}

	/**
	 * ajax获取更多作业 信息
	 * 
	 * @param pageNo
	 * @param session
	 * @return
	 */
	@RequestMapping("more-course-homework-new")
	@Authentication()
	@ResponseBody
	public String moreCourseHomeworkNew(
			@RequestParam(value = "pageNo") int pageNo, HttpSession session) {
		// 用课程服务类查询具体的课程作业
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();

		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomeworkNew(studentid, pageNo, 10);

		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);

		return jsonStr;
	}

	/**
	 * 课程反馈
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */
	@RequestMapping("course-feedback")
	@Authentication()
	public View courseFeedback(HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		View view = new View("student", "manage-course", "course-feedback",
				"课程反馈");
		view.addObject("courseid", courseid);
		view.addObject("courseName", courseName);
		return view;
	}

	/**
	 * 课程反馈
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */
	@RequestMapping("course-feedback.act")
	@Authentication()
	public View courseFeedbackAct(
			@RequestParam(value = "content") String content,
			@RequestParam(value = "anonymous") boolean anonymous,
			HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		View view = null;
		String openid = (String) session.getAttribute("openid");
		String studentName = studentService.getStudentByOpenId(openid)
				.getTrueName();
		System.out.println(anonymous);
		boolean result = courseService.addFeedback(courseid, content,
				anonymous, studentName);

		if (result == false) {
			// 插入失败
			view = new View("error", "wechat", "info", "反馈失败。");
			view.addObject("info", "反馈失败，请稍后再试。");
			return view;
		} else {
			// 插入成功
			view = new View("prompt", "wechat", "info", "反馈成功。");
			view.addObject("info", "反馈成功。。");
			view.addObject("url",
					"student/manage/course/course-manage?courseid=" + courseid);
			return view;
		}
	}

	/**
	 * 课程反馈
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */
	@RequestMapping("course-discuss")
	@Authentication()
	public View courseDiscuss(HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		View view = null;
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();

		// 获取讨论信息的列表
		ArrayList<CourseDiscuss> list = courseService.queryDiscussesBefore(
				courseid, studentid, new Date());

		session.setAttribute("courseid", courseid);
		if (list.size() > 0) {
			session.setAttribute("firstTime", list.get(list.size() - 1)
					.getTime());// 最早的记录时间
		} else {
			session.setAttribute("firstTime", TimeUtil.formatDate1(new Date()));// 最早的记录时间
		}
		session.setAttribute("lastTime", TimeUtil.formatDate1(new Date()));// 最新的记录时间

		// 将list倒置
		ArrayList<CourseDiscuss> list1 = new ArrayList<CourseDiscuss>();
		for (int i = list.size() - 1; i >= 0; i--) {
			list1.add(list.get(i));
		}

		view = new View("student", "manage-course", "course-discuss", "课程讨论");
		view.addObject("courseName", courseName);
		view.addObject("list", list1);

		return view;
	}

	/**
	 * ajax请求最新的对话信息
	 * 
	 * @return
	 */
	@RequestMapping("refresh-course-discuss")
	@Authentication()
	@ResponseBody
	public String refreshCourseDiscuss(HttpSession session) {
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		// 获取上次刷新的时间
		String lastTime = (String) session.getAttribute("lastTime");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
		Date lastTimeDate = new Date();
		try {
			lastTimeDate = sdf.parse(lastTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		session.setAttribute("lastTime", TimeUtil.formatDate1(new Date()));// 最新的记录时间
		// 获取讨论信息的列表
		ArrayList<CourseDiscuss> list = courseService.queryDiscussesAfter(
				courseid, studentid, lastTimeDate);

		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);
		System.out.println(jsonStr);
		return jsonStr;
	}

	/**
	 * ajax请求最新的对话信息
	 * 
	 * @param courseid
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("send-course-discuss-content")
	@Authentication()
	@ResponseBody
	public String sendCourseDiscussContent(
			@RequestParam(value = "content") String content, HttpSession session) {
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();

		Boolean result = courseService.addDiscussContent(courseid, studentid,
				content);

		return JsonUtil.objectToJSONString(result, null);
	}

	@RequestMapping("more-course-discuss")
	@Authentication()
	@ResponseBody
	public String moreCourseDiscuss(HttpSession session) {
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		// 获取上次刷新的时间
		String firstTime = (String) session.getAttribute("firstTime");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
		Date firstTimeDate = new Date();
		try {
			firstTimeDate = sdf.parse(firstTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(firstTimeDate);
		// 获得讨论的消息列表
		ArrayList<CourseDiscuss> list = courseService.queryDiscussesBefore(
				courseid, studentid, firstTimeDate);
		if (list.size() > 0)
			session.setAttribute("firstTime", list.get(list.size() - 1)
					.getTime());// 最早的记录时间

		// 把list用json格式封装
		String jsonStr = JsonUtil.listToJSONString(list, null);
		return jsonStr;
	}

	/**
	 * 签到记录
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("attend-list")
	@Authentication()
	public View eCardDetail(HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取courseName
		String courseName = courseService.queryCourse(courseid).getName();
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		ArrayList<AttendRecord> list = attendService.getAttendRecords(courseid,
				studentid);

		View view = new View("student", "manage-course", "attend-list", "签到记录");
		view.addObject("list", list);
		view.addObject("courseName", courseName);

		return view;
	}

	/**
	 * 课程测试主页面
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("course-test")
	@Authentication()
	public View courseTest(HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取courseName
		String courseName = courseService.queryCourse(courseid).getName();
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		ArrayList<CourseTestResult> list = courseService.queryCourseExamResult(
				courseid, studentid, 1);

		// 查询余额
		View view = new View("student", "manage-course", "course-test", "课程小测");
		view.addObject("list", list);
		view.addObject("courseid", courseid);
		view.addObject("courseName", courseName);
		return view;
	}

	/**
	 * 课程测试，ajax请求
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("more-course-test")
	@Authentication()
	@ResponseBody
	public String moreCourseTest(@RequestParam(value = "pageNo") int pageNo,
			HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();
		ArrayList<CourseTestResult> list = courseService.queryCourseExamResult(
				courseid, studentid, pageNo);
		String jsonStr = JsonUtil.listToJSONString(list, null);
		return jsonStr;
	}

	/**
	 * 测试进行中
	 * 
	 * @param courseid
	 * @param session
	 * @return
	 */
	@RequestMapping("course-testing")
	@Authentication()
	public View courseTesting(HttpSession session) {
		// 从session中获得courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 获取courseName
		String courseName = courseService.queryCourse(courseid).getName();

		ArrayList<CourseProblem> list = courseService
				.generateCourseProblems(courseid);

		View view;
		if (list.size() < 10) {
			view = new View("error", "wechat", "info", "没有习题信息。");
			view.addObject("info", "没有习题信息。");
			return view;
		}

		Date date = new Date();
		// 将开始做题的时间存入session
		session.setAttribute("startTime", TimeUtil.formatDate1(date));
		session.setAttribute("courseid", courseid);
		// 创建测试页面
		view = new View("student", "manage-course", "course-testing", "课程评测");
		view.addObject("list", list);
		view.addObject("courseName", courseName);

		return view;
	}

	/**
	 * 课程测试结果
	 * 
	 * @param answer
	 * @param session
	 * @return
	 */
	@RequestMapping("course-test-result")
	@Authentication()
	public View courseTestResult(@RequestParam(value = "answer") String answer,
			HttpSession session) {
		// 获取courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 从session中获取openid
		String openid = (String) session.getAttribute("openid");
		// 获取courseName
		String courseName = courseService.queryCourse(courseid).getName();
		// 获取studentid
		int studentid = studentService.getStudentByOpenId(openid).getId();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 小写的mm表示的是分钟
		Date startTime = new Date();
		try {
			startTime = sdf.parse((String) session.getAttribute("startTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 获取答题结束的时间
		Date endTime = new Date();
		// 获得分数
		int score = courseService.getCourseScore(answer);
		// 获得答题所用的时间
		int spendTime = AlgorithmUtil.getSpendTime(startTime, endTime);
		// 将答题记录插入
		View view = null;
		if (!courseService.addCourseExamRecord(courseid, studentid, spendTime,
				endTime, score, answer)) {
			// 插入失败
			view = new View("error", "wechat", "info", "数据库存储错误。");
			view.addObject("info", "数据库存储错误。");
			return view;
		}

		// 将答案放入session
		session.setAttribute("answer", answer);

		// 查看评测结果
		view = new View("student", "manage-course", "course-test-result",
				"测评结果");
		view.addObject("courseName", courseName);
		view.addObject("score", score);

		return view;
	}

	/**
	 * 课程测试结果详情
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("course-test-detail")
	@Authentication()
	public View courseTestDetail(HttpSession session) {
		// 获取courseid
		int courseid = (Integer) session.getAttribute("courseid");
		// 获取courseName
		String courseName = courseService.queryCourse(courseid).getName();
		// 获得answer
		String answer = (String) session.getAttribute("answer");

		ArrayList<CourseProblem> list = courseService
				.getWrongCourseProblems(answer);

		View view = null;
		// 没有错误信息
		if (list.size() == 0) {
			view = new View("error", "wechat", "info", "您全答对了，没有错题。");
			view.addObject("info", "您全答对了，没有错题。");
			return view;
		}

		view = new View("student", "manage-course", "course-test-detail",
				"测评详情");
		view.addObject("courseName", courseName);
		view.addObject("list", list);

		return view;
	}
}
