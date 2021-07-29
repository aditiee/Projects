package com.grp10.OnlineTutorManagementSystem.response;

import com.fasterxml.jackson.annotation.JsonInclude;
//import com.grp10.OnlineTutorManagementSystem.model.MapUserRole;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {

	private int statusCode;
	private String message;
	private String description;
	private int role;			
	private UserInfo userinfo;
//	private MapUserRole mapUserRole;

public LoginResponse() {
		
	}
public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
public UserInfo getUserinfo() {
	return userinfo;
}
public void setUserinfo(UserInfo userinfo) {
	this.userinfo = userinfo;
}
//public MapUserRole getMapUserRole() {
//	return mapUserRole;
//}
//public void setMapUserRole(MapUserRole mapUserRole) {
//	this.mapUserRole = mapUserRole;
//}

	
}
