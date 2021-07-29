package com.grp10.OnlineTutorManagementSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name = "training_request")
public class TrainingRequest {

	@Id
	@Column(name="training_request_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingRequestId;
	
	@ManyToOne
	@JoinColumn(name="training_info_id")
	private TrainingInfo trainingInfoId;


	@ManyToOne
	@JoinColumn(name="raised_by")
	private UserInfo raisedBy;
	
	@Column(name="raised_on")
	private Date raisedOn;
	
//	@ManyToOne
//	@JoinColumn(name="tutor_id" , referencedColumnName="user_id")
//	private UserInfo tutorId;
	

	@Column(name="action_taken_on")
	private Date actionTakenOn;

	@ManyToOne
	@JoinColumn(name="status_id",referencedColumnName="status_id" )
	private Status statusId;

	public TrainingRequest() {
		super();
	}

	public TrainingRequest(int trainingRequestId, TrainingInfo trainingInfoId, UserInfo raisedBy, Date raisedOn,
			Date actionTakenOn, Status statusId) {
		super();
		this.trainingRequestId = trainingRequestId;
		this.trainingInfoId = trainingInfoId;
		this.raisedBy = raisedBy;
		this.raisedOn = raisedOn;
		this.actionTakenOn = actionTakenOn;
		this.statusId = statusId;
	}

	public int getTrainingRequestId() {
		return trainingRequestId;
	}

	public void setTrainingRequestId(int trainingRequestId) {
		this.trainingRequestId = trainingRequestId;
	}

	public TrainingInfo getTrainingInfoId() {
		return trainingInfoId;
	}

	public void setTrainingInfoId(TrainingInfo trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}

	public UserInfo getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(UserInfo raisedBy) {
		this.raisedBy = raisedBy;
	}

	public Date getRaisedOn() {
		return raisedOn;
	}

	public void setRaisedOn(Date raisedOn) {
		this.raisedOn = raisedOn;
	}

	public Date getActionTakenOn() {
		return actionTakenOn;
	}

	public void setActionTakenOn(Date actionTakenOn) {
		this.actionTakenOn = actionTakenOn;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "TrainingRequest [trainingRequestId=" + trainingRequestId + ", trainingInfoId=" + trainingInfoId
				+ ", raisedBy=" + raisedBy + ", raisedOn=" + raisedOn + ", actionTakenOn=" + actionTakenOn
				+ ", statusId=" + statusId + "]";
	}

	
		
}
