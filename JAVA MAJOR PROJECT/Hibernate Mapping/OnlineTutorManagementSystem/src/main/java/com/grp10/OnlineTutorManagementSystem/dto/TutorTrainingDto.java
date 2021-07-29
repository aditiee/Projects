package com.grp10.OnlineTutorManagementSystem.dto;

public class TutorTrainingDto {
	
	public String firstName;
	public String lastName;
	public String trainingName;
	public String description;
	public String subjectName;
	
	public TutorTrainingDto() {
		super();
	}

	public TutorTrainingDto(String firstName, String lastName, String trainingName, String description, String subjectName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.trainingName = trainingName;
		this.description = description;
		this.subjectName=subjectName;
	}

	
	
	
	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TutorTrainingDto [firstName=" + firstName + ", lastName=" + lastName + ", trainingName=" + trainingName
				+ ", description=" + description + "]";
	}
	
	
	

}
