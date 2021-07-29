package com.grp10.model;

import java.time.LocalDateTime;
import java.util.Date;




public class TrainingRequest {

	private int id;
	

	private int trainingInfoId;
	

	
	private int raisedBy;
	
	
	private Date raisedOn;
	

	private int tutorId;
	private Date actionTakenOn;

	private int statusId;

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

	public int getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(int raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Date getRaisedOn() {
		return raisedOn;
	}

	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public Date getActionTakenOn() {
		return actionTakenOn;
	}

	public void setActionTakenOn(Date actionTakenOn) {
		this.actionTakenOn = actionTakenOn;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public TrainingRequest(int id, int trainingInfoId, int raisedBy, Date raisedOn, int tutorId, Date actionTakenOn,
			int statusId) {
		super();
		this.id = id;
		this.trainingInfoId = trainingInfoId;
		this.raisedBy = raisedBy;
		this.raisedOn = raisedOn;
		this.tutorId = tutorId;
		this.actionTakenOn = actionTakenOn;
		this.statusId = statusId;
	}

	public TrainingRequest() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "TrainingRequest [id=" + id + ", trainingInfoId=" + trainingInfoId + ", raisedBy=" + raisedBy
				+ ", raisedOn=" + raisedOn + ", tutorId=" + tutorId + ", actionTakenOn=" + actionTakenOn + ", statusId="
				+ statusId + "]";
	}

	
	
	
		
}
