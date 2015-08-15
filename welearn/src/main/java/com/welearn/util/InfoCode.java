/**
 * 定义系统的操作代码，以进行错误处理
 */
package com.welearn.util;

/**
 * @author Tracy
 *
 */
public class InfoCode {

	/************************通用的code定义*************************/
	public static final Integer OK = 200; //正确
	public static final Integer UNKNOWN = -1; //未知的错误
	public static final Integer OTHER_ERROR = 0; //其他信息
	public static final Integer PERMISSION_DENIED = 201; //权限不足
	public static final Integer LOGIN_TIMEOUT = 202; //登录超时
	
	/***********状态：已被删除*********/
	public static final Integer STATUS_DELETED = 0;
	
	/***********身份：学生*********/
	public static final int ROLE_STUDENT = 1;
	/***********身份：老师*********/
	public static final int ROLE_TEACHER = 2;
	/***********身份：管理员*********/
	public static final int ROLE_ADMIN = 3;
	
	/***********通知状态：未发布*********/
	public static final Integer NOTIFY_NOT_PUBLISHED = 1;
	/***********通知状态：已发布*********/
	public static final Integer NOTIFY_PUBLISHED = 2;
	
	/***********消息状态：未读*********/
	public static final Integer MSG_NOT_READED = 0;
	/***********消息状态：已读*********/
	public static final Integer MSG_READED = 1;
	
	/***********学生状态：未关注*********/
	public static final Integer STUDENT_UNSUBSCRIBE = 0;
	/***********学生状态：已经关注公众号未绑定学号*********/
	public static final Integer STUDENT_SUBSCRIBED = 1;
	/***********学生状态：已绑定学号*********/
	public static final Integer STUDENT_BINDED = 2;
	
	/***********签到记录状态：未签到*********/
	public static final Integer ATTEND_NOT = 0;
	/***********签到记录状态：准备签到*********/
	public static final Integer ATTEND_PREPARE = 1;
	/***********签到记录状态：等待审核*********/
	public static final Integer ATTEND_VERIFY = 2;
	/***********签到记录状态：审核通过*********/
	public static final Integer ATTEND_PASS = 3;
	/***********签到记录状态：审核未通过*********/
	public static final Integer ATTEND_NOT_PASS = -1;
	
	
	
	/***************教师页面导航页面:通知页面****************/
	public static final Integer NOTIFY = 1;
	/***************教师页面导航页面:通知页面****************/
	public static final Integer COURSE = 2;
	/***************教师页面导航页面:通知页面****************/
	public static final Integer PERSONAL = 3;
	
}
