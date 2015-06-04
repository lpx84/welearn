package com.welearn.model;

public class CetGrade {

	private Semester semester;
	
	private String type;
	
	private String listening;
	
	private String comprehension;
	
	private String synthesis;

	public CetGrade() {
		super();
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getListening() {
		return listening;
	}

	public void setListening(String listening) {
		this.listening = listening;
	}

	public String getComprehension() {
		return comprehension;
	}

	public void setComprehension(String comprehension) {
		this.comprehension = comprehension;
	}

	public String getSynthesis() {
		return synthesis;
	}

	public void setSynthesis(String synthesis) {
		this.synthesis = synthesis;
	}
	
}
