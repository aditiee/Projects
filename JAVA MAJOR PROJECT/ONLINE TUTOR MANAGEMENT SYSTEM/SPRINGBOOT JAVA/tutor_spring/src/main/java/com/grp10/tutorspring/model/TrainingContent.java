package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "training_content")
public class TrainingContent {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingContentId;
	
	@Column
	private String content;

	@Column
	private int trainingInfoId;
	

	@Column
	private int contentTypeId;
	
	
	@Column
	private int tutorId;
	
	@Column
	private int downloadCount;
	
	
	@Column
	private LocalDateTime uploadedOn;




	public int getDownloadCount() {
		return downloadCount;
	}




	public void setDownloadCount(int downloadCount) {
		this.downloadCount = downloadCount;
	}




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

	public TrainingContent( String content, int trainingInfoId,  int tutorId, 
			   int downloadCount, LocalDateTime uploadedOn, int contentTypeId ) { 
			  super(); 
			   
			  this.contentTypeId = contentTypeId; 
			  this.content = content; 
			  this.trainingInfoId = trainingInfoId; 
			  this.tutorId = tutorId; 
			  this.downloadCount = downloadCount; 
			  this.uploadedOn = uploadedOn; 
			 }




	public TrainingContent() {
		super();
	}


	public TrainingContent(int trainingContentId, String content, int trainingInfoId, int contentTypeId,
			   int downloadCount) {
			  super();
			  this.trainingContentId = trainingContentId;
			  this.content = content;
			  this.trainingInfoId = trainingInfoId;
			  this.contentTypeId = contentTypeId;
			  this.downloadCount = downloadCount;
			 }

	
	@Override
	public String toString() {
		return "TrainingContent [trainingContentId=" + trainingContentId + ", content=" + content + ", trainingInfoId="
				+ trainingInfoId + ", contentTypeId=" + contentTypeId + ", tutorId=" + tutorId + ", downloadCount="
				+ downloadCount + ", uploadedOn=" + uploadedOn + "]";
	}
	
	
}
