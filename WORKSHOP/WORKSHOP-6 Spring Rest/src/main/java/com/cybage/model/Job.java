package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class Job {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public int jobId;
	
	@Column
	String jobName;
	
	@Column
	String description;
	
	public Job() {
		super();
	}
	
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Job(int jobId, String jobName, String description) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobName=" + jobName + ", description=" + description + "]";
	}
	
	
	
	

}
