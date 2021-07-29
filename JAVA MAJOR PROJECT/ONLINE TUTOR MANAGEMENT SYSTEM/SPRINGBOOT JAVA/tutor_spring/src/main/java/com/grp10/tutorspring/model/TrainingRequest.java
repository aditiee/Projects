package com.grp10.tutorspring.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "training_request")
public class TrainingRequest {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingRequestId;
	

	@Column
	private int trainingInfoId;
	

	@Column
	private int raisedBy;
	
	@Column
	private LocalDateTime raisedOn;
	
	@Column
	private int tutorId;

	@Column
	private LocalDateTime actionTakenOn;

	@Column
	private int statusId;
	
	
	public int getTrainingRequestId() {
		return trainingRequestId;
	}

	public void setTrainingRequestId(int trainingRequestId) {
		this.trainingRequestId = trainingRequestId;
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

	public LocalDateTime getRaisedOn() {
		return raisedOn;
	}

	public void setRaisedOn(LocalDateTime raisedOn) {
		this.raisedOn = raisedOn;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public LocalDateTime getActionTakenOn() {
		return actionTakenOn;
	}

	public void setActionTakenOn(LocalDateTime actionTakenOn) {
		this.actionTakenOn = actionTakenOn;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public TrainingRequest(int trainingInfoId, int raisedBy, int tutorId) {
		  super();
		  this.trainingInfoId = trainingInfoId;
		  this.raisedBy = raisedBy;
		  this.tutorId = tutorId;
		 }
	
	public TrainingRequest(int trainingRequestId, int trainingInfoId, int raisedBy, int statusId) {
		  super();
		  this.trainingRequestId = trainingRequestId;
		  this.trainingInfoId = trainingInfoId;
		  this.raisedBy = raisedBy;
		  this.statusId = statusId;
		 }
	public TrainingRequest(int trainingRequestId, int trainingInfoId, int raisedBy, LocalDateTime raisedOn, int tutorId, LocalDateTime actionTakenOn,
			int statusId) {
		super();
		this.trainingRequestId = trainingRequestId;
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
		return "TrainingRequest [trainingRequestId=" + trainingRequestId + ", trainingInfoId=" + trainingInfoId + ", raisedBy=" + raisedBy
				+ ", raisedOn=" + raisedOn + ", tutorId=" + tutorId + ", actionTakenOn=" + actionTakenOn + ", statusId="
				+ statusId + "]";
	}

	
	
	
		
}
