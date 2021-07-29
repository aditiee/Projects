package com.grp10.OnlineTutorManagementSystem.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TutorResponse {

	private int statusCode;
	private String message;
	private String description;
	
	private UserInfo userinfo;
	private List<UserInfo> userList;
	
	private TrainingInfo trainingInfo;
	private List<TrainingInfo> trainingList;
	
	private TrainingRequest trainingRequest;
	private List<TrainingRequest> requestList;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public List<UserInfo> getUserList() {
		return userList;
	}
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}
	public TrainingInfo getTrainingInfo() {
		return trainingInfo;
	}
	public void setTrainingInfo(TrainingInfo trainingInfo) {
		this.trainingInfo = trainingInfo;
	}
	public List<TrainingInfo> getTrainingList() {
		return trainingList;
	}
	public void setTrainingList(List<TrainingInfo> trainingList) {
		this.trainingList = trainingList;
	}
	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
	}
	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
	}
	public List<TrainingRequest> getRequestList() {
		return requestList;
	}
	public void setRequestList(List<TrainingRequest> requestList) {
		this.requestList = requestList;
	}
	public TutorResponse() {
		
	}
	
	
	
	
	
}
