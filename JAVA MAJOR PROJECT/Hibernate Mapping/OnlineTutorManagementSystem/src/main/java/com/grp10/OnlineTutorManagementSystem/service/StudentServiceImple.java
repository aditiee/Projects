package com.grp10.OnlineTutorManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp10.OnlineTutorManagementSystem.dto.TutorTrainingDto;
import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;
import com.grp10.OnlineTutorManagementSystem.repository.TrainingInfoRepository;
import com.grp10.OnlineTutorManagementSystem.repository.TrainingRequestRepository;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	TrainingInfoRepository trainingInfoRepo;
	
	@Autowired
	TrainingRequestRepository trainingReqRepo;
	
	@Override
	public List<TutorTrainingDto> getAllTutorTrainingInfo() {
		List<TrainingInfo> trainingInfoList = trainingInfoRepo.findAll();
		List<TutorTrainingDto> tutorTrainingList = new ArrayList<TutorTrainingDto>();
		for (TrainingInfo trainingInfo : trainingInfoList) {
			TutorTrainingDto tutor = new TutorTrainingDto(trainingInfo.getTutorId().getFirstName(),
					trainingInfo.getTutorId().getLastName(),
					trainingInfo.getTrainingName(), trainingInfo.getSubjectId().getDescription(),trainingInfo.getSubjectId().getSubjectName());
			tutorTrainingList.add(tutor);
		
		}
		return tutorTrainingList;
	}

	@Override
	public List<TrainingInfo> findByTutorId(UserInfo tutorId) {
		// TODO Auto-generated method stub
		return trainingInfoRepo.findByTutorId(tutorId);
	}

	@Override
	public List<TrainingInfo> findByTrainingName(String trainingName) {
		// TODO Auto-generated method stub
		return trainingInfoRepo.findByTrainingName(trainingName);
	}

	@Override
	public List<TrainingInfo> findByTutorIdAndTrainingName(UserInfo tutorId, String trainingName) {
		// TODO Auto-generated method stub
		return trainingInfoRepo.findByTutorIdAndTrainingName(tutorId, trainingName);
	}

	@Override
	public List<TutorTrainingDto> findByRaisedByAndStatusId(UserInfo raisedBy,Status statusId) {
		List<TrainingRequest> trainingRequestList = trainingReqRepo.findByRaisedByAndStatusId(raisedBy, statusId);
		List<TutorTrainingDto> studentTrainingList = new ArrayList<TutorTrainingDto>();
		for (TrainingRequest trainingInfo : trainingRequestList) {
			TutorTrainingDto tutor = new TutorTrainingDto(trainingInfo.getTrainingInfoId().getTutorId().getFirstName(),
					trainingInfo.getTrainingInfoId().getTutorId().getLastName(),
					trainingInfo.getTrainingInfoId().getTrainingName(), trainingInfo.getTrainingInfoId().getSubjectId().getDescription(),trainingInfo.getTrainingInfoId().getSubjectId().getSubjectName());
			studentTrainingList.add(tutor);
		
		}
	
		return studentTrainingList;
		
	}

}
