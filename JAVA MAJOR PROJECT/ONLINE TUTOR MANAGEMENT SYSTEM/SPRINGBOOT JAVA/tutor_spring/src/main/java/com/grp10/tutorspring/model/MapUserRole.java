package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "map_user_role")
public class MapUserRole {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column
	private int roleId;

	@Column
	private int adminId;
	
	@Column
	private LocalDateTime approvedOn;

	
	

	public MapUserRole() {
		super();
	}


	public MapUserRole( int userId, int roleId, int adminId, LocalDateTime approvedOn) {
		super();
		this.userId = userId;
		this.roleId = roleId;
		this.adminId = adminId;
		this.approvedOn = approvedOn;
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
