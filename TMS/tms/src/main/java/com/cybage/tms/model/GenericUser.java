package com.cybage.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class GenericUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@NotNull(message = "User Name cannot be Null")
	@Column(name = "user_name", length = 50)
	private String userName;

	@NotNull(message = "User Email cannot be Null")
	@Email(message = "Invalid Email ID")
	@Column(name = "user_email", length = 60, unique = true)
	private String userEmail;

	@NotNull(message = "User Password cannot be Null")
	@Column(name = "user_password", length = 100)
	private String userPassword;
	
	@Column(name="Role",nullable=false,length = 10)
	@Enumerated(EnumType.STRING)
	@NotNull(message = "User Role cannot be Null")
	private Role userRole;
	
//	@Column(name="Gender",nullable=false,length = 10)
//	@Enumerated(EnumType.STRING)
//	@NotNull(message = "User Gender cannot be Null")
//	private Gender userGender;
	
	@Column(name="status",columnDefinition = "varchar(255) default 'PENDING'")
	@Enumerated(EnumType.STRING)
	private ApprovalStatus approvalStatus;
	
	
	
	//one tutor has many materials
	
	@OneToMany(mappedBy="belongsToTutor",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<TrainingMaterial> materials = new ArrayList();
	
	
	
	//one tutor can teach multiple technology
	@OneToMany(mappedBy="belongsToTutors",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Technology> technologies = new ArrayList();
	
	
	//
	@OneToMany(mappedBy="belongsToTutorsStud",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<StudentCourseDetail> studCourses = new ArrayList();
	
	
	
	public GenericUser() {
		// Default Constructor
	}


	

	


	public GenericUser(Integer userId, @NotNull(message = "User Name cannot be Null") String userName,
			@NotNull(message = "User Email cannot be Null") @Email(message = "Invalid Email ID") String userEmail,
			@NotNull(message = "User Password cannot be Null") String userPassword,
			@NotNull(message = "User Role cannot be Null") Role userRole, ApprovalStatus approvalStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		//this.userGender = userGender;
		this.approvalStatus = approvalStatus;
	}







	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


//	public Gender getUserGender() {
//		return userGender;
//	}
//
//
//	public void setUserGender(Gender userGender) {
//		this.userGender = userGender;
//	}


	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}


	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}


	public List<TrainingMaterial> getMaterials() {
		return materials;
	}


	public void setMaterials(List<TrainingMaterial> materials) {
		this.materials = materials;
	}


	public List<Technology> getTechnologies() {
		return technologies;
	}


	public void setTechnologies(List<Technology> technologies) {
		this.technologies = technologies;
	}


	public List<StudentCourseDetail> getStudCourses() {
		return studCourses;
	}


	public void setStudCourses(List<StudentCourseDetail> studCourses) {
		this.studCourses = studCourses;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", approvalStatus="
				+ approvalStatus + "]";
	}


	

	

}
