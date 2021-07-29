package com.cybage.model;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int empid;
	@Column
	String position;
	@Column
	String name;
	@Column
	String email;
	@Column
	String telephone;
	@Basic
	Date dateofbirth;
	@Column
	String qualification;
	@Column
	String experience;
	@Column
	String remarks;
	@Column
	String resumefile;
	public User() {
		
	}
	
	
	public String getResumefile() {
		return resumefile;
	}


	public void setResumefile(String resumefile) {
		this.resumefile = resumefile;
	}




	public User(int empid, String position, String name, String email, String telephone, Date dateofbirth,
			String qualification, String experience, String remarks, String resumefile) {
		super();
		this.empid = empid;
		this.position = position;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.dateofbirth = dateofbirth;
		this.qualification = qualification;
		this.experience = experience;
		this.remarks = remarks;
		this.resumefile = resumefile;
	}


	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	@Override
	public String toString() {
		return "User [empid=" + empid + ", position=" + position + ", name=" + name + ", email=" + email
				+ ", telephone=" + telephone + ", dateofbirth=" + dateofbirth + ", qualification=" + qualification
				+ ", experience=" + experience + ", remarks=" + remarks + ", resumefile=" + resumefile + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
