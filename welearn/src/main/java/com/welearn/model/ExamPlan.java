package com.welearn.model;
/**
 * 这个类是用于考试安排的显示
 * @author SikentKim
 *
 */
public class ExamPlan {

	private String name;//课程名

	private String section; // 校区

	private String building;//教学楼

	private String classRoom; //教室

	private String examNo; // 准考证号

	private String time;//考试时间


	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public String getExamNo() {
		return examNo;
	}

	public void setExamNo(String examNo) {
		this.examNo = examNo;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
