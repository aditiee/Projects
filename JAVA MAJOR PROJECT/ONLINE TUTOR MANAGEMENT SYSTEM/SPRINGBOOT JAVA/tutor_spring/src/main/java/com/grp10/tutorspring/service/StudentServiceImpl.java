package com.grp10.tutorspring.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.SubjectInfoRepository;
import com.grp10.tutorspring.repository.TrainingContentRepository;
import com.grp10.tutorspring.repository.TrainingInfoRepository;
import com.grp10.tutorspring.repository.TrainingRequestRepository;
import com.grp10.tutorspring.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TrainingInfoRepository trainingRepo;
	
	@Autowired
	SubjectInfoRepository subjectRepo;
	
	@Autowired
	TrainingRequestRepository requestRepo;
	
	@Autowired
	TrainingContentRepository trainingContentRepo;
	

	public List<UserInfo> getTutors() {
		List<UserInfo> userList=userRepo.findByroleId(2);
		if(!userList.isEmpty())
		{
			return userList;
		}
		else
		{
			throw new OnlineTutorException("No Tutors Found");
		}
		
	}
	
	public List<TrainingInfo> getTrainings() {
		List<TrainingInfo> trainingList=trainingRepo.findAll();
		if(!trainingList.isEmpty())
		{
			return trainingList;
		}
		else
		{
			throw new OnlineTutorException("No Trainings Found");
		}
	}

	public List<SubjectInfo> getSubjects() {
		List<SubjectInfo> subjectList=subjectRepo.findAll();
		if(!subjectList.isEmpty())
		{
			return subjectList;
		}
		else
		{
			throw new OnlineTutorException("No Subjects Found");
		}
	}

	public boolean newRequest(TrainingRequest request) {
		if(request!=null) {
			requestRepo.save(request);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Unable to Send Request");
		}

	}
	
	public List<TrainingRequest> getAllRequests(int studentId) {
		List<TrainingRequest> trainingRequests=requestRepo.findByraisedBy(studentId);
		if(trainingRequests.isEmpty())
		{
			throw new OnlineTutorException("No Student Request Found");
		}
		return trainingRequests;
	}

	public List<UserInfo> getAllTutors(List<Integer> studentIds) {
		List<UserInfo> userList=userRepo.findByuserIdIn(studentIds);
		return userList;
	}
	

	public List<TrainingInfo> getAllTrainings(List<Integer> trainingInfoIds) {
		List<TrainingInfo> trainingList=trainingRepo.findBytrainingInfoIdIn(trainingInfoIds);
		return trainingList;
	}
	
	
	  public void saveDownloadRequest(MapStudentTrainingContent mapStudentTrainingContent) {
	    LocalDateTime today = LocalDateTime.now();
	    mapStudentTrainingContent.setDownloadedOn(today);
	    trainingContentRepo.save(mapStudentTrainingContent);
	  }
	
	
	 public void downloadContent(String fileName,HttpServletResponse response) { 
	   
	  String PATH = new FileSystemResource("").getFile().getAbsolutePath()+"/src/main/resources/Uploads/"; 
	  System.out.println("PAth " + PATH); 
	   
	  File file =  new File(PATH + fileName); 
	  System.out.println("Filename " + file.getName()); 
	    response.setContentType("application/octet-stream"); 
	    response.setContentLength((int) file.length()); 
	    response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\""); 
	  try { 
	   InputStream input = new FileInputStream(file); 
	   ServletOutputStream out = response.getOutputStream(); 
	   byte[] bytes = new byte[1024]; 
	   int read=0; 
	   while((read=input.read(bytes))!= -1) 
	   { 
	    out.write(bytes, 0 ,read); 
	    
	   } 
	    
	   out.flush(); 
	   out.close(); 
	   input.close(); 
	  } catch (FileNotFoundException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } catch (IOException e) { 
	   // TODO Auto-generated catch block 
	   e.printStackTrace(); 
	  } 
	   
	   
	   
	   
	 }
}
