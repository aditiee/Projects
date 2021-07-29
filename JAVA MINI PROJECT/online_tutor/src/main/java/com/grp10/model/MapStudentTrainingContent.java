package com.grp10.model;

import java.time.LocalDateTime;



public class MapStudentTrainingContent {

	
	private int id;
	

	private int trainingContentId;
	

	private int studentId;
	
	
	private LocalDateTime downloadedOn;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
	
	
	
	
}
