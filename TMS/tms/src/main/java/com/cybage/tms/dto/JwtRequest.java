package com.cybage.tms.dto;

import java.io.Serializable;

import com.cybage.tms.model.Role;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	private String userEmail;
	private String userPassword;
	private Role userRole;

	// need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String userEmail, String password, Role userRole) {

		this.userEmail = userEmail;
		this.userPassword = password;
		this.userRole=userRole;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
}