package com.grp10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Status {

	private int status_id;
     

	private String name;
	
	
	private String description;
	
	
	private int createdBy;
	

	private LocalDateTime createdOn;
	

	private int lastModifiedBy;
	

	private LocalDateTime lastModifiedOn;


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
