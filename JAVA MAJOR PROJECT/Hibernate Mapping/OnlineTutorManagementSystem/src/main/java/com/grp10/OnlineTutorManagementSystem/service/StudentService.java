package com.grp10.OnlineTutorManagementSystem.service;

import java.util.List;

import com.grp10.OnlineTutorManagementSystem.dto.TutorTrainingDto;
import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;

public interface StudentService {

	public List<TutorTrainingDto> getAllTutorTrainingInfo();
	public List<TrainingInfo> findByTutorId(UserInfo tutorId);
	public List<TrainingInfo> findByTrainingName(String trainingName);
	public List<TrainingInfo> findByTutorIdAndTrainingName(UserInfo tutorId, String trainingName);
	public List<TutorTrainingDto> findByRaisedByAndStatusId(UserInfo raisedBy , Status status);
}
