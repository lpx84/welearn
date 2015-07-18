package com.welearn.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import net.sf.json.JSONObject;

import com.qq.weixin.mp.aes.AesException;
import com.welearn.dao.AttendRecordDao;
import com.welearn.dao.AttendTaskDao;
import com.welearn.dao.MsgReplyIndexDao;
import com.welearn.dao.StudentCourseDao;
import com.welearn.dao.StudentDao;
import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.MsgReplyText;
import com.welearn.entity.Student;
import com.welearn.entity.StudentCourse;
import com.welearn.handler.tuling.TulingHandler;
import com.welearn.handler.wechat.MsgReplyFactory;
import com.welearn.model.MsgReceive;
import com.welearn.model.MsgReceiveEvent;
import com.welearn.model.MsgReceivePicture;
import com.welearn.model.MsgReceiveText;
import com.welearn.service.intef.WechatMsgService;
import com.welearn.util.HttpUtil;
import com.welearn.util.InfoCode;
import com.welearn.util.MyHttpClient;
import com.welearn.util.NumberUtil;
import com.welearn.util.WechatConfig;
import com.welearn.util.XmlUtil;

public class WechatMsgServiceImpl implements WechatMsgService {
	// 数据库操作对象
	private MsgReplyIndexDao msgReplyIndexDao;
	private AttendTaskDao attendTaskDao;
	private StudentCourseDao studentCourseDao;
	private StudentDao studentDao;
	private AttendRecordDao attendRecordDao;
	
	
	public void setMsgReplyIndexDao(MsgReplyIndexDao msgReplyIndexDao) {
		this.msgReplyIndexDao = msgReplyIndexDao;
	}

	public void setStudentCourseDao(StudentCourseDao studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setAttendRecordDao(AttendRecordDao attendRecordDao) {
		this.attendRecordDao = attendRecordDao;
	}

	public void setAttendTaskDao(AttendTaskDao attendTaskDao) {
		this.attendTaskDao = attendTaskDao;
	}
	
//	public String getMsgReply(MsgReceive msg) {
//		// TODO Auto-generated method stub
//		
//		String keyword = ((MsgReceiveText)msg).getContent();
//		// 图灵机器人
//		String tulingMsg = null;
//		try {
//			
//			JSONObject json = JSONObject.fromObject(new TulingHandler().getTulingMsg(keyword));
//			if(json.get("code").equals(100000)) {
//				tulingMsg = json.getString("text");
//			} else {
//				tulingMsg = "未处理的返回类型！";
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if (tulingMsg != null) {
//			MsgReplyText text = new MsgReplyText();
//			text.setContent(tulingMsg);
//			return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
//		} else {
//			return XmlUtil.getNullReplyText(msg.getFromUserName(),
//					msg.getToUserName());
//		}
//
//	}

	
	/**
	 * 微信请求返回的格式说明 
	 * {
	 *  "access_token":"ACCESS_TOKEN", 
	 * "expires_in":7200,
	 * "refresh_token":"REFRESH_TOKEN", 
	 * "openid":"OPENID", 
	 * "scope":"SCOPE",
	 * "unionid": "o6_bmasdasdsad6_2sgVt7hMZOPfL" 
	 * }
	 * 根据code获取用户的openid，如果code不存在或者非法，则返回illegal
	 */
	public String getOpenIdByCode(String code) {
		 // 获取用户access_token的url
		 String get_access_token_url =
		 "https://api.weixin.qq.com/sns/oauth2/access_token?"
		 + "appid=" + WechatConfig.appId
		 + "&secret=" + WechatConfig.appsecret
		 + "&code=" + code
		 + "&grant_type=authorization_code";
		 //向微信发送请求，获取openid
		 String json = HttpUtil.getUrl(get_access_token_url);
		 System.out.println(json);
		 JSONObject jsonObject = JSONObject.fromObject(json);
		 String openid = "illegal";
		 try {
		 openid = jsonObject.getString("openid");
		 } catch (Exception e) {
		 System.err.println(e.toString());
		 }
	
		 return openid;
         //return code;
	}
	
	
	/**
	 * 根据接收的消息得到返回的格式化的XML文本消息
	 * @param msg 解密之后明文的消息体
	 * @param isEncode 返回消息是否加密
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException 
	 */
	public String getReplyMsg(MsgReceive msg, boolean isEncode, String timestamp, String nonce) throws AesException {

		String replyMsg = XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());;
		if(msg == null) {
			return replyMsg;
		} else if(msg.getMsgType().equals("text")) {
			
			replyMsg = this.handleTextMsg(msg);
		} else if(msg.getMsgType().equals("image")) {
			replyMsg = this.handlePictureMsg(msg);
		} else if(msg.getMsgType().equals("voice")) {
			//当上传音频时处理代码
			
			replyMsg = this.handleVoiceMsg(msg);
		} else if(msg.getMsgType().equals("event")) {
			
			replyMsg = this.handleEventMsg(msg);
		} else {
			replyMsg = XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());
		}
		
		if(isEncode) {
			replyMsg = MsgReplyFactory.encodeReplyMsg(replyMsg, timestamp, nonce);
		}
		
		return replyMsg;
	}
	
	
	private String handlePictureMsg(MsgReceive msg) {
		//当上传的图片时处理代码
		MsgReceivePicture pic = (MsgReceivePicture)msg;
		String content = "null";
		Student student = studentDao.getStudentByOpenID(pic.getFromUserName());
		Date now = new Date();
		if(null == student) {
			content = "你还没有绑定呢，不能签到！";
		} else {
			AttendRecord record = attendRecordDao.getWaitingAttendRecord(student.getId());
			AttendTask task = attendTaskDao.getAttendTaskById(record.getAttendTaskId());
			if(null == record) {
				content = "你没有签到任务，不能签到！";
			} else if(now.before(task.getStartTime()) || now.after(task.getEndTime())) {
				content = "签到时限已过，你不能再签到了！";
			} else {
				String picUrl = pic.getPicUrl();
				String filePath = "D:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps";
				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(picUrl);
				
				HttpEntity entity = null;
				
				String fileName = "/datafile/file/img/attend/"+student.getStudentNo()+"_"+new Date().getTime()+".jpg";
				filePath += fileName;
				
				try {
					HttpResponse response = client.execute(get);
					entity = response.getEntity();
					InputStream is = entity.getContent();
		            OutputStream os = new FileOutputStream(filePath);
		            IOUtils.copy(is, os);
		            IOUtils.closeQuietly(os);
		            IOUtils.closeQuietly(is);
		            
		            //把filename存入数据库
		            record.setPicUrl(fileName);
		            record.setStatus(InfoCode.ATTEND_VERIFY);
		            record.setLogTime(now);
		            attendRecordDao.updateAttendRecord(record);
		            
		            
		            content = "恭喜，本次签到成功，你可以在课程管理->签到记录中查看历史签到！";
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					content = e.getMessage();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					content = e.getMessage();
				}
			}
		}
		
		MsgReplyText text = new MsgReplyText(content,0);
		return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
	}
	
	
	private String handleEventMsg(MsgReceive msg) {
		//当触发事件时处理代码
		MsgReceiveEvent event = (MsgReceiveEvent)msg;
		if("subscribe".equals(event.getEvent())) { //订阅
//			Student s = studentService.getStudentByOpenId(event.getFromUserName());
//			s.setStatus(InfoCode.STUDENT_SUBSCRIBED);
//			studentService.updateStudent(s);
			return XmlUtil.getWelcomeReplyMsg(event.getFromUserName(), event.getToUserName());
		} else if("unsubscribe".equals(event.getEvent())) { //取消订阅
			return "unsubscribe";
		} else if("click".equals(event.getEvent().toLowerCase())) { //点击事件
			
			if("B_COURSE_ATTEND".equals(event.getEventKey())) { //点击的是签到按钮
				String openId = event.getFromUserName();
				Student student = studentDao.getStudentByOpenID(openId);
				List<StudentCourse> scList = studentCourseDao.getStudentCourseByStudentId(student.getId());
				
				List<AttendTask> attendList = attendTaskDao.getNowAttendTasks(new Date());
				String content = "你当前有以下签到任务，请回复课程前面的数字确认：";
				boolean hasTask = false;
				for(AttendTask a : attendList) {
					for(StudentCourse sc : scList) {
						if(sc.getCourseId().equals(a.getCourseId())) {
							hasTask = true;
							content +=  "\n" + a.getId() +": " + a.getCourseEntity().getName();
							break;
						}
					}
				}
				if(!hasTask) {
					content = "不要着急，你当前没有签到任务！";
				}
				MsgReplyText text = new MsgReplyText(content,0);
				return text.getReplyXML(event.getFromUserName(), event.getToUserName());
				
			} else {
				return XmlUtil.getNullReplyText(event.getFromUserName(), event.getToUserName());
			}
			
		} else {
			return null;
		}
	}
	
	/**
	 * 处理声音消息
	 * @param msg
	 * @return
	 */
	private String handleVoiceMsg(MsgReceive msg) {
		
		return XmlUtil.getNullReplyText(msg.getFromUserName(), msg.getToUserName());
	}
	
	/**
	 * 处理文本消息
	 * @param msg
	 * @return
	 */
	private String handleTextMsg(MsgReceive msg) {
		String keyword = ((MsgReceiveText)msg).getContent();
		if(NumberUtil.isInteger(keyword)) { //如果是数字，默认是签到操作
			Integer attendTaskId = Integer.parseInt(keyword);
			Student s = studentDao.getStudentByOpenID(msg.getFromUserName());
			String content = "null";
			AttendRecord tempAttend = null;
			AttendTask task = attendTaskDao.getAttendTaskById(attendTaskId);
			if(null == task) {
				content = "你选择的签到任务不存在！";
			} else if(null != (tempAttend = attendRecordDao.getAttendRecord(s.getId(), attendTaskId))) {
				if(InfoCode.ATTEND_PREPARE == tempAttend.getStatus()) {
					Date now = new Date();
					if(now.after(task.getStartTime()) && now.before(task.getEndTime())) {
						content = "确认成功，请上传签到图片！";
					} else {
						content = "本次签到时限已过。你不能再签到了！";
					}
				} else {
					content = "你已经完成本次的签到任务！";
				}
				
			} else {
				AttendRecord r = new AttendRecord();
				r.setAttendTaskId(attendTaskId);
				r.setLogTime(new Date());
				r.setReferenceRes(0);
				r.setStatus(InfoCode.ATTEND_PREPARE);
				r.setStudentid(s.getId());
				if(0 < attendRecordDao.addAttendRecord(r)) {
					content = "确认成功，请上传签到图片！";
				} else {
					content = "出现错误，请重新发送该数字！";
				}
				
			}
			MsgReplyText text = new MsgReplyText(content,0);
			return text.getReplyXML(msg.getFromUserName(), msg.getToUserName());
		} else { //如果不是则转到图灵机器人
			return MsgReplyFactory.getMsgReply(msg);
		}
	}
	
}
