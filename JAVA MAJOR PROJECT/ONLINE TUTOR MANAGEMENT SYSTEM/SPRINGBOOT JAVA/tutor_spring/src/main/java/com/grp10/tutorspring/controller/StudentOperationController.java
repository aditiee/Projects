package com.grp10.tutorspring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.response.TutorResponse;
import com.grp10.tutorspring.service.StudentService;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class StudentOperationController {

	@Autowired
	StudentService studentService;
	
	@GetMapping(path = "/getAllTutors")
	public TutorResponse getAllTutors() {
		
		TutorResponse tutorResponse=new TutorResponse();
		List<UserInfo> userList=studentService.getTutors();
		List<TrainingInfo> trainingList=studentService.getTrainings();
		List<SubjectInfo> subjectList=studentService.getSubjects();
		if(!subjectList.isEmpty() && !userList.isEmpty() && !trainingList.isEmpty())
		{
			
			tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("success");
			tutorResponse.setDescription("fetched");
			
			
			tutorResponse.setUserList(userList);
			tutorResponse.setTrainingList(trainingList);
			tutorResponse.setSubjectList(subjectList);


			
		}
		else
		{
			throw new OnlineTutorException("No data Found");
		}
		
		return tutorResponse;
	}//end of getContents

	@PostMapping(path = "/sendRequest")
	public TutorResponse addSubject(@RequestBody TrainingRequest trainingrequest) {
		
		
		int tutorId=trainingrequest.getTutorId();
	int trainingId=trainingrequest.getTrainingInfoId();
	int raisedBy=trainingrequest.getRaisedBy();
	TutorResponse tutorResponse = new TutorResponse();
	TrainingRequest request= new TrainingRequest();
	
	request.setTrainingInfoId(trainingId);
	request.setStatusId(1);
	request.setRaisedBy(raisedBy);
	request.setTutorId(tutorId);
	LocalDateTime today = LocalDateTime.now();
	request.setRaisedOn(today);
	request.setActionTakenOn(today);
	boolean isAdded=studentService.newRequest(request);
       if(isAdded)
       {
    	   tutorResponse.setStatusCode(200);
			tutorResponse.setMessage("Success");
			tutorResponse.setDescription("Request Sent succesfully");
       }
		else
		{
			throw new OnlineTutorException("No Requests Found");
		}
		return tutorResponse;
		
	}

	@PostMapping(path = "/getWaitingRequestsForStudent")
	public TutorResponse getWaitingRequestsForStudent(@RequestBody UserInfo userinfo) {
		
		int studentId=userinfo.getUserId();
		TutorResponse tutorResponse = new TutorResponse();
		List<TrainingRequest> requestList=studentService.getAllRequests(studentId);
		List<TrainingRequest> waitingRequest=requestList.stream()
				.filter(x->x.getStatusId()==1).collect(Collectors.toList());
		
		if(!waitingRequest.isEmpty())
		{
		
		List<Integer> tutorIds=waitingRequest.stream().
				map(TrainingRequest::getTutorId).collect(Collectors.toList());
		
		List<Integer> trainingInfoIds=waitingRequest.stream().
				map(TrainingRequest::getTrainingInfoId).collect(Collectors.toList());
		
		if((!tutorIds.isEmpty())&&(!trainingInfoIds.isEmpty()))
		{
		List<UserInfo> userList=studentService.getAllTutors(tutorIds);

		List<TrainingInfo> trainingList=studentService.getAllTrainings(trainingInfoIds);
		
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
		
	}//
	
	
	@PostMapping(path = "/getApprovedRequestsForStudent")
	public TutorResponse getApprovedRequestsForStudent(@RequestBody UserInfo userinfo) {
		
		int studentId=userinfo.getUserId();
		TutorResponse tutorResponse = new TutorResponse();
		List<TrainingRequest> requestList=studentService.getAllRequests(studentId);
		List<TrainingRequest> waitingRequest=requestList.stream()
				.filter(x->x.getStatusId()==2).collect(Collectors.toList());
		
		if(!waitingRequest.isEmpty())
		{
		
		List<Integer> tutorIds=waitingRequest.stream().
				map(TrainingRequest::getTutorId).collect(Collectors.toList());
		
		List<Integer> trainingInfoIds=waitingRequest.stream().
				map(TrainingRequest::getTrainingInfoId).collect(Collectors.toList());
		
		if((!tutorIds.isEmpty())&&(!trainingInfoIds.isEmpty()))
		{
		List<UserInfo> userList=studentService.getAllTutors(tutorIds);

		List<TrainingInfo> trainingList=studentService.getAllTrainings(trainingInfoIds);
		
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
		
	}//
	
	
	
}
