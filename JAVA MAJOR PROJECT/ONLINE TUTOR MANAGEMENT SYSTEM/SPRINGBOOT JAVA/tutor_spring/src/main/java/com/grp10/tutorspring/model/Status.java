package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "status")
public class Status {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int status_id;
     
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


	
	public Status() {
	
	}


	public Status(int status_id, String name, String description, int createdBy, LocalDateTime createdOn,
			int lastModifiedBy, LocalDateTime lastModifiedOn) {
		super();
		this.status_id = status_id;
		this.name = name;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
	}


	public int getStatus_id() {
		return status_id;
	}


	public void setStatus_id(int status_id) {
		this.status_id = status_id;
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

	
	
	
	


}
