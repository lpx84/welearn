package com.welearn.controller.student;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.welearn.aop.Authentication;
import com.welearn.model.Building;
import com.welearn.model.EmptyRoom;
import com.welearn.service.impl.EmptyRoomServiceImpl;
import com.welearn.service.impl.UserServiceImpl;
import com.welearn.service.impl.WechatMsgServiceImpl;
import com.welearn.service.intef.EmptyRoomService;
import com.welearn.service.intef.UserService;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.TimeUtil;
import com.welearn.view.View;

@Controller
@RequestMapping("student/query/public/*")
public class QueryPublicController {

	/**
	 * 查询学校的空教室,查询空教室不需要检验微信登录
	 * @return
	 */
	@RequestMapping("empty-room")
	public View queryEmptyRoom() {
		//跳转至空教室页面
		View view = new View("student","query-public","empty-room","空教室查询");
		//获得教学楼信息
		EmptyRoomService roomService = new EmptyRoomServiceImpl();
		List<Building> buildingList = roomService.getBuildings();
		view.addObject("buildingList", buildingList);
		//获取当前的时间
		String curDate = TimeUtil.getCurrentDateStrMD();
		String curWeek = TimeUtil.getWeekOfDate(new Date());
        view.addObject("curDate",curDate);
        view.addObject("curWeek",curWeek);
		//获取空教室列表
		List<EmptyRoom> roomList = roomService.getEmptyRooms(new Date());		
		view.addObject("roomList", roomList);

		return view;
	}
	
	/**
	 * 查询校历，查询学校校历不需要微信登录
	 * @return
	 */
	@RequestMapping("calender")
	public View calender() {
		//从教务处获取
		//List
		View view = new View("student","query-public","school-schedule","校历");
		view.addObject("list", null);
		return view;
	}
	
	
	/**
	 * 全校课程
	 * @param code
	 * @return
	 */
	@RequestMapping("school-course")
	public View schoolCourse(@RequestParam(value="code")String code) {

		
		
		
		
		
		View view = new View("student","query-public","school-course-search","空教室");
		return view;
	}
	
	/**
	 * 查询全校课程
	 * @param pageNo
	 * @param keyword
	 * @return
	 */
	@RequestMapping("school-course-query")
	@Authentication()
	@ResponseBody
	public String schoolCourseQuery(@RequestParam("pageNo")Integer pageNo,
			@RequestParam("keyword")String keyword) {
		
		return null;
	}
	
	
	/**
	 * 失误招领页面
	 * @param code
	 * @return
	 */
	@RequestMapping("lost-thing")
	public View lostThing(@RequestParam(value="code")String code) {
		
		
		
		
		View view = new View("student","query-public","empty-room","空教室");
		return view;
	}
	
	/**
	 * 失物招领查询
	 * @param pageNo
	 * @return
	 */
	@RequestMapping("lost-thing/query")
	@Authentication()
	@ResponseBody
	public String lostThingQuery(@RequestParam("pageNo")Integer pageNo) {
		
		return null;
	}
	
}
