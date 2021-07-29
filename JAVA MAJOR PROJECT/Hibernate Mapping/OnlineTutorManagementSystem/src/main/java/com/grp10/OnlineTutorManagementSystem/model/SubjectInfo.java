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
@Table(name = "subject_info")
public class SubjectInfo {

	@Id
	@Column(name="subject_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	

	@Column(name="subject_name")
	private String subjectName;
	
	@Column(name="description")
	private String description;
	

	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="last_modified_by")
	private int lastModifiedBy;
	
	@Column(name="last_modified_on")
	private Date lastModifiedOn;

//	
//	@OneToMany(mappedBy="subjectId")
//	@JsonIgnore
//	private List<TrainingInfo> trainingInfo;


	public SubjectInfo() {
		super();
	}


	public SubjectInfo(int subjectId, String subjectName, String description, int createdBy, Date createdOn,
			int lastModifiedBy, Date lastModifiedOn, List<TrainingInfo> trainingInfo) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
//		this.trainingInfo = trainingInfo;
	}


	public int getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public Date getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}


	public int getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}


	@Override
	public String toString() {
		return "SubjectInfo [subjectId=" + subjectId + ", subjectName=" + subjectName + ", description=" + description
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}





	
}
