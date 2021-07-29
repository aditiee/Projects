package com.grp10.tutorspring.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "subject_info")
public class SubjectInfo {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subjectId;
	

	@Column
	private String subjectName;
	
	@Column
	private String description;
	
	@Column
	private int createdBy;
	
	
	@Column
	private LocalDateTime createdOn;
	
	@Column
	private int lastModifiedBy;
	
	@Column
	private LocalDateTime lastModifiedOn;


	public int getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
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


	public LocalDateTime getCreatedOn() {
		return createdOn;
	}


	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}


	public int getLastModifiedBy() {
		return lastModifiedBy;
	}


	public void setLastModifiedBy(int lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}


	public LocalDateTime getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(LocalDateTime lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}




	public SubjectInfo() {
		super();
	}


	public String getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}


	public SubjectInfo(int subjectId, String subjectName, String description, int createdBy, LocalDateTime createdOn,
			int lastModifiedBy, LocalDateTime lastModifiedOn) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
	}

	
	public SubjectInfo(int subjectId, String subjectName, String description, int createdBy) {
		  super();
		  this.subjectId = subjectId;
		  this.subjectName = subjectName;
		  this.description = description;
		  this.createdBy = createdBy;
		 }

	@Override
	public String toString() {
		return "SubjectInfo [subjectId=" + subjectId + ", subjectName=" + subjectName + ", description=" + description
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}





	
	
	
	
	
}
