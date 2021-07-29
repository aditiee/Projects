package com.grp10.tutorspring.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;

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
	
	private SubjectInfo subjectInfo;
	private List<SubjectInfo> subjectList;
	
	private TrainingContent trainingContent;
	private List<TrainingContent> contentList;
	
	private MapStudentTrainingContent mapping;
	private List<MapStudentTrainingContent> mappingList;
	
	
	
	public MapStudentTrainingContent getMapping() {
		return mapping;
	}
	public void setMapping(MapStudentTrainingContent mapping) {
		this.mapping = mapping;
	}
	public List<MapStudentTrainingContent> getMappingList() {
		return mappingList;
	}
	public void setMappingList(List<MapStudentTrainingContent> mappingList) {
		this.mappingList = mappingList;
	}
	public TrainingContent getTrainingContent() {
		return trainingContent;
	}
	public void setTrainingContent(TrainingContent trainingContent) {
		this.trainingContent = trainingContent;
	}
	public List<TrainingContent> getContentList() {
		return contentList;
	}
	public void setContentList(List<TrainingContent> contentList) {
		this.contentList = contentList;
	}
	public SubjectInfo getSubjectInfo() {
		return subjectInfo;
	}
	public void setSubjectInfo(SubjectInfo subjectInfo) {
		this.subjectInfo = subjectInfo;
	}
	public List<SubjectInfo> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<SubjectInfo> subjectList) {
		this.subjectList = subjectList;
	}
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
