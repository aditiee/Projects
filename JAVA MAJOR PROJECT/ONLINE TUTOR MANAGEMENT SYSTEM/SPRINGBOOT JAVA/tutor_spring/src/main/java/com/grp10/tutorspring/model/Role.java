package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column
	private String roleCode;
	
	
	public Role() {
		}


	public Role(int roleId, String roleCode, String description, int createdBy, LocalDateTime createdOn,
			int lastModifiedBy, int lastModifiedOn) {
		super();
		this.roleId = roleId;
		this.roleCode = roleCode;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
	}


	@Column
	private String description;
	
	@Column
	private int createdBy;
	
	@Column
	private LocalDateTime createdOn;
	@Column
	private int lastModifiedBy;
	
	@Column
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
