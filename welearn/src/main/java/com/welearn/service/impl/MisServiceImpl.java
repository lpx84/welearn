package com.welearn.service.impl;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.ParseException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.welearn.dao.SchoolCalenderDao;
import com.welearn.entity.SchoolCalender;
import com.welearn.handler.mis.MisHandler;
import com.welearn.model.LostThing;
import com.welearn.service.intef.MisService;

public class MisServiceImpl implements MisService {
	private SchoolCalenderDao schoolCalenderDao;

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
			//获取该页面的信息
			Element ele = misHandler.getLostThing(1);
            
			LostThing lostThing = new LostThing();
			Elements eles = ele.getElementsByTag("tr");
			int size = eles.size();
			System.out.println(size);
			//该页面不存在失物信息
			if(size<=4)
				return null;
			
            //获取该页面的失物信息
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
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

}
