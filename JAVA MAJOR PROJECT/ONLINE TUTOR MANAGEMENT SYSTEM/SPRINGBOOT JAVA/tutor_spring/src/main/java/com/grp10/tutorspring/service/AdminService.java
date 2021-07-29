package com.grp10.tutorspring.service;

import java.util.List;

import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.UserInfo;

public interface AdminService {

	List<RegistrationRequest> getTutorRequests();

	void deleteTutorRequest(int id);

	void acceptTutorRequest(int id);
	
	List<RegistrationRequest> getStudentRequests();

	void deleteStudentRequest(int id);

	void acceptStudentRequest(int id);

	List<UserInfo> getAllStudentsByTutor(int id);

	List<TrainingContent> getAllContents();

	List<TrainingInfo> getAllTrainings();

	List<UserInfo> getAllTutors();


	List<MapStudentTrainingContent> getAllMappingsbyTutorId(int tutorId);

	List<TrainingInfo> getAllTrainings(List<Integer> trainingids);

	List<TrainingContent> getAllContents(List<Integer> contentIds);

	List<UserInfo> getAllStudents(List<Integer> studentIds);

	List<MapStudentTrainingContent> getAllMappings();

}
