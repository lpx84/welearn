package com.welearn.model;

/**
 * 用于表示学生没门课成绩
 * @author SilentKim
 *
 */
public class CourseGrade {

	private String semester;//学期
	private String type;//类型
	private String name;//课程名
	private String credit;//学分
	private String grade;//成绩

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "CourseGrade [semester=" + semester + ", type=" + type
				+ ", name=" + name + ", credit=" + credit + ", grade=" + grade
				+ "]";
	}
	

}
