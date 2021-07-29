package com.grp10.model;

import java.time.LocalDateTime;
import java.util.Date;




public class RegistrationRequest {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private int statusId;
	private int roleId;
	private Date createdOn;
	private int lastModifiedBy;
	private Date lastModifiedOn;

	
	public RegistrationRequest() {
		super();
	}


	public RegistrationRequest(int id, String firstName, String mobile, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.mobile = mobile;
		this.email = email;
	}


	public RegistrationRequest(String firstName, String mobile, String email) {
		super();
		this.firstName = firstName;
		this.mobile = mobile;
		this.email = email;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
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

	
}
