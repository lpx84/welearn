package com.welearn.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.ParseException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.welearn.dao.SchoolCalenderDao;
import com.welearn.dao.StudentDao;
import com.welearn.entity.SchoolCalender;
import com.welearn.entity.Student;
import com.welearn.handler.mis.MisHandler;
import com.welearn.model.LostThing;
import com.welearn.model.NetFlow;
import com.welearn.service.intef.MisService;

public class MisServiceImpl implements MisService {
	private SchoolCalenderDao schoolCalenderDao;
	private StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setSchoolCalenderDao(SchoolCalenderDao schoolCalenderDao) {
		this.schoolCalenderDao = schoolCalenderDao;
	}

	public ArrayList<SchoolCalender> getSchoolCalender() {
		ArrayList<SchoolCalender> list = (ArrayList<SchoolCalender>) schoolCalenderDao
				.getSchoolCalender();
		return list;
	}

	public ArrayList<LostThing> queryLostThings(int pageno) {
		MisHandler misHandler = new MisHandler();
		ArrayList<LostThing> list = new ArrayList<LostThing>();
		try {
			// 获取该页面的信息
			Element ele = misHandler.getLostThing(pageno);

			LostThing lostThing = new LostThing();
			Elements eles = ele.getElementsByTag("tr");
			int size = eles.size();

			// 该页面不存在失物信息
			if (size <= 4)
				return list;

			// 获取该页面的失物信息
			for (int i = 1; i < size - 3; i++) {
				Element element = eles.get(i);
				lostThing = new LostThing();
				Elements valEles = element.getElementsByTag("td");
				lostThing.setThing(valEles.get(1).html());
				lostThing.setDescribe(valEles.get(2).html());
				lostThing.setTime(valEles.get(3).html());
				lostThing.setPlace(valEles.get(4).html());
				lostThing.setState(valEles.get(5).html());
				list.add(lostThing);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

	public NetFlow getNetFlow(String openid) {
		// 模拟生成用户的流量使用情况
		NetFlow netFlow = new NetFlow();
		Student s = studentDao.getStudentByOpenID(openid);

		try {
			Element ele = new MisHandler().getNetFlowDetail(s.getStudentNo(),
					s.getGatewayPwd());
			if (null == ele) {
				return netFlow;
			}
			Elements eles = ele.getElementsByTag("tr");
			netFlow.setBalance(eles.get(0).getElementsByTag("font").get(0)
					.html());
			netFlow.setExtraFee(eles.get(3)
					.getElementsByAttributeValue("class", "t_r1").get(0).html());
			String flow = eles.get(2)
					.getElementsByAttributeValue("class", "t_r1").get(0).html();
			flow = flow.replace("&nbsp; ", "");
			netFlow.setFlow(flow);
			netFlow.setRestFlow(String.valueOf(20480 - Double.parseDouble(flow)));
			netFlow.setTime(eles.get(1)
					.getElementsByAttributeValue("class", "t_r1").get(0).html());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			// 超出数组边界
			e.printStackTrace();
		}

		return netFlow;
	}

}
