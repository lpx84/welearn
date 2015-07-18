package com.welearn.util;

import java.util.HashMap;
import java.util.Map;

public class BuildingUtil {
	//根据教学楼名改变教学楼的标志
	public static Map<String, String> getBuildingLabel() {
        
		Map<String, String> map;
		map = new HashMap<String, String>();
        map.put("逸夫楼", "yf");
        map.put("第九教学楼","9");
        map.put("思源楼", "sy");
        map.put("思源西楼", "sx");
        map.put("机械楼",	"jx");
        map.put("第十七教学楼",	"17");
        map.put("思源东楼", "sd");
        map.put("第二教学楼","2");
        map.put("第五教学楼","5");
        map.put("第八教学楼","8");
        map.put("东区一教","d1");
        map.put("东区二教","d2");
		return  map;
	}
}
