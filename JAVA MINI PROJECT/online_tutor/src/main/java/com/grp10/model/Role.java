package com.grp10.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Role {

	private int roleId;
	
	private String roleCode;
	

	private String description;
	

	private int createdBy;
	

	private LocalDateTime createdOn;
	
	private int lastModifiedBy;
	

	private int lastModifiedOn;


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public String getRoleCode() {
		return roleCode;
	}


	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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


	public int getLastModifiedOn() {
		return lastModifiedOn;
	}


	public void setLastModifiedOn(int lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}


	
	
	
}
