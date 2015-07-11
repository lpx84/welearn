package com.welearn.service.impl;

import java.io.IOException;

import org.apache.http.ParseException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.welearn.dao.StudentDao;
import com.welearn.entity.Student;
import com.welearn.handler.mis.MisHandler;
import com.welearn.model.NetFlow;
import com.welearn.service.intef.StudentService;
import com.welearn.view.View;

public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public boolean checkBindByOpenId(String openid) {
		Student student = studentDao.getStudentByOpenID(openid);
		//学生不存在，或者查出来的学号为空,则返回false,否则返回true		
		if(student == null){			
			return false;
		}
		return true;
	}
	
	public View checkUser(String openid) {
		//如果用户的openid非法，则跳转至错误显示页面
		if(openid.equals("illegal")){
			View view = new View("error","wechat","info","Code无效，请用公告平台访问。");
			view.addObject("info", "Code无效，请在公共平台访问。");
			return view;
		}
		//用户没有绑定账户，则跳转至绑定页面
		if(!checkBindByOpenId(openid)){			
			View view = new View("student","account","bind","绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}
		//用户已经登录，返回null
		return null;
	}

	public Student getStudentByOpenId(String openId) {
		return studentDao.getStudentByOpenID(openId);
	}

	public boolean updateStudent(Student student) {
		return studentDao.updateStudent(student);
	}

	public Student getStudentByStudentNo(String studentNo) {
		return studentDao.getStudentByStudentNo(studentNo);
	}

	public NetFlow getNetFlow(String openid) {
		//模拟生成用户的流量使用情况
		NetFlow netFlow = new NetFlow();
		Student s = studentDao.getStudentByOpenID(openid);
		
//		netFlow.setBalance("1.24");
//		netFlow.setExtraFee("0.00");
//		netFlow.setFlow("1850.42");
//		netFlow.setRestFlow("18593.44");
//		netFlow.setTime("6965");
		try {
			Element ele = new MisHandler().getNetFlowDetail(s.getStudentNo(), s.getPwd());
			if(null == ele) {
				return null;
			}
			Elements eles = ele.getElementsByTag("tr");
			netFlow.setBalance(eles.get(0).getElementsByTag("font").get(0).html());
			netFlow.setExtraFee(eles.get(3).getElementsByAttributeValue("class", "t_r1").get(0).html());
			String flow = eles.get(2).getElementsByAttributeValue("class", "t_r1").get(0).html();
			flow=flow.replace("&nbsp; ", "");
			netFlow.setFlow(flow);
			netFlow.setRestFlow(String.valueOf(20480-Double.parseDouble(flow)));
			netFlow.setTime(eles.get(1).getElementsByAttributeValue("class", "t_r1").get(0).html());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return netFlow;
	}
}
