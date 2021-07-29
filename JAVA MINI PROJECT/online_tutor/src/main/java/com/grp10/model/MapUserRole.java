package com.grp10.model;

import java.time.LocalDateTime;






public class MapUserRole {

	
	private int mapUserRoleId;
	
	
	private int userId;
	
	
	private int roleId;

	private int adminId;
	
	
	private LocalDateTime approvedOn;


	public int getMapUserRoleId() {
		return mapUserRoleId;
	}


	public void setMapUserRoleId(int mapUserRoleId) {
		this.mapUserRoleId = mapUserRoleId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getAdminId() {
		return adminId;
	}


	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}


	public LocalDateTime getApprovedOn() {
		return approvedOn;
	}


	public void setApprovedOn(LocalDateTime approvedOn) {
		this.approvedOn = approvedOn;
	}
	
	
	
	
}
