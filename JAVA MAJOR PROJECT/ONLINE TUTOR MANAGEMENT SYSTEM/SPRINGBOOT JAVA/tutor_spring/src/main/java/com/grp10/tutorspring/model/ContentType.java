package com.grp10.tutorspring.model;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "content_type")
public class ContentType {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contentTypeId;

	@Column
	private String name;
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

	
	
	
	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public ContentType(int contentTypeId, String name, String description, int createdBy, LocalDateTime createdOn,
			int lastModifiedBy, LocalDateTime lastModifiedOn) {
		super();
		this.contentTypeId = contentTypeId;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
	}

	public ContentType() {
		super();
	}

	@Override
	public String toString() {
		return "ContentType [contentTypeId=" + contentTypeId + ", name=" + name + ", description=" + description
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}

	public ContentType(String name, LocalDateTime createdOn, LocalDateTime lastModifiedOn) { 
		  super(); 
		  this.name = name; 
		  this.createdOn = createdOn; 
		  this.lastModifiedOn = lastModifiedOn; 
		 }
	
}
