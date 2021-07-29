package com.grp10.tutorspring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "registration_request")
public class RegistrationRequest {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String firstName;
	@Column
	private String middleName;
	@Column
	private String lastName;
	@Column
	private String mobile;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private int statusId;
	@Column
	private int roleId;
	@Column
	private Date createdOn;
	@Column
	private int lastModifiedBy;
	@Column
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

	public RegistrationRequest(String firstName, String middleName, String lastName, String mobile, String email,
			   String password, int statusId, int roleId) {
			  super();
			  this.firstName = firstName;
			  this.middleName = middleName;
			  this.lastName = lastName;
			  this.mobile = mobile;
			  this.email = email;
			  this.password = password;
			  this.statusId = statusId;
			  this.roleId = roleId;
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
