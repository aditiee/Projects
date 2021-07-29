package com.grp10.tutorspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "map_student_training_content")
public class MapStudentTrainingContent {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentTrainingContentId;
	
	@Column
	private int trainingContentId;
	
	@Column
	private int studentId;
	
	@Column
	private LocalDateTime downloadedOn;
 
	@Column
	private int trainingInfoId;

	@Column
	private int tutorId;





	public MapStudentTrainingContent(int studentTrainingContentId, int trainingContentId, int studentId,
			LocalDateTime downloadedOn, int trainingInfoId, int tutorId) {
		super();
		this.studentTrainingContentId = studentTrainingContentId;
		this.trainingContentId = trainingContentId;
		this.studentId = studentId;
		this.downloadedOn = downloadedOn;
		this.trainingInfoId = trainingInfoId;
		this.tutorId = tutorId;
	}


	public int getStudentTrainingContentId() {
		return studentTrainingContentId;
	}


	public void setStudentTrainingContentId(int studentTrainingContentId) {
		this.studentTrainingContentId = studentTrainingContentId;
	}


	public int getTrainingInfoId() {
		return trainingInfoId;
	}


	public void setTrainingInfoId(int trainingInfoId) {
		this.trainingInfoId = trainingInfoId;
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


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public LocalDateTime getDownloadedOn() {
		return downloadedOn;
	}


	public void setDownloadedOn(LocalDateTime downloadedOn) {
		this.downloadedOn = downloadedOn;
	}




	public MapStudentTrainingContent() {
		super();
	}


	@Override
	public String toString() {
		return "MapStudentTrainingContent [studentTrainingContentId=" + studentTrainingContentId
				+ ", trainingContentId=" + trainingContentId + ", studentId=" + studentId + ", downloadedOn="
				+ downloadedOn + ", trainingInfoId=" + trainingInfoId + ", tutorId=" + tutorId + "]";
	}


	
	
	
	
	
}
