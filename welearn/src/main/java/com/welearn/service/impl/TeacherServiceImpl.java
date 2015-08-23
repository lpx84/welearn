package com.welearn.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.welearn.dao.AttendRecordDao;
import com.welearn.dao.AttendTaskDao;
import com.welearn.dao.CourseDao;
import com.welearn.dao.CourseHomeworkDao;
import com.welearn.dao.CourseNotifyDao;
import com.welearn.dao.CourseReplyDao;
import com.welearn.dao.StudentCourseDao;
import com.welearn.dao.StudentDao;
import com.welearn.dao.TeacherDao;
import com.welearn.entity.AttendRecord;
import com.welearn.entity.AttendTask;
import com.welearn.entity.Course;
import com.welearn.entity.CourseHomework;
import com.welearn.entity.CourseNotify;
import com.welearn.entity.Student;
import com.welearn.entity.StudentCourse;
import com.welearn.entity.Teacher;
import com.welearn.model.WechatTypeEnum;
import com.welearn.service.intef.TeacherService;
import com.welearn.util.InfoCode;
import com.welearn.util.NotifyUtil;
import com.welearn.util.TimeUtil;
import com.welearn.view.View;

public class TeacherServiceImpl implements TeacherService {

	TeacherDao teacherDao;
	CourseHomeworkDao courseHomeworkDao;
	CourseNotifyDao courseNotifyDao;
	CourseDao courseDao;
	AttendTaskDao attendTaskDao;
	StudentDao studentDao;
	StudentCourseDao studentCourseDao;
	CourseReplyDao courseReplyDao;
	AttendRecordDao attendRecordDao;

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public void setAttendRecordDao(AttendRecordDao attendRecordDao) {
		this.attendRecordDao = attendRecordDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public void setCourseHomeworkDao(CourseHomeworkDao courseHomeworkDao) {
		this.courseHomeworkDao = courseHomeworkDao;
	}

	public void setCourseNotifyDao(CourseNotifyDao courseNotifyDao) {
		this.courseNotifyDao = courseNotifyDao;
	}

	public void setAttendTaskDao(AttendTaskDao attendTaskDao) {
		this.attendTaskDao = attendTaskDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void setStudentCourseDao(StudentCourseDao studentCourseDao) {
		this.studentCourseDao = studentCourseDao;
	}

	public void setCourseReplyDao(CourseReplyDao courseReplyDao) {
		this.courseReplyDao = courseReplyDao;
	}

	public Teacher getTeacherById(int id) {
		return teacherDao.getTeacher(id);
	}

	// 课程作业部分
	public boolean publishCourseHomework(CourseHomework homework) {
		int result = courseHomeworkDao.addCourseHomework(homework);
		// System.out.println("result:"+result);
		return result > 0;
	}

	public CourseHomework getHomeworkByTitle(String title) {
		return null;
	}

	public CourseHomework getHomeworkById(int id) {
		return courseHomeworkDao.getCourseHomeworkById(id);
	}

	public boolean updateCourseHomework(CourseHomework homework) {
		return courseHomeworkDao.updateCourseHomework(homework);
	}

	// 课程管理
	public Course getCourseById(int id) {
		// courseDao.getCourse(id);
		return courseDao.getCourse(id);
	}

	public List<Course> getCourseList(int teacherId) {
		// List<Course> list = courseDao.getCoursesByTeacher(teacherId);
		return courseDao.getCoursesByTeacher(teacherId);
	}

	public Course getCourseByCourseNo(String courseNo) {
		return null;
	}

	// 学生管理
	public List<StudentCourse> getStudentList() {
		List<StudentCourse> list = studentCourseDao.getStudentCourse();
		return list;
	}

	public List<StudentCourse> getStudentListByCourseId(int courseId) {
		List<StudentCourse> list = studentCourseDao
				.getStudentCourseByCourseId(courseId);
		return list;
	}

	public AttendTask getAttendTaskById(int id) {
		// attendTaskDao.getAttendTaskById(id);
		return attendTaskDao.getAttendTaskById(id);
	}

	public boolean publishAttendTask(AttendTask attendTask) {
		int taskId = attendTaskDao.addAttendTask(attendTask);
		String taskName = attendTask.getName();
		int courseId = attendTask.getCourseId();
		ArrayList<Student> students = (ArrayList<Student>) studentDao
				.getStudentsByCourseId(courseId);

		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			// 往数据库中插入数据
			AttendRecord record = new AttendRecord();
			record.setAttendTaskId(taskId);
			record.setStudentid(student.getId());
			attendRecordDao.addAttendRecord(record);
			// 进行通知
			String openid = student.getOpenId();

			NotifyUtil notifyUtil = new NotifyUtil();
			String courseName = courseDao.getCourse(courseId).getName();
			
//			String message = "【签到通知】\n课程【" + courseName + "】新添加了签到任务【"
//					+ taskName + "】\n请在" + TimeUtil.formatDate2(attendTask.getStartTime()) +"——"+TimeUtil.formatDate2(attendTask.getEndTime())+"及时进行签到。";
			StringBuffer message = new StringBuffer("【签到通知】\n课程【");
			message.append(courseName).append("】新添加了签到任务【")
					.append(taskName).append("】\n请在")
					.append(TimeUtil.formatDate2(attendTask.getStartTime())).append("~").append(TimeUtil.formatDate2(attendTask.getEndTime()))
					.append("及时进行签到。");
			try {
				String message1=new String(message.toString().getBytes(),"UTF-8");
				notifyUtil.pushText(WechatTypeEnum.STUDENT, openid, message1);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			System.out.println("发送微信通知：\n"+message);
		
		}

		return true;
	}

	public boolean updateAttendTask(AttendTask attendTask) {
		// attendTaskDao.updateAttendTask(attendTask);
		return attendTaskDao.updateAttendTask(attendTask);
	}

	// 签到记录
	public AttendRecord getAttendRecordByAttendTaskId(int id) {
		return null;
	}

	// 课程通知
	public boolean publisCourseNotify(CourseNotify courseNotify) {
		// courseNotifyDao.addCourseNotify(courseNotify);
		return courseNotifyDao.addCourseNotify(courseNotify) > 0;
	}

	public CourseNotify getCourseNotifyById(int id) {
		// courseNotifyDao.getCourseNotifyById(id);
		return courseNotifyDao.getCourseNotifyById(id);
	}

	public boolean updateCourseNotify(CourseNotify courseNotify) {
		return courseNotifyDao.updateCourseNotify(courseNotify);
	}

	public boolean checkBindByOpenId(String openid) {
		Teacher teacher = teacherDao.getTeacherByOpenid(openid);
		// 学生不存在，或者查出来的学号为空,则返回false,否则返回true
		if (teacher == null) {
			return false;
		}
		return true;
	}

	public View checkUser(String openid) {
		// 如果用户的openid非法，则跳转至错误显示页面
		if (openid.equals("illegal")) {
			View view = new View("error", "wechat", "info", "Code无效，请用公告平台访问。");
			view.addObject("info", "Code无效，请在公共平台访问。");
			return view;
		}
		// 用户没有绑定账户，则跳转至绑定页面
		if (!checkBindByOpenId(openid)) {
			View view = new View("student", "account", "bind", "绑定用户账户");
			view.addObject("openid", openid);
			return view;
		}

		// 用户已经登录，返回null
		return null;
	}

	// set session
	public void setSession(HttpSession session, String openid) {
		Teacher teacher = teacherDao.getTeacherByOpenid(openid);
		session.setAttribute("tid", teacher.getId());
		session.setAttribute("tname", teacher.getTrueName());
		session.setAttribute("openid", openid);
		session.setAttribute("avatar", teacher.getAvatar());
	}

	// 获取教师信息
	public Teacher getTeacherByTeacherNo(String teacherNo) {
		return teacherDao.getTeacherByTeacherNo(teacherNo);
	}

	public boolean updateTeacher(Teacher teacher) {
		return teacherDao.updateTeacher(teacher);
	}

	public ArrayList<com.welearn.model.AttendTask> getAttendTasks(int courseId) {
		ArrayList<com.welearn.model.AttendTask> tasks = new ArrayList<com.welearn.model.AttendTask>();

		ArrayList<AttendTask> list = (ArrayList<AttendTask>) attendTaskDao
				.getAttendTasksByCourseId(courseId);

		for (int i = 0; i < list.size(); i++) {
			AttendTask attendTask = list.get(i);
			com.welearn.model.AttendTask task = new com.welearn.model.AttendTask();
			task.setAttendId(attendTask.getId());
			task.setAttendNum(attendRecordDao.getCountByTastIdANDStatus(
					attendTask.getId(), InfoCode.ATTEND_PASS));
			task.setContent(attendTask.getName());
			task.setEndTime(TimeUtil.formatDate2(attendTask.getEndTime()));
			task.setStartTime(TimeUtil.formatDate2(attendTask.getStartTime()));
			task.setStuNum(studentCourseDao.getCountByCourseId(courseId));
			tasks.add(task);
		}

		return tasks;
	}

	public ArrayList<com.welearn.model.AttendRecord> getAttendRecords(
			int taskId, int courseId) {
		ArrayList<com.welearn.model.AttendRecord> list = new ArrayList<com.welearn.model.AttendRecord>();
		ArrayList<Student> students = (ArrayList<Student>) studentDao
				.getStudentsByCourseId(courseId);
		for (int i = 0; i < students.size(); i++) {
			com.welearn.model.AttendRecord record = new com.welearn.model.AttendRecord();
			// 添加签到记录
			AttendRecord record2 = attendRecordDao.getAttendRecord(students
					.get(i).getId(), taskId);
			record.setId(record2.getId());
			record.setOpenId(students.get(i).getOpenId());
			String url = "";
			if (record2.getPicUrl() == null || record2.getPicUrl().isEmpty())
				url = "public/imgs/attend-dafault.png";
			else {
				url = record2.getPicUrl();
			}

			record.setPicUrl(url);
			record.setState(record2.getStatus());
			record.setStuInfo(students.get(i).getStudentNo() + " "
					+ students.get(i).getTrueName());
			record.setTime(TimeUtil.formatDate2(record2.getLogTime()));
			record.setSimilarity(record2.getSimilarity());
			record.setTaskId(record2.getAttendTaskId());

			list.add(record);

		}

		return list;
	}

	public int[] getAttendStateNum(int taskId) {
		int[] num = new int[5];
		num[0] = (int) ((long) attendRecordDao.getCountByTastIdANDStatus(
				taskId, InfoCode.ATTEND_NOT));
		num[1] = (int) ((long) attendRecordDao.getCountByTastIdANDStatus(
				taskId, InfoCode.ATTEND_PREPARE));
		num[2] = (int) ((long) attendRecordDao.getCountByTastIdANDStatus(
				taskId, InfoCode.ATTEND_VERIFY));
		num[3] = (int) ((long) attendRecordDao.getCountByTastIdANDStatus(
				taskId, InfoCode.ATTEND_NOT_PASS));
		num[4] = (int) ((long) attendRecordDao.getCountByTastIdANDStatus(
				taskId, InfoCode.ATTEND_PASS));

		return num;
	}

	public void test() {
		AttendTask attendTask = new AttendTask();
		attendTask.setName("test!!");
		attendTask.setStartTime(new Date());
		attendTask.setCourseId(1);
		
		int result = attendTaskDao.addAttendTask(attendTask);
		System.out.println("==========================");
		System.out.println(result);
	}

	public boolean passAll(int taskId) {
		AttendTask task = attendTaskDao.getAttendTaskById(taskId);
		int courseId = task.getCourseId();

		ArrayList<Student> students = (ArrayList<Student>) studentDao
				.getStudentsByCourseId(courseId);
		for (int i = 0; i < students.size(); i++) {
			AttendRecord record2 = attendRecordDao.getAttendRecord(students
					.get(i).getId(), taskId);
			if (record2.getStatus() == InfoCode.ATTEND_VERIFY) {
				record2.setStatus(InfoCode.ATTEND_PASS);
				String openid = students.get(i).getOpenId();
				boolean isOk = attendRecordDao.updateAttendRecord(record2);

				if (isOk) {
					NotifyUtil notifyUtil = new NotifyUtil();
					String courseName = courseDao.getCourse(task.getCourseId())
							.getName();
//					String message = "【签到结果通知】\n课程【" + courseName + "】的【"
//							+ task.getName() + "】签到结果是【通过】";
					StringBuffer message = new StringBuffer("【签到结果通知】\n课程【");
					message.append(courseName).append("】的【")
					.append(task.getName()).append("】签到结果是【通过】");
					System.out.println("发送微信通知：\n"+message);
					try {
						String message1=new String(message.toString().getBytes(),"UTF-8");
						notifyUtil.pushText(WechatTypeEnum.STUDENT, openid, message1);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
			//		notifyUtil.pushText(WechatTypeEnum.STUDENT, openid, message.toString());
				}
			}

		}
		return true;
	}

	public boolean pass(int recordId, int passType) {
		AttendRecord record = attendRecordDao.getAttendRecordById(recordId);

		if (passType == 0) {
			record.setStatus(InfoCode.ATTEND_NOT_PASS);
		} else if (passType == 1) {
			record.setStatus(InfoCode.ATTEND_PASS);
		}

		String openid = studentDao.getStudent(record.getStudentid())
				.getOpenId();
		// isOk用于表示是否更新成功
		boolean isOk = attendRecordDao.updateAttendRecord(record);

		if (isOk) {
			NotifyUtil notifyUtil = new NotifyUtil();
			int taskId = record.getAttendTaskId();
			AttendTask task = attendTaskDao.getAttendTaskById(taskId);
			String courseName = courseDao.getCourse(task.getCourseId())
					.getName();
			String message = "【签到结果通知】\n课程【" + courseName + "】的【"
					+ task.getName() + "】签到结果是【";
			if (passType == 0) {
				message += "不通过";
			} else if (passType == 1) {
				message += "通过";
			}
			message += "】。";
			notifyUtil.pushText(WechatTypeEnum.STUDENT, openid, message);
		}

		return isOk;
	}

}
