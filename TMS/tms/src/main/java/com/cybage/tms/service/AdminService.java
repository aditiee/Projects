package com.cybage.tms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.tms.model.ApprovalStatus;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.TrainingMaterial;
import com.cybage.tms.repository.TrainingMaterialRepository;
import com.cybage.tms.repository.UserRepository;

@Service
@Transactional
public class AdminService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TrainingMaterialRepository trainingmaterial;
	
	public List<GenericUser> findAllTutorPending(){
		return userRepo.tutorWithPending();
	}
	
	public List<GenericUser> findAllStudentPending(){
		return userRepo.studentWithPending();
	}
	
	public List<GenericUser> findAllTutorApprove(){
		return userRepo.tutorWithApprove();
	}
	
	public List<GenericUser> findAllStudentApprove(){
		return userRepo.studentWithApprove();
	}
	
	public GenericUser pendingRequestApproved(int id){
		GenericUser user=userRepo.findByUserId(id);
		ApprovalStatus approvalStatus=ApprovalStatus.APPROVED;
		user.setApprovalStatus(approvalStatus);
		return userRepo.save(user);
	}
	
	public void deleteUser(int id){
		 userRepo.deleteById(id);
	}

	public List<TrainingMaterial> tutorWithTech() {
		 
		return trainingmaterial.findAll();
	}
}
