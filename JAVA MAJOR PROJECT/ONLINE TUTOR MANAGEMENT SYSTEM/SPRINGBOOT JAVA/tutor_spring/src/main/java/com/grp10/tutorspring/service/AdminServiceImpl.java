package com.grp10.tutorspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.ContentTypeRepository;
import com.grp10.tutorspring.repository.MapStudentTrainingContentRepository;
import com.grp10.tutorspring.repository.RegistrationRequestRepository;
import com.grp10.tutorspring.repository.TrainingContentRepository;
import com.grp10.tutorspring.repository.TrainingInfoRepository;
import com.grp10.tutorspring.repository.UserRepository;

@Service
public class AdminServiceImpl implements AdminService{

	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RegistrationRequestRepository registrationRequestRepository;
	
	@Autowired
	TrainingContentRepository contentRepo;
	
	@Autowired
	TrainingInfoRepository trainingRepo;
	
	@Autowired
	MapStudentTrainingContentRepository mapRepo;
	public List<RegistrationRequest> getTutorRequests() {
		// TODO Auto-generated method stub
		return registrationRequestRepository.getTutorRequests();
	}

	public void deleteTutorRequest(int id) {
		// TODO Auto-generated method stub
		registrationRequestRepository.deleteTutorRequest(id);

	}

	public void acceptTutorRequest(int id) {
		// TODO Auto-generated method stub
		registrationRequestRepository.statusApproved(id);
		userRepo.enrollTutor(id);
		registrationRequestRepository.deleteTutorRequest(id);
	}
	
	
	public List<RegistrationRequest> getStudentRequests() {
		// TODO Auto-generated method stub
		return registrationRequestRepository.getStudentRequests();
	}

	public void deleteStudentRequest(int id) {
		// TODO Auto-generated method stub
		registrationRequestRepository.deleteStudentRequest(id);
	}

	public void acceptStudentRequest(int id) {
		// TODO Auto-generated method stub
		
		registrationRequestRepository.statusApproved(id);
		userRepo.enrollStudent(id);
		registrationRequestRepository.deleteStudentRequest(id);
	}


public List<UserInfo> getAllStudentsByTutor(int id) {
		
		List<UserInfo> list = userRepo.getAllStudentsByTutor(id);
		
		return list;
	}


public List<TrainingContent> getAllContents() {
	List<TrainingContent> contentList=contentRepo.findAll();
	return contentList;
}


public List<TrainingInfo> getAllTrainings() {
	List<TrainingInfo> trainingList=trainingRepo.findAll();
	return trainingList;
}


public List<UserInfo> getAllTutors() {
	List<UserInfo> userList=userRepo.findAll();
	return userList;
}


public List<MapStudentTrainingContent> getAllMappingsbyTutorId(int tutorId) {

	List<MapStudentTrainingContent> mapList=mapRepo.findBytutorId(tutorId);
	return mapList;
}


public List<TrainingInfo> getAllTrainings(List<Integer> trainingids) {

	List<TrainingInfo> trainingList=trainingRepo.findBytrainingInfoIdIn(trainingids);
	return trainingList;
}


public List<TrainingContent> getAllContents(List<Integer> contentIds) {
	List<TrainingContent> contentList=contentRepo.findBytrainingContentIdIn(contentIds);
	return contentList;
}


public List<UserInfo> getAllStudents(List<Integer> studentIds) {
	List<UserInfo> userList=userRepo.findByuserIdIn(studentIds);
	return userList;
}


public List<MapStudentTrainingContent> getAllMappings() {
	
	List<MapStudentTrainingContent> mappingList=mapRepo.findAll();
	return mappingList;
}


}
