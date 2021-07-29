package com.grp10.OnlineTutorManagementSystem.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "training_info")
public class TrainingInfo {

	@Id
	@Column(name="training_info_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trainingInfoId;
	
	@Column(name="training_name")
	private String trainingName;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="last_modified_on")
	private Date lastModifiedOn;

	@ManyToOne
	@JoinColumn(name="subject_id" , referencedColumnName="subject_id")
	private SubjectInfo subjectId;
	
	@ManyToOne
	@JoinColumn(name="tutor_id" , referencedColumnName="user_id")
	private UserInfo tutorId;
	
	
//	@OneToMany(mappedBy="trainingInfoId")
//	@JsonIgnore
//	private List<TrainingContent> trainingContent;
//	
//	@OneToMany(mappedBy="trainingInfoId")
//	@JsonIgnore
//	private List<TrainingRequest> trainingReq;

	
	public TrainingInfo() {
		super();
	}


	public TrainingInfo(int trainingInfoId, String trainingName, Date createdOn, Date lastModifiedOn,
			SubjectInfo subjectId, UserInfo tutorId, List<TrainingContent> trainingContent,
			List<TrainingRequest> trainingReq) {
		super();
		this.trainingInfoId = trainingInfoId;
		this.trainingName = trainingName;
		this.createdOn = createdOn;
		this.lastModifiedOn = lastModifiedOn;
		this.subjectId = subjectId;
		this.tutorId = tutorId;
//		this.trainingContent = trainingContent;
//		this.trainingReq = trainingReq;
	}


	public int getTrainingInfoId() {
		return trainingInfoId;
	}


	public void setTrainingInfoId(int trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
	}


	public String getTrainingName() {
		return this.trainingName;
	}


	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}


	public SubjectInfo getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(SubjectInfo subjectId) {
		this.subjectId = subjectId;
	}


	public UserInfo getTutorId() {
		return tutorId;
	}


	public void setTutorId(UserInfo tutorId) {
		this.tutorId = tutorId;
	}


	@Override
	public String toString() {
		return "TrainingInfo [trainingInfoId=" + trainingInfoId + ", trainingName=" + trainingName + ", createdOn="
				+ createdOn + ", lastModifiedOn=" + lastModifiedOn + ", subjectId=" + subjectId + ", tutorId=" + tutorId
				+ "]";
	}


	
}
