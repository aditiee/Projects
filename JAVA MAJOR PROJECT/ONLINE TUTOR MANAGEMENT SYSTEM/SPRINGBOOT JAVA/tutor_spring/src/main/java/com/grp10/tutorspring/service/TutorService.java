package com.grp10.tutorspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;

public interface TutorService {

	
	public List<TrainingRequest> getAllRequests(int tutorId);
	
	public List<UserInfo> getAllStudents(List<Integer> studentIds);

	public List<TrainingInfo> getAllTrainings(List<Integer> trainingInfoIds);
	
	public boolean approveRequest(int requestId);
	
	public boolean deleteRequest(int requestId);
	
	public List<TrainingInfo> getAllTrainings(int tutorId);

	public List<SubjectInfo> getAllSubjects(List<Integer> subjectIds);

	public List<TrainingContent> getAllcontents(int trainingId);

	public boolean deleteContent(int trainingContentId);

	public List<SubjectInfo> getSubjects();

	public boolean newTraining(TrainingInfo traininginfo);

	public boolean deleteTraining(int trainingInfoId);

	public boolean newSubject(SubjectInfo subject);
	
	public ResponseEntity<TrainingContent> createContent(int trainingInfoId , int tutorId , ArrayList<MultipartFile> files);
	
}
