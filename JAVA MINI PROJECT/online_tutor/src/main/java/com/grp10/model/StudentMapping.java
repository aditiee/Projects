package com.grp10.model;

import java.util.Date;

public class StudentMapping {

	private String firstName;
	private String lastName;
	private int id;
	private String trainingName;
	private Date createdOn;
	private String description;
	private int training_info_id;
	private String subjectName;
	private String contentName;
	private Date uploadedOn;
	private int tutorId;
	private int studentId;
	private int trainingContentId;
	
	
	

	public StudentMapping(String firstName, String lastName, String trainingName, String contentName, Date uploadedOn,
			int trainingContentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.contentName = contentName;
		this.uploadedOn = uploadedOn;
		this.trainingContentId = trainingContentId;
	}

	public StudentMapping(String firstName, String lastName, String trainingName, int training_info_id,
			String contentName, Date uploadedOn, int trainingContentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.training_info_id = training_info_id;
		this.contentName = contentName;
		this.uploadedOn = uploadedOn;
		this.trainingContentId = trainingContentId;
	}

	public StudentMapping(String firstName, String lastName, String trainingName, int training_info_id,
			String contentName, Date uploadedOn, int tutorId, int studentId, int trainingContentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.training_info_id = training_info_id;
		this.contentName = contentName;
		this.uploadedOn = uploadedOn;
		this.tutorId = tutorId;
		this.studentId = studentId;
		this.trainingContentId = trainingContentId;
	}

	public StudentMapping(String firstName, String lastName, String trainingName, int training_info_id,
			String contentName, Date uploadedOn, int tutorId, int studentId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.training_info_id = training_info_id;
		this.contentName = contentName;
		this.uploadedOn = uploadedOn;
		this.tutorId = tutorId;
		this.studentId = studentId;
	}

	public StudentMapping(String firstName, String lastName, String trainingName,
			int training_info_id, String contentName, Date uploadedOn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.training_info_id = training_info_id;
		this.contentName = contentName;
		this.uploadedOn = uploadedOn;
	}

	public StudentMapping(String firstName, String lastName, int id, String trainingName, Date createdOn,
			String description, int training_info_id, String subjectName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.trainingName = trainingName;
		this.createdOn = createdOn;
		this.description = description;
		this.training_info_id = training_info_id;
		this.subjectName = subjectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentMapping() {
		super();
	}

	public StudentMapping(int training_info_id) {
		super();
		this.training_info_id = training_info_id;
	}

	public int getTraining_info_id() {
		return training_info_id;
	}

	public void setTraining_info_id(int training_info_id) {
		this.training_info_id = training_info_id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public StudentMapping(String trainingName) {
		super();
		this.trainingName = trainingName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTrainingName() {
		return trainingName;
	}

	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "StudentMapping [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", trainingName="
				+ trainingName + ", createdOn=" + createdOn + ", description=" + description + ", training_info_id="
				+ training_info_id + ", subjectName=" + subjectName + ", contentName=" + contentName + ", uploadedOn="
				+ uploadedOn + ", tutorId=" + tutorId + ", studentId=" + studentId + "]";
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public Date getUploadedOn() {
		return uploadedOn;
	}

	public void setUploadedOn(Date uploadedOn) {
		this.uploadedOn = uploadedOn;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTutorId() {
		return tutorId;
	}

	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}

	public int getTrainingContentId() {
		return trainingContentId;
	}

	public void setTrainingContentId(int trainingContentId) {
		this.trainingContentId = trainingContentId;
	}

}
