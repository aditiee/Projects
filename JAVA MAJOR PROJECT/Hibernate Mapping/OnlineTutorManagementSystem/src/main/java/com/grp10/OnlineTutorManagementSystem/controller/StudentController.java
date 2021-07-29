package com.grp10.OnlineTutorManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grp10.OnlineTutorManagementSystem.dto.TutorTrainingDto;
import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;
import com.grp10.OnlineTutorManagementSystem.service.StudentService;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping(path="/trainingInfoList")
	public ResponseEntity<List<TutorTrainingDto>> getAllTrainingInfo()
	{
		
		List<TutorTrainingDto> trainingInfoList = studentService.getAllTutorTrainingInfo();
		return new ResponseEntity<List<TutorTrainingDto>>(trainingInfoList,HttpStatus.OK);
		
	}
	
	@GetMapping(path="/studentTrainingList/{userId}/{statusId}")
	public ResponseEntity<List<TutorTrainingDto>> getStudentTrainingList(@PathVariable int userId ,@PathVariable int statusId)
	{
		List<TutorTrainingDto> studentTrainingList = studentService.findByRaisedByAndStatusId(new UserInfo(userId),new Status(2));
		return new ResponseEntity<List<TutorTrainingDto>>(studentTrainingList,HttpStatus.OK);
		
	}
	
	@GetMapping(path="/trainingInfoByTutor/{userId}")
	public ResponseEntity<List<TrainingInfo>> getTrainingInfoByTutor(@PathVariable int userId)
	{
		List<TrainingInfo> trainingInfoList = studentService.findByTutorId(new UserInfo(userId));
		return new ResponseEntity<List<TrainingInfo>>(trainingInfoList,HttpStatus.OK);
	}
	
	
	
	
//	
//	@GetMapping(path="/")
//	public ResponseEntity<List<TrainingRequest>> getTrainingReqList()
//	{
//		return null;
//		
//}


}
