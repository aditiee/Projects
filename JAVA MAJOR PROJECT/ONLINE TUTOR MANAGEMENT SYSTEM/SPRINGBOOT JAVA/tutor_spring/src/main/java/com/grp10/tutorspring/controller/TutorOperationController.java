package com.grp10.tutorspring.controller;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.response.TutorResponse;
import com.grp10.tutorspring.service.AdminService;
import com.grp10.tutorspring.service.TutorService;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class TutorOperationController {

	@Autowired
	TutorService tutorService;
     
	@Autowired
	AdminService adminService;
	
	@PostMapping(path = "/getStudentRequestsForTutor")
	public TutorResponse getStudentRequestsForTutor(@RequestBody UserInfo userinfo) {
		
		int tutorId=userinfo.getUserId();
		TutorResponse tutorResponse = new TutorResponse();
		List<TrainingRequest> requestList=tutorService.getAllRequests(tutorId);
		List<TrainingRequest> waitingRequest=requestList.stream().filter(x->x.getStatusId()==1).collect(Collectors.toList());
		
		if(!waitingRequest.isEmpty())
		{
		
		List<Integer> studentIds=waitingRequest.stream().
				map(TrainingRequest::getRaisedBy).collect(Collectors.toList());
		
		List<Integer> trainingInfoIds=waitingRequest.stream().
				map(TrainingRequest::getTrainingInfoId).collect(Collectors.toList());
		
		if((!studentIds.isEmpty())&&(!trainingInfoIds.isEmpty()))
		{
		List<UserInfo> userList=tutorService.getAllStudents(studentIds);

		List<TrainingInfo> trainingList=tutorService.getAllTrainings(trainingInfoIds);
		
		tutorResponse.setStatusCode(200);
		tutorResponse.setMessage("success");
		tutorResponse.setDescription("Requests Displayed");
		
		tutorResponse.setUserList(userList);
		tutorResponse.setTrainingList(trainingList);
		tutorResponse.setRequestList(waitingRequest);
		
		}
		else
		{
			throw new OnlineTutorException("No Student Request Found");
		}
	    
		
		
		}
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}// end of RequestList
	

	@PutMapping(path = "/approveStudentRequest")
	public TutorResponse approveStudentRequest(@RequestBody TrainingRequest trainingRequest) {
		TutorResponse tutorResponse=new TutorResponse();
		int trainingRequestId=trainingRequest.getTrainingRequestId();
		boolean isApproved=tutorService.approveRequest(trainingRequestId);
		if(isApproved)
		{
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Request Approved SuccessFully");
			tutorResponse.setTrainingRequest(trainingRequest);
		}
		else
		{
			throw new OnlineTutorException("Cant find request to approve");
		}
		return tutorResponse;
	
	}
	
	@DeleteMapping(path="deleteStudentRequest/{trainingRequestId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public TutorResponse deleteStudentRequest(@PathVariable int trainingRequestId)
	{
		TutorResponse tutorResponse=new TutorResponse();
		boolean isDeleted=tutorService.deleteRequest(trainingRequestId);
		if(isDeleted)
		{
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Request deleted SuccessFully");
		}
		else
		{
			throw new OnlineTutorException("cant findrequest to delete");
		}
		return tutorResponse;
	}
	
	
	@PostMapping(path = "/getAllTrainingsForTutor")
	public TutorResponse getAllTrainingsForTutor(@RequestBody UserInfo userinfo) {
		
		int tutorId=userinfo.getUserId();
		TutorResponse tutorResponse = new TutorResponse();
		List<TrainingInfo> trainingList=tutorService.getAllTrainings(tutorId);
		
		if(!trainingList.isEmpty())
		{
		
		List<Integer> subjectIds=trainingList.stream().
				map(TrainingInfo::getSubjectId).collect(Collectors.toList());
		
		if((!subjectIds.isEmpty()))
		{
		List<SubjectInfo> subjectList=tutorService.getAllSubjects(subjectIds);
		
		tutorResponse.setStatusCode(200);
		tutorResponse.setMessage("success");
		tutorResponse.setDescription("Requests Displayed");

		tutorResponse.setTrainingList(trainingList);
		tutorResponse.setSubjectList(subjectList);
		
		}
		else
		{
			throw new OnlineTutorException("No Student Request Found");
		}
	    
		
		
		}
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}// end of TrainingList
	
	@GetMapping(path = "/getContentForTraining/{trainingId}")
	public TutorResponse getContentForTraining(@PathVariable int trainingId) {
		
//		int trainingId=trainingInfo.getTrainingInfoId();
		TutorResponse tutorResponse=new TutorResponse();
		List<TrainingContent> contentList=tutorService.getAllcontents(trainingId);
		if(!contentList.isEmpty())
		{
			
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("success");
			tutorResponse.setDescription("Contents Fetched");
			
			tutorResponse.setContentList(contentList);


			
		}
		else
		{
			throw new OnlineTutorException("No Training Found");
		}
		
		return tutorResponse;
	}//end of getContents
	
	
	
	@PostMapping(path = "/getStudentsForTutor")
	public TutorResponse getStudentsForTutor(@RequestBody UserInfo userinfo) {
		
		int tutorId=userinfo.getUserId();
		TutorResponse tutorResponse = new TutorResponse();
		List<TrainingRequest> requestList=tutorService.getAllRequests(tutorId);
		List<TrainingRequest> approvedRequest=requestList.stream().filter(x->x.getStatusId()==2).collect(Collectors.toList());
		
		if(!approvedRequest.isEmpty())
		{
		
		List<Integer> studentIds=approvedRequest.stream().
				map(TrainingRequest::getRaisedBy).collect(Collectors.toList());
		
		
		if(!studentIds.isEmpty())
		{
		List<UserInfo> userList=tutorService.getAllStudents(studentIds);

	
		tutorResponse.setStatusCode(200);
		tutorResponse.setMessage("success");
		tutorResponse.setDescription("Requests Displayed");
		
		tutorResponse.setUserList(userList);
		
		}
		else
		{
			throw new OnlineTutorException("No Student Request Found");
		}
	    
		
		
		}
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}
	
	
	@DeleteMapping(path="deleteContent/{trainingContentId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public TutorResponse deleteContent(@PathVariable int trainingContentId)
	{
		TutorResponse tutorResponse=new TutorResponse();
		boolean isDeleted=tutorService.deleteContent(trainingContentId);
		if(isDeleted)
		{
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Content deleted SuccessFully");
		}
		else
		{
			throw new OnlineTutorException("cant find content to delete");
		}
		return tutorResponse;
	}
	
	
	
	@GetMapping(path = "/getAllSubject")
	public TutorResponse getAllSubject() {
		
		TutorResponse tutorResponse=new TutorResponse();
		List<SubjectInfo> subjectList=tutorService.getSubjects();
		if(!subjectList.isEmpty())
		{
			
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("success");
			tutorResponse.setDescription("Contents Fetched");
			
			tutorResponse.setSubjectList(subjectList);


			
		}
		else
		{
			throw new OnlineTutorException("No Training Found");
		}
		
		return tutorResponse;
	}//end of getContents
	
	

	@PostMapping(path = "/addTraining")
	public TutorResponse addTraining(@RequestBody TrainingInfo traininginfo) {
		
		
		int subjectId=traininginfo.getSubjectId();
		int tutorId=traininginfo.getTutorId();
		String trainingName=traininginfo.getTrainingName();
	TutorResponse tutorResponse = new TutorResponse();
	TrainingInfo training= new TrainingInfo();
	training.setTrainingName(traininginfo.getTrainingName());
	training.setSubjectId(subjectId);
	training.setTutorId(tutorId);
	LocalDateTime today = LocalDateTime.now();
	training.setCreatedOn(today);
	training.setLastModifiedOn(today);
	boolean isAdded=tutorService.newTraining(training);
       if(isAdded)
       {
    	   tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Training Added succesfully");
       }
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}

	
	@DeleteMapping(path="deleteTraining/{trainingInfoId}",produces= {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public TutorResponse deleteTraining(@PathVariable int trainingInfoId)
	{
		
		TutorResponse tutorResponse=new TutorResponse();
		boolean isDeleted=tutorService.deleteTraining(trainingInfoId);
		if(isDeleted)
		{
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Training deleted SuccessFully");
		}
		else
		{
			throw new OnlineTutorException("cant find content to delete");
		}
		return tutorResponse;
	}
	
	@PostMapping(path = "/addSubject")
	public TutorResponse addSubject(@RequestBody SubjectInfo subjectinfo) {
		
		
		int tutorId=subjectinfo.getCreatedBy();
	String subName=subjectinfo.getSubjectName();
	String desc=subjectinfo.getDescription();
	TutorResponse tutorResponse = new TutorResponse();
	SubjectInfo subject= new SubjectInfo();
	
	subject.setCreatedBy(tutorId);
	subject.setSubjectName(subName);
	subject.setDescription(desc);
	subject.setLastModifiedBy(tutorId);
	LocalDateTime today = LocalDateTime.now();
	subject.setCreatedOn(today);
	subject.setLastModifiedOn(today);
	boolean isAdded=tutorService.newSubject(subject);
       if(isAdded)
       {
    	   tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Subject Added succesfully");
       }
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}
	

	@PostMapping(path = "/downloadStatus")
	public TutorResponse getAlldownloadstatus(@RequestBody UserInfo userinfo){

    TutorResponse tutorResponse  = new  TutorResponse();
		 int tutorId=userinfo.getUserId();
		  List<MapStudentTrainingContent> mappings=adminService.getAllMappingsbyTutorId(tutorId);
		  
		  if(!mappings.isEmpty())
		  {
			  List<Integer> trainingids=mappings.stream().
						map(MapStudentTrainingContent::getTrainingInfoId).collect(Collectors.toList());
			  List<Integer> contentIds=mappings.stream().
					  map(MapStudentTrainingContent::getTrainingContentId).collect(Collectors.toList());
			  
			  List<Integer> studentIds=mappings.stream().
					  map(MapStudentTrainingContent::getStudentId).collect(Collectors.toList());
			  
			  if(!trainingids.isEmpty() && !contentIds.isEmpty() && !studentIds.isEmpty())
			  {
				List<TrainingInfo> trainingList=adminService.getAllTrainings(trainingids);
				List<TrainingContent> contentList=adminService.getAllContents(contentIds);
				
				List<UserInfo> userList=adminService.getAllStudents(studentIds);
				
				
				tutorResponse.setStatusCode(200);
				tutorResponse.setMessage("success");
				tutorResponse.setDescription("Requests Displayed");
				
				tutorResponse.setUserList(userList);
				tutorResponse.setTrainingList(trainingList);
				tutorResponse.setContentList(contentList);
				
				tutorResponse.setMappingList(mappings);
			  }
			  else
			  {
				  throw new OnlineTutorException("no files to display");
			  }
		  }
		  else
		  {
			  throw new OnlineTutorException("no files downloaded");
		  }
		
		
		
		return tutorResponse;	
	}
}
	

