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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "content_type")
public class ContentType {

	@Id
	@Column(name="content_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contentTypeId;

	@Column(name="name")
	private String name;
	
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

//	@OneToMany(mappedBy="contentTypeId")
//	@JsonIgnore
//	private List<TrainingContent> content1;
//

	public ContentType() {
		super();
	}


	public ContentType(int contentTypeId, String name, String description, int createdBy, Date createdOn,
			int lastModifiedBy, Date lastModifiedOn, List<TrainingContent> content1) {
		super();
		this.contentTypeId = contentTypeId;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
//		this.content1 = content1;
	}


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
		return "ContentType [contentTypeId=" + contentTypeId + ", name=" + name + ", description=" + description
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}





	
}
