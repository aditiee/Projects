package com.grp10.model;

import java.sql.Date;






public class MapStudentTutorTrainingInfo {

	private int id;
	private int trainingInfoId;
	private int studentId;
	private int tutorId;
	private int statusId;
	private Date approvedOn;
	private Date raisedOn;
	
	
	
	public MapStudentTutorTrainingInfo() {
		super();
	}


	public MapStudentTutorTrainingInfo(int id, int trainingInfoId, int studentId, int tutorId, int statusId,
			Date raisedOn) {
		super();
		this.id = id;
		this.trainingInfoId = trainingInfoId;
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.statusId = statusId;
		this.setRaisedOn(raisedOn);
	}




	public MapStudentTutorTrainingInfo(int id, int trainingInfoId, int studentId, int tutorId, int statusId,
			Date approvedOn, Date raisedOn) {
		super();
		this.id = id;
		this.trainingInfoId = trainingInfoId;
		this.studentId = studentId;
		this.tutorId = tutorId;
		this.statusId = statusId;
		this.approvedOn = approvedOn;
		this.raisedOn = raisedOn;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Date getApprovedOn() {
		return approvedOn;
	}


	public void setApprovedOn(Date approvedOn) {
		this.approvedOn = approvedOn;
	}


	@Override
	public String toString() {
		return "MapStudentTutorTrainingInfo [id=" + id + ", trainingInfoId=" + trainingInfoId + ", studentId="
				+ studentId + ", tutorId=" + tutorId + ", approvedOn=" + approvedOn + "]";
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public Date getRaisedOn() {
		return raisedOn;
	}


	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}


	
	
}
