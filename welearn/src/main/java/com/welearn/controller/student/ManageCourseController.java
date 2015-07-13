package com.welearn.controller.student;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.welearn.model.CETGrade;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.TeacherService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.view.View;
/**
 * 课程管理类
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
	public View getCourseList(@RequestParam(value = "code") String code) {
		View view;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}

		// 获取四六级成绩的list
		ArrayList<CETGrade> list = courseService.queryCETGrade(openid);

		// 如果没有查到成绩，则显示没有 查到成绩
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}

//		// 把四六级分开成两个List
//		ArrayList<CETGrade> cet4List = new ArrayList<CETGrade>();
//		ArrayList<CETGrade> cet6List = new ArrayList<CETGrade>();
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i).getType().equals("英语四级")) {
//				cet4List.add(list.get(i));
//			} else {
//				cet6List.add(list.get(i));
//			}
//		}
//		// 返回四六级成绩列表
//		view = new View("student", "query-private", "grade-english", "四六级成绩");
//		view.addObject("cet4List", cet4List);
//		view.addObject("cet6List", cet6List);
		return view;
	}
	
	
	
}
