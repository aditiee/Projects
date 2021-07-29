package com.grp10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class TrainingInfo {

	
	private int trainingInfoId;
	

	private String trainingName;
	
	
	private LocalDateTime createdOn;
	
	
	private LocalDateTime lastModifiedOn;

	
	
	private int subjectId;
	
	
	private int tutorId;


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
	
	
	
	
	
	
	
	
}
