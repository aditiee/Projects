package com.grp10.OnlineTutorManagementSystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "user_info", indexes=@Index(columnList="email"))
public class UserInfo {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="middle_name")
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="email" , unique=true)
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="is_active",columnDefinition = "boolean default false")
	private boolean isActive;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="last_modified_by")
	private int lastModifiedBy;
	
	@Column(name="last_modified_on")
	private Date lastModifiedOn;

	@ManyToOne
	@JoinColumn(name="status_id",referencedColumnName="status_id" )
	private  Status status;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="role_id",referencedColumnName="role_id")
	private Role role;
	
	
//	@OneToMany(mappedBy="tutorId")
//	@JsonIgnore
//	private List<TrainingContent> trainingContents;
//	
//	@OneToMany(mappedBy="tutorId")
//	@JsonIgnore
//	private List<TrainingInfo> trainingInfo;
//	
//	@OneToMany(mappedBy="raisedBy")
//	@JsonIgnore
//	private List<TrainingRequest> trainingReq ;
	
	public UserInfo() {
	
	}
	
	

	public UserInfo(int userId) {
		super();
		this.userId = userId;
	}

	


	public UserInfo(int userId, Status status) {
		super();
		this.userId = userId;
		this.status = status;
	}



	public UserInfo(int userId, String firstName, String middleName, String lastName, String mobile, String email,
			String password, boolean isActive, int createdBy, Date createdOn, int lastModifiedBy, Date lastModifiedOn,
			Status status, Role role, List<TrainingContent> trainingContents, List<TrainingInfo> trainingInfo,
			List<TrainingRequest> trainingReq) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
		this.status = status;
		this.role = role;
//		this.trainingContents = trainingContents;
//		this.trainingInfo = trainingInfo;
//		this.trainingReq = trainingReq;
	}

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

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}



	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", mobile=" + mobile + ", email=" + email + ", password=" + password + ", isActive="
				+ isActive + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy="
				+ lastModifiedBy + ", lastModifiedOn=" + lastModifiedOn + ", status=" + status + ", role=" + role + "]";
	}


	
}
