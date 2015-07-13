package com.welearn.service.intef;

import java.util.ArrayList;

import com.welearn.entity.SchoolCalender;
import com.welearn.model.LostThing;
import com.welearn.model.NetFlow;
/**
 * 这是查询学校校历的服务类
 * @author SikentKim
 *
 */
public interface MisService {
	/**
	 * 这是查询学校校历的方法
	 * @return
	 */
    public ArrayList<SchoolCalender> getSchoolCalender();
    
    /**
     * 查询失物信息
     * @return
     */
    public ArrayList<LostThing> queryLostThings(int pageno);
	/**
	 * 根据用户的openid来获取用户的流量使用情况
	 * @param openid
	 * @return
	 */
	public NetFlow getNetFlow(String openid);
}
