package com.welearn.model;
/**
 * 学生四六级成绩的类
 * @author SikentKim
 *
 */
public class CETGrade {
	private String name;
	private String school;
	private String type;
	private String examNo;
	private String time;
	private String listen;
	private String read;
	private String write;
	private String total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getExamNo() {
		return examNo;
	}

	public void setExamNo(String examNo) {
		this.examNo = examNo;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getListen() {
		return listen;
	}

	public void setListen(String listen) {
		this.listen = listen;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public String getWrite() {
		return write;
	}

	public void setWrite(String write) {
		this.write = write;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CETGrade [name=" + name + ", school=" + school + ", type="
				+ type + ", examNo=" + examNo + ", time=" + time + ", listen="
				+ listen + ", read=" + read + ", write=" + write + ", total="
				+ total + "]";
	}

}
