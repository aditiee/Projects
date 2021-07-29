package com.grp10.OnlineTutorManagementSystem.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "training_content")
public class TrainingContent {

	@Id
	@Column(name="training_content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingContentId;
	
	@Column(name="content")
	private String content;

	@ManyToOne
	@JoinColumn(name="training_info_id",referencedColumnName="training_info_id" )
	private TrainingInfo trainingInfoId;
	
	@ManyToOne
	@JoinColumn(name="content_type_id",referencedColumnName="content_type_id" )
	private ContentType contentTypeId;
	
	@ManyToOne
	@JoinColumn(name="tutor_id" , referencedColumnName="user_id")
	private UserInfo tutorId;
	
	@Column(name="uploaded_on")
	private Date uploadedOn;

	public TrainingContent() {
		super();
	}

	public TrainingContent(int trainingContentId, String content, TrainingInfo trainingInfoId,
			ContentType contentTypeId, UserInfo tutorId, Date uploadedOn) {
		super();
		this.trainingContentId = trainingContentId;
		this.content = content;
		this.trainingInfoId = trainingInfoId;
		this.contentTypeId = contentTypeId;
		this.tutorId = tutorId;
		this.uploadedOn = uploadedOn;
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

	public TrainingInfo getTrainingInfoId() {
		return trainingInfoId;
	}

	public void setTrainingInfoId(TrainingInfo trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}

	public ContentType getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(ContentType contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public UserInfo getTutorId() {
		return tutorId;
	}

	public void setTutorId(UserInfo tutorId) {
		this.tutorId = tutorId;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	@Override
	public String toString() {
		return "TrainingContent [trainingContentId=" + trainingContentId + ", content=" + content + ", trainingInfoId="
				+ trainingInfoId + ", contentTypeId=" + contentTypeId + ", tutorId=" + tutorId + ", uploadedOn="
				+ uploadedOn + "]";
	}
	
	
}
