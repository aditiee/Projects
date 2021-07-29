package com.grp10.tutorspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.UserRepository;
import com.grp10.tutorspring.response.TutorResponse;
import com.grp10.tutorspring.service.AdminService;
import com.grp10.tutorspring.service.TutorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200",originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class AdminOperationController {

	@Autowired
	private AdminService adminService; 
	
	
	@Autowired
	private TutorService tutorService;
	
	@Autowired
	UserRepository userRepo;
//	@Autowired
//	private ReportService reportService;
	
	@GetMapping(path = "/studentRequests", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<RegistrationRequest> getStudentRequests() {
		List<RegistrationRequest> s1=adminService.getStudentRequests();
		return s1;
		
	}
	
	@DeleteMapping(path = "/studentRequests/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void deleteStudentRequest(@PathVariable("id") int id)
	{
		adminService.deleteStudentRequest(id);
	}
	
	@PutMapping(path = "/acceptStudentrequests/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void acceptStudentRequest(@PathVariable("id") int id)
	{
		adminService.acceptStudentRequest(id);
	}
	
	@GetMapping(path = "/tutorRequests", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<RegistrationRequest> getTutorRequests() {
		List<RegistrationRequest> s1=adminService.getTutorRequests();
		return s1;
		
	}
	
	@DeleteMapping(path = "/tutorRequests/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void deleteTutorRequest(@PathVariable("id") int id)
	{
		adminService.deleteTutorRequest(id);
	}
	
	@PutMapping(path = "/acceptTutorRequests/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void acceptTutorRequest(@PathVariable("id") int id)
	{
		adminService.acceptTutorRequest(id);
	}
	
//	@GetMapping("/report")
//	public ResponseEntity<String> getReport() {
//		return reportService.getReport();
//	}
	
	
	
	//hardik
	
	@GetMapping("/getAllStudents")
	public List<UserInfo> getAllStuents(){
	 return userRepo.getAllStuents();
	}
	
	@GetMapping("/getAllTutorsforAdmin")
	public List<UserInfo> getAllTutors(){
		 return userRepo.getAllTutors();
	}
	
	@DeleteMapping("/deleteUser/{user_id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer user_id){
		UserInfo userinfo = userRepo.findById(user_id)
				.orElseThrow(() -> new OnlineTutorException("User not exist with id :" + user_id));
		
		userRepo.delete(userinfo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	//prajakta
	
	@GetMapping(path = "/adminStudentsForTutor/{userId}")
	public TutorResponse getAllStudentsForTutors(@PathVariable int userId){

    TutorResponse tutorResponse  = new  TutorResponse();
		 
		
		List<TrainingRequest> requestList = tutorService.getAllRequests(userId) ;
		List<TrainingRequest> request=requestList.stream().filter(x->x.getStatusId()==2).collect(Collectors.toList());
		if(!request.isEmpty()){
			List<Integer> studentIds = request.stream(). 
				    map(TrainingRequest::getRaisedBy).collect(Collectors.toList());
			if(!studentIds.isEmpty()){
				List<UserInfo> userList = tutorService.getAllStudents(studentIds);
				tutorResponse.setStatusCode(200);
				tutorResponse.setMessage("success");
				tutorResponse.setUserList(userList);
				
			}
			else{
				throw new OnlineTutorException("No Students Found");
			}
		}
		else{
			throw new OnlineTutorException("No Data Found");
		}
		return tutorResponse;
	
	}

	
	@GetMapping(path = "/adminTrainingsForTutor/{userId}")
	public TutorResponse getAlltrainingsforTutors(@PathVariable int userId){

    TutorResponse tutorResponse  = new  TutorResponse();
		 
		
		List<TrainingInfo> trainingList = tutorService.getAllTrainings(userId) ;
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
			throw new OnlineTutorException("No Subjects and Trainings Found");
		}
	    
		
		
		}
		else
		{
			throw new OnlineTutorException("No trainingss Found");
		}
		return tutorResponse;	
	}
	
	
	
	@GetMapping(path = "/uploadStatus")
	public TutorResponse getAllUploadstatus(){

    TutorResponse tutorResponse  = new  TutorResponse();
		 
		
		List<TrainingContent> contentList = adminService.getAllContents();
		List<TrainingInfo> trainingList=adminService.getAllTrainings();
		List<UserInfo> userList=adminService.getAllTutors();
		if(!trainingList.isEmpty() && !contentList.isEmpty() && !userList.isEmpty())
		{
		
		tutorResponse.setStatusCode(200);
		tutorResponse.setMessage("success");
		tutorResponse.setDescription("Requests Displayed");

		tutorResponse.setTrainingList(trainingList);
		tutorResponse.setContentList(contentList);
		tutorResponse.setUserList(userList);
		}
		else
		{
			throw new OnlineTutorException("No Contents Found");
		}
	    
		
		
		
		return tutorResponse;	
	}
	
	

	@GetMapping(path = "/admindownloadStatus")
	public TutorResponse getAlldownloadstatus(){

    TutorResponse tutorResponse  = new  TutorResponse();
		  List<MapStudentTrainingContent> mappings=adminService.getAllMappings();
		  
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
