package com.grp10.tutorspring.model;

public class Dto {

	
	private String fileName;
	private int trainingInfoId;
	private int studentId;
	private int tutorId;
	private int trainingContentId;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getTrainingInfoId() {
		return trainingInfoId;
	}
	public void setTrainingInfoId(int trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	public Dto() {
		super();
	}
	public int getTrainingContentId() {
		return trainingContentId;
	}
	public void setTrainingContentId(int trainingContentId) {
		this.trainingContentId = trainingContentId;
	}
	public Dto(String fileName, int trainingInfoId, int studentId, int tutorId, int trainingContentId) {
		super();
		this.fileName = fileName;
		this.trainingInfoId = trainingInfoId;
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.trainingContentId = trainingContentId;
	}
	@Override
	public String toString() {
		return "Dto [fileName=" + fileName + ", trainingInfoId=" + trainingInfoId + ", studentId=" + studentId
				+ ", tutorId=" + tutorId + ", trainingContentId=" + trainingContentId + "]";
	}
	
	
}
