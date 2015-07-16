package com.welearn.handler.facepp;

import org.json.JSONException;
import org.json.JSONObject;

import com.facepp.error.FaceppParseException;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;

public class FaceppHandler {

	private static final String rootUrl = "http://121.194.63.99";
	private HttpRequests httpRequests = new HttpRequests(
			"35e2b87e7d34655c76687a04a8d5158c",
			"X2x-OPIlEcEq1dpi7ovR25mEYh8jfwsF", true, true);
	
	public boolean createPerson(String studentNo, String picPath) {
		JSONObject result = null;
		String url = rootUrl + picPath;
		try {
			
			result = httpRequests.detectionDetect(new PostParameters()
					.setUrl(url));
			
			
			System.out.println("person/create");
			for (int i = 0; i < result.getJSONArray("face").length(); ++i)
				System.out.println(httpRequests
						.personCreate(new PostParameters().setGroupName(
								"group_bjtu").setPersonName(
								"person_" + studentNo + "_" + i)));
			//
			System.out.println("\nperson/add_face");
			for (int i = 0; i < result.getJSONArray("face").length(); ++i)
				System.out.println(httpRequests
						.personAddFace(new PostParameters()
								.setGroupName("group_bjtu")
								.setPersonName("person_" + studentNo + "_" + i)
								.setFaceId(
										result.getJSONArray("face")
												.getJSONObject(i)
												.getString("face_id"))));
			
			System.out.println("\ntrain/verify");
			for (int i = 0; i < result.getJSONArray("face").length(); ++i) {
				httpRequests.trainVerify(new PostParameters()
						.setPersonName("person_" + studentNo + "_" + i));
				
			}
		} catch (FaceppParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.err.println(e.getErrorMessage());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	public boolean recognizePerson(String studentNo, String picPath) {
		
		String url = rootUrl + picPath;
		JSONObject result = null;
		try {
			
			result = httpRequests.detectionDetect(new PostParameters()
					.setUrl(url));
			httpRequests.trainIdentify(new PostParameters()
					.setGroupName("group_bjtu"));
			
//			System.out.println("\nrecognition/verify");
			//System.out.println(result.getJSONArray("face").length());
			
			JSONObject json = httpRequests.recognitionVerify(new PostParameters().setPersonName(
					"person_"+studentNo+"_0").setFaceId(
					result.getJSONArray("face").getJSONObject(0)
							.getString("face_id")));
			
			System.out.println(json.toString());
			return (Boolean) json.get("is_same_person");
		} catch (FaceppParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	/**
	 * 根据学号删除某个学生在facepp的头像资料
	 * @param studentNo
	 * @return
	 */
	public JSONObject deletePerson(String studentNo) {

		//String url = rootUrl + picPath;
		JSONObject result = null;
		try {
			
			//person/delete
			//System.out.println("\nperson/delete");
			System.out.println();
			JSONObject json = httpRequests.personDelete(new PostParameters().setPersonName("person_"+studentNo+"_0"));
			return json;
		} catch (FaceppParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 查询两张图片的相似度调用此方法，这里的path取从数据库读取的值，因为域名在方法内加了,值在80以上基本上就可以判断
	 * 是同一个人
	 * @param avatarPath 学生头像的path
	 * @param picPath	需要验证的图片path
	 * @return
	 * @throws JSONException
	 * @throws FaceppParseException
	 */
	public Double getSimilarity(String avatarPath, String picPath) throws JSONException, FaceppParseException {
		
		JSONObject result1 = httpRequests.detectionDetect(new PostParameters().setUrl(rootUrl + avatarPath));
		if(result1.getJSONArray("face").length() == 0) {
			throw new FaceppParseException("avatarPath：没有发现人脸！");
		}
		
		String face1 = result1.getJSONArray("face").getJSONObject(0).getString("face_id");  
		
		JSONObject result2 = httpRequests.detectionDetect(new PostParameters().setUrl(rootUrl + picPath));  
		if(result2.getJSONArray("face").length() == 0) {
			throw new FaceppParseException("picPath：没有发现人脸！");
		}
		
		String face2 = result2.getJSONArray("face").getJSONObject(0).getString("face_id");  
		
		//对比两张人脸的相似程度  
		JSONObject compare = httpRequests.recognitionCompare(new PostParameters().setFaceId1(face1).setFaceId2(face2));  
		if(compare == null) {
			throw new FaceppParseException("没有获取到相似度数据！");
		}
		//System.out.println(compare);
		return compare.getDouble("similarity");
	}
	
}
