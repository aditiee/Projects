package com.grp10.OnlineTutorManagementSystem.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.catalina.User;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "role")
public class Role {

	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(name="role_code")
	private String roleCode;
	

	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="last_modified_by")
	private int lastModifiedBy;
	
	@Column(name="last_modified_on")
	private Date lastModifiedOn;
	
	
//	@OneToMany(mappedBy="role", cascade = CascadeType.ALL)
//    @JsonIgnore
//	private List<UserInfo> userInfo1;
	

	
	public Role() {
		}



	public Role(int roleId, String roleCode, int createdBy, Date createdOn, int lastModifiedBy, Date lastModifiedOn,
			List<UserInfo> userInfo1) {
		super();
		this.roleId = roleId;
		this.roleCode = roleCode;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
//		this.userInfo1 = userInfo1;
	}



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



	public int getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
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



	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleCode=" + roleCode + ", createdBy=" + createdBy + ", createdOn="
				+ createdOn + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + "]";
	}



	


	
}
