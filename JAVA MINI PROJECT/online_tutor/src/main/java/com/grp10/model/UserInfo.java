package com.grp10.model;

import java.time.LocalDateTime;


public class UserInfo {

	private int userId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String email;
	private String password;
	private boolean isActive;
	private int createdBy;
	private LocalDateTime createdOn;
	private int lastModifiedBy;
	private LocalDateTime lastModifiedOn;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isActive() {
		return isActive;
	}

	public UserInfo() {
		super();
	}

	public UserInfo(int userId, String firstName, String mobile, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.mobile = mobile;
		this.email = email;
	}

	public UserInfo(String firstName, String mobile, String email) {
		super();
		this.firstName = firstName;
		this.mobile = mobile;
		this.email = email;
	}
	
	

	public UserInfo(int userId, String firstName, String middleName, String lastName, String mobile, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
