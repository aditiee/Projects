package com.cybage.tms.dto;

import com.cybage.tms.model.Gender;
import com.cybage.tms.model.Role;

public class UserDTO {
	private String username;
	private String password;
	private String userEmail;
	private Role userRole;
	//private Gender userGender;
//	private boolean userLocked;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

//	public Gender getUserGender() {
//		return userGender;
//	}
//
//	public void setUserGender(Gender userGender) {
//		this.userGender = userGender;
//	}
//	
//	

//	public boolean isUserLocked() {
//		return userLocked;
//	}
//
//	public void setUserLocked(boolean userLocked) {
//		this.userLocked = userLocked;
//	}

}