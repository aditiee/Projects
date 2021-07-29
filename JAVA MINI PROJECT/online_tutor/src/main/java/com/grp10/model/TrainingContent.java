package com.grp10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;




public class TrainingContent {

	
	private int trainingContentId;
	
	
	private String content;

	private int trainingInfoId;
	

	private int contentTypeId;
	
	
	
	private int tutorId;
	
	
	
	
	private LocalDateTime uploadedOn;




	public int getTrainingContentId() {
		return trainingContentId;
	}




	public void setTrainingContentId(int trainingContentId) {
		this.trainingContentId = trainingContentId;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public int getTrainingInfoId() {
		return trainingInfoId;
	}




	public void setTrainingInfoId(int trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}




	public int getContentTypeId() {
		return contentTypeId;
	}




	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}




	public int getTutorId() {
		return tutorId;
	}




	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}




	public LocalDateTime getUploadedOn() {
		return uploadedOn;
	}




	public void setUploadedOn(LocalDateTime uploadedOn) {
		this.uploadedOn = uploadedOn;
	}


	
	
}
