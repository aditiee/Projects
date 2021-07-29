package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "training_info")
public class TrainingInfo {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingInfoId;
	
	@Column
	private String trainingName;
	
	@Column
	private LocalDateTime createdOn;
	
	@Column
	private LocalDateTime lastModifiedOn;

	
	@Column
	private int subjectId;
	
	@Column
	private int tutorId;


	
	public TrainingInfo() {
		super();
	}

	public TrainingInfo(int trainingInfoId, String trainingName, int subjectId, int tutorId) {
		  super();
		  this.trainingInfoId = trainingInfoId;
		  this.trainingName = trainingName;
		  this.subjectId = subjectId;
		  this.tutorId = tutorId;
		 }

	public TrainingInfo(int trainingInfoId, String trainingName, LocalDateTime createdOn, LocalDateTime lastModifiedOn,
			int subjectId, int tutorId) {
		super();
		this.trainingInfoId = trainingInfoId;
		this.trainingName = trainingName;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
		this.subjectId = subjectId;
		this.tutorId = tutorId;
	}


	public int getTrainingInfoId() {
		return trainingInfoId;
	}


	public void setTrainingInfoId(int trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}


	public String getTrainingName() {
		return trainingName;
	}


	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}


	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


	public LocalDateTime getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}


	public int getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}


	public int getTutorId() {
		return tutorId;
	}


	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}


	@Override
	public String toString() {
		return "TrainingInfo [trainingInfoId=" + trainingInfoId + ", trainingName=" + trainingName + ", createdOn="
				+ createdOn + ", lastModifiedOn=" + lastModifiedOn + ", subjectId=" + subjectId + ", tutorId=" + tutorId
				+ "]";
	}
	
	
	
	
	
	
	
	
}
