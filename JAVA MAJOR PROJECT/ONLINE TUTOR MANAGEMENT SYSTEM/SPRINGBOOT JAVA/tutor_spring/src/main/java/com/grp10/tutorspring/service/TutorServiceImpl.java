package com.grp10.tutorspring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.ContentType;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.ContentTypeRepository;
import com.grp10.tutorspring.repository.SubjectInfoRepository;
import com.grp10.tutorspring.repository.TrainingContentRepository;
import com.grp10.tutorspring.repository.TrainingInfoRepository;
import com.grp10.tutorspring.repository.TrainingRequestRepository;
import com.grp10.tutorspring.repository.UserRepository;

@Service
public class TutorServiceImpl implements TutorService{

	@Autowired
	TrainingRequestRepository requestRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	TrainingInfoRepository trainingRepo;
	
	@Autowired
	SubjectInfoRepository subjectRepo;
	
	@Autowired
	TrainingContentRepository contentRepo;
	
	@Autowired 
	 ContentTypeRepository contentTypeRepo;


	public List<TrainingRequest> getAllRequests(int tutorId) {
		List<TrainingRequest> trainingRequests=requestRepo.findBytutorId(tutorId);
		if(trainingRequests.isEmpty())
		{
			throw new OnlineTutorException("No Student Request Found");
		}
		return trainingRequests;
		
	}


	public List<UserInfo> getAllStudents(List<Integer> studentIds) {
		List<UserInfo> userList=userRepo.findByuserIdIn(studentIds);
		return userList;
	}

	
	public List<TrainingInfo> getAllTrainings(List<Integer> trainingInfoIds) {
		List<TrainingInfo> trainingList=trainingRepo.findBytrainingInfoIdIn(trainingInfoIds);
		return trainingList;
	}

	
	public boolean approveRequest(int requestId) {
		TrainingRequest request=requestRepo.findBytrainingRequestId(requestId);
		if(request!=null)
		{
			request.setStatusId(2);
			requestRepo.save(request);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Request Not Found");
		}
	}


	public boolean deleteRequest(int requestId) {
		
		TrainingRequest request=requestRepo.findBytrainingRequestId(requestId);
		if(request!=null)
		{
			request.setStatusId(3);
			requestRepo.save(request);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Request Not Found");
		}
	}

	
	public List<TrainingInfo> getAllTrainings(int tutorId) {
		
     List<TrainingInfo> trainingList=trainingRepo.findBytutorId(tutorId);		
		return trainingList;
	}

	
	public List<SubjectInfo> getAllSubjects(List<Integer> subjectIds) {
		List<SubjectInfo> subjectList=subjectRepo.findBysubjectIdIn(subjectIds);
		return subjectList;
	}


	public List<TrainingContent> getAllcontents(int trainingId) {
		List<TrainingContent> contentList=contentRepo.findBytrainingInfoId(trainingId);
		return contentList;
	}


	public boolean deleteContent(int trainingContentId) {
		TrainingContent content=contentRepo.findBytrainingContentId(trainingContentId);
		if(content!=null)
		{
			contentRepo.delete(content);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Request Not Found");
		}
	}


	public List<SubjectInfo> getSubjects() {
		List<SubjectInfo> subjects=subjectRepo.findAll();
		return subjects;
	}

	public boolean newTraining(TrainingInfo traininginfo) {
		if(traininginfo!=null) {
			trainingRepo.save(traininginfo);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Unable to Add Training");
		}
	}


	public boolean deleteTraining(int trainingInfoId) {
		TrainingInfo info=trainingRepo.findBytrainingInfoId(trainingInfoId);
		if(info!=null)
		{
			trainingRepo.delete(info);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Training Not Found");
		}
	}


	public boolean newSubject(SubjectInfo subject) {
		if(subject!=null) {
			subjectRepo.save(subject);
			return true;
		}
		else
		{
			throw new OnlineTutorException("Unable to Add Subject");
		}
	}

	
	
	
	 public ResponseEntity<TrainingContent> createContent(int trainingInfoId, int tutorId, 
	   ArrayList<MultipartFile> files) { 
	   System.out.println("in serv");
	  List<TrainingContent> trainingContents = new ArrayList<TrainingContent>(); 
	  for (MultipartFile file : files) { 
	    
	    String PATH = new FileSystemResource("").getFile().getAbsolutePath()+"/src/main/resources/Uploads/"; 
	    System.out.println("PAth " + PATH); 
	    Path DIRECTORY = Paths.get(PATH +  file.getOriginalFilename()); 
	    try { 
	     Files.write(DIRECTORY, file.getBytes()); 
	    } catch (IOException e) { 
	     // TODO Auto-generated catch block 
	     e.printStackTrace(); 
	    } 
	    LocalDateTime date =  LocalDateTime.of(LocalDate.now(), LocalTime.now()); 
	    String content = file.getOriginalFilename(); 
	    String contentType = file.getContentType().split("/")[1]; 
	    ContentType contentName = new ContentType(contentType, date, date); 
	    ContentType savedContent=contentTypeRepo.save(contentName); 
	    TrainingContent contents = new TrainingContent(content, trainingInfoId, tutorId, 0, date,savedContent.getContentTypeId()); 
	    trainingContents.add(contents); 
	     
	    System.out.println("training Contents"+trainingContents);
	    
	  } 
	  contentRepo.saveAll(trainingContents); 
	  return new ResponseEntity<TrainingContent>(HttpStatus.OK); 
	 }

}
