package com.welearn.controller.student;

import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.model.Course;
import com.welearn.model.Semester;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.JsonUtil;
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
			view = new View("error", "wechat", "info", "未找到相应信息。");
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
	 *            课程id
	 * @return
	 */

	@RequestMapping("course-manage")
	@Authentication()
	public View courseManage(@RequestParam(value = "courseid") int courseid) {
		View view;
		// 用课程服务类查询具体的课程信息
		Course course = courseService.queryCourseModleByCourseId(courseid);

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
	public View courseNotify(@RequestParam(value = "courseid") int courseid) {
		View view;
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 用课程服务类查询具体的课程通知
		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotify(courseid, 1, 10);

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
	public String moreCourseNotify(
			@RequestParam(value = "courseid") int courseid,
			@RequestParam(value = "pageNo") int pageNo) {
		// 用课程服务类查询具体的课程通知
		ArrayList<com.welearn.model.CourseNotify> list = courseService
				.queryCourseNotify(courseid, pageNo, 10);
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
	public View courseHomework(@RequestParam(value = "courseid") int courseid) {
		View view;
		// 课程名
		String courseName = courseService.queryCourse(courseid).getName();
		// 用课程服务类查询具体的课程作业
		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomework(courseid, 1, 10);

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
	public String moreCourseHomework(
			@RequestParam(value = "courseid") int courseid,
			@RequestParam(value = "pageNo") int pageNo) {
		// 用课程服务类查询具体的课程作业
		ArrayList<com.welearn.model.CourseHomework> list = courseService
				.queryCourseHomework(courseid, pageNo, 10);

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
	public View courseFeedback(@RequestParam(value = "courseid") int courseid) {
		View view;
		view = new View("student", "manage-course", "course-feedback", "课程反馈");
		view.addObject("courseid", courseid);
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
			@RequestParam(value = "courseid") int courseid,
			@RequestParam(value = "content") String content,
			@RequestParam(value = "anonymous") boolean anonymous,
			HttpSession session) {
		View view;
		String openid = (String) session.getAttribute("openid");
		String studentName = studentService.getStudentByOpenId(openid).getTrueName();
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
			view.addObject("url", "student/manage/course/course-manage?courseid"+courseid);
			return view;
		}

	}

}
