package com.cybage.tms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.tms.dto.TutorDTO;
import com.cybage.tms.model.ApprovalStatus;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.StudentCourseDetail;
import com.cybage.tms.model.Technology;
import com.cybage.tms.model.TrainingMaterial;


import com.cybage.tms.repository.StudentCourseRepository;
import com.cybage.tms.repository.StudentRepository;
import com.cybage.tms.repository.TechnologyRepository;
import com.cybage.tms.repository.TrainingMaterialRepository;
import com.cybage.tms.repository.UserRepository;

@Service
@Transactional
public class StudentService {
	
	@Autowired
	 TechnologyRepository techrepository;
	
	@Autowired
	StudentRepository studentrepository;
	

	
	@Autowired
	 UserRepository userrepository;
	
	@Autowired
	StudentCourseRepository studentcourserepository;
	
	@Autowired
	 TrainingMaterialRepository materialRepo;
	
	
//get alltutor
	public List<TutorDTO> findAllTutor() {
		
		
		List<TutorDTO> ls= studentrepository.findAllTutor();
		System.out.println(ls);
		return ls;
	}

	
	//search function
	public List<TutorDTO> listAll(String searchtext) {
		if(searchtext!=null){
			return studentrepository.listAll(searchtext);
		}
			
		return studentrepository.findAllTutor() ;
	}
	
	//request for material

	public StudentCourseDetail requestToTutor(TutorDTO tutor,int id) {
		
		StudentCourseDetail s1=new StudentCourseDetail();
		
		GenericUser g1=userrepository.findByUserId(tutor.getUserId());
		GenericUser g2=userrepository.findByUserId(id);
		
		
	  s1.setRequestApproval(ApprovalStatus.PENDING);
		
	     
	    Technology t1=techrepository.findByTechnologyId(tutor.getTechnologyId());
	    s1.setTechnologies(t1);
		s1.setBelongsToTutorsStud(g1);
		s1.setTechnologyName(tutor.getTechnologyName());
		s1.setBelongsToUser(g2);
		
		return studentcourserepository.save(s1) ;
	}

	
	//get approved Listmaterial 
	public List<StudentCourseDetail> getMaterialList(Integer id) {
		GenericUser user1=new GenericUser();
		user1.setUserId(id);
		
		return  studentcourserepository.findByBelongsToUserAndRequestApproval(user1,ApprovalStatus.APPROVED);
	}

	//material
	
	public List<TrainingMaterial> getMaterial(Integer id){
		return materialRepo.findMaterial(id, ApprovalStatus.APPROVED);
		
	}
	
	
	
	

}
