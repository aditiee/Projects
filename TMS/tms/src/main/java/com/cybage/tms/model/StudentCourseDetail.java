package com.cybage.tms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "studCourseDetails")
public class StudentCourseDetail {

	@Id
	@Column(name = "studCourseId", insertable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studCourseId;
	
	
	private String technologyName;

	@Column(name = "status",columnDefinition = "varchar(255) default 'PENDING'")
	@Enumerated(EnumType.STRING)
	private ApprovalStatus requestApproval;

	
	
	//
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private GenericUser belongsToUser;

	@ManyToOne
	@JoinColumn(name = "tutorsId", nullable = false)
	private GenericUser belongsToTutorsStud;

	// @ManyToMany(mappedBy = "studCourseDetails")
	// private List<Technology> technologies = new ArrayList<Technology>();

	@ManyToOne
	@JoinColumn(name = "technologyid", nullable = false)
	private Technology technologies;

	public StudentCourseDetail() {
		super();
	}

	public StudentCourseDetail(Integer studCourseId, String technologyName, ApprovalStatus requestApproval,
			GenericUser belongsToUser, GenericUser belongsToTutorsStud, Technology technologies) {
		super();
		this.studCourseId = studCourseId;
		this.technologyName = technologyName;
		this.requestApproval = requestApproval;
		this.belongsToUser = belongsToUser;
		this.belongsToTutorsStud = belongsToTutorsStud;
		this.technologies = technologies;
	}

	public Integer getStudCourseId() {
		return studCourseId;
	}

	public void setStudCourseId(Integer studCourseId) {
		this.studCourseId = studCourseId;
	}

	public String getTechnologyName() {
		return technologyName;
	}

	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}

	public ApprovalStatus getRequestApproval() {
		return requestApproval;
	}

	public void setRequestApproval(ApprovalStatus requestApproval) {
		this.requestApproval = requestApproval;
	}

	public GenericUser getBelongsToUser() {
		return belongsToUser;
	}

	public void setBelongsToUser(GenericUser belongsToUser) {
		this.belongsToUser = belongsToUser;
	}

	public GenericUser getBelongsToTutorsStud() {
		return belongsToTutorsStud;
	}

	public void setBelongsToTutorsStud(GenericUser belongsToTutorsStud) {
		this.belongsToTutorsStud = belongsToTutorsStud;
	}

	public Technology getTechnologies() {
		return technologies;
	}

	public void setTechnologies(Technology technologies) {
		this.technologies = technologies;
	}

	@Override
	public String toString() {
		return "StudentCourseDetail [studCourseId=" + studCourseId + ", technologyName=" + technologyName
				+ ", requestApproval=" + requestApproval + ", belongsToUser=" + belongsToUser + ", belongsToTutorsStud="
				+ belongsToTutorsStud + ", technologies=" + technologies + "]";
	}

	
	
}
