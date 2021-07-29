package com.grp10.OnlineTutorManagementSystem.model;



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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "status")
public class Status {

	@Id
	@Column(name="status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statusId;
     
	@Column(name="status_name")
	private String statusName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_on")
	private Date createdOn;
	
	@Column(name="last_modified_by")
	private int lastModifiedBy;
	
	@Column(name="last_modified_on")
	private Date lastModifiedOn;

//	@OneToMany(mappedBy="status")
//	@JsonIgnore
//	private List<UserInfo> userInfo1;
	
	
	public Status() {}

	

	public Status(int statusId) {
	super();
	this.statusId = statusId;
}



	public Status(int statusId, String statusName, String description, int createdBy, Date createdOn,
			int lastModifiedBy, Date lastModifiedOn, List<UserInfo> userInfo1) {
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.description = description;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedOn = lastModifiedOn;
//		this.userInfo1 = userInfo1;
	}


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
		return "Status [statusId=" + statusId + ", statusName=" + statusName + ", description=" + description
				+ ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedOn=" + lastModifiedOn + "]";
	}


	
	


}
