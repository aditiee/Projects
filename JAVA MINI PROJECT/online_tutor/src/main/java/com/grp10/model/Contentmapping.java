package com.grp10.model;

import java.util.Date;
import java.util.List;

public class Contentmapping {
 
	private int userId;
	private int subjectId;
	private String subjectName;
	private String description;
	private String trainingName;
	private int createdBy;
	private Date createdOn;
	private int training_id;
	private List<String> content;
	private String contents;
	
	private int trainingContentId;
		public int getTrainingContentId() {
		return trainingContentId;
	}
	public void setTrainingContentId(int trainingContentId) {
		this.trainingContentId = trainingContentId;
	}
		public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
		public int getTraining_id() {
		return training_id;
	}
	public void setTraining_id(int training_id) {
		this.training_id = training_id;
	}
		
		
	public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
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
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
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
	

	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Contentmapping [userId=" + userId + ", subjectId=" + subjectId + ", subjectName=" + subjectName
				+ ", description=" + description + ", trainingName=" + trainingName + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", training_id=" + training_id + ", content=" + content + ", contents="
				+ contents + ", trainingContentId=" + trainingContentId + "]";
	}
	
	
}
