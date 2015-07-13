package com.welearn.controller.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.entity.SchoolCalender;
import com.welearn.model.Building;
import com.welearn.model.Course;
import com.welearn.model.EmptyRoom;
import com.welearn.model.LostThing;
import com.welearn.service.intef.CourseService;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.MisService;
import com.welearn.service.intef.StudentService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.JsonUtil;
import com.welearn.util.TimeUtil;
import com.welearn.view.View;

@Controller
@RequestMapping("student/query/public/*")
public class QueryPublicController {

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

	/**
	 * 查询学校的空教室
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("empty-room")
	public View queryEmptyRoom(@RequestParam(value = "code") String code,HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}

		// 跳转至空教室页面
		view = new View("student", "query-public", "empty-room", "空教室查询");
		// 获得教学楼信息
		List<Building> buildingList = emptyRoomService.getBuildings();
		view.addObject("buildingList", buildingList);
		// 获取当前的时间
		String curDate = TimeUtil.getCurrentDateStrMD();
		String curWeek = TimeUtil.getWeekOfDate(new Date());
		view.addObject("curDate", curDate);
		view.addObject("curWeek", curWeek);
		
		studentService.setSession(session, openid); 
		// 获取空教室列表
		List<EmptyRoom> roomList = emptyRoomService.getEmptyRooms(new Date());
		view.addObject("roomList", roomList);

		return view;
	}

	/**
	 * 查询校历
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("school-schedule")
	public View schoolSchedule(@RequestParam(value = "code") String code,HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}
		
		ArrayList<SchoolCalender> list = misService.getSchoolCalender();
		if(list.isEmpty()){
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}
		
		studentService.setSession(session, openid); 
		view = new View("student", "query-public", "school-schedule", "校历");
		view.addObject("list", list);
		return view;
	}

	/**
	 * 全校课程，为了防止被爬数据，需要进行微信登录检查
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("school-course")
	public View schoolCourse(@RequestParam(value = "code") String code,HttpSession session) {
		View view;
		// 创建微信服务类根据code获取openid
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		if (view != null) {
			// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
			return view;
		}
		
		studentService.setSession(session, openid); 
		view = new View("student", "query-public", "school-course-search",
				"查询全校课程");
		return view;
	}

	/**
	 * 某一门课的详情,为了防止爬取数据，这里需要验证微信登录
	 * 
	 * @param courseid
	 *            课程id
	 * @return
	 */

	@RequestMapping("school-course-detail")
	@Authentication()
	public View schoolCourseDetail(
			@RequestParam(value = "courseid") int courseid) {
		View view;
		// 用课程服务类查询具体的课程信息
		Course course = courseService.queryCourse(courseid);
		if(course == null){
			view = new View("error","wechat","info","课程不存在！");
			view.addObject("info", "课程不存在！");
		}else{
			view = new View("student", "query-public", "school-course-detail",
					course.getName());
			view.addObject("course", course);
		}		
		
		return view;
	}

	/**
	 * 查询全校课程,显示查询结果页面
	 * 
	 * @param keyword
	 * @return
	 */
	@RequestMapping("school-course-query")
	@Authentication()
	public View schoolCourseQuery(@RequestParam("keyword") String keyword) {
		View view ;
		ArrayList<com.welearn.entity.Course> list = courseService.queryCoursesByKeyword(keyword, 1);
		//未找到相应信息
		if(list.isEmpty()){
			view = new View("error", "wechat", "info", "未找到相应课程。");
			view.addObject("info", "未找到相应课程。");
			return view;
		}
				
		// 创建显示页面
		view = new View("student", "query-public", "school-course-list",
				"课程查询结果");
		view.addObject("list", list);
		view.addObject("key", keyword);
		return view;
	}
	
	/**
	 * 查询全校课程,用ajax调用
	 * 
	 * @param pageNo
	 * @param keyword
	 * @return
	 */
	@RequestMapping("school-course-query-page")
	@Authentication()
	@ResponseBody
	public String schoolCourseQueryPage(@RequestParam("pageNo") Integer pageNo,
			@RequestParam("keyword") String keyword) {
		ArrayList<com.welearn.entity.Course> list = courseService.queryCoursesByKeyword(keyword, pageNo);
		String jsonStr = JsonUtil.listToJSONString(list, null);
		System.out.println(pageNo);
		System.out.println(keyword);
		return jsonStr;
	}


	
	/**
	 * 失物招领查询
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("lost-thing")
	public View lostThingDetail(@RequestParam(value = "code") String code,HttpSession session) {
		View view = null;
		// 创建微信服务类根据code获取 openId
		String openid = wechatMsgService.getOpenIdByCode(code);
		// 检验用户是否登录
		view = studentService.checkUser(openid);
		// 用户未登录或者未用微信登录，则跳转到登录界面或提示用户用微信登录
		if (view != null) {
			return view;
		}
		// 获取当月流量
		ArrayList<LostThing> list = misService.queryLostThings(1);
		// 表示获取当月流量出错，则返回至错误页面
		if (list.isEmpty()) {
			view = new View("error", "wechat", "info", "未找到相应信息。");
			view.addObject("info", "未找到相应信息。");
			return view;
		}

		studentService.setSession(session, openid); 
		
		view = new View("student", "query-private", "lost-thing", "失物信息");
		view.addObject("list", list);
		return view;
	}	
	
	
	/**
	 * 失物招领查询,AJAX请求
	 * 
	 * @param pageno
	 * @return
	 */
	@RequestMapping("more-lost-thing")
	@Authentication()
	@ResponseBody
	public String moreLostThingDetail(@RequestParam(value = "pageno") int pageno) {

		// 获取当月流量
		ArrayList<LostThing> list = misService.queryLostThings(pageno);
        String jsonString = JsonUtil.listToJSONString(list, null);
        //System.out.println(jsonString);
		return jsonString;
	}
}
