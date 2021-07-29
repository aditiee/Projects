package com.grp10.tutorspring.controller;

import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grp10.tutorspring.model.Dto;
import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.service.StudentService;
import com.grp10.tutorspring.service.TutorService;

@RestController
@RequestMapping("/file")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class TrainingContentController {

	@Autowired
	TutorService tutorService;
	
	@Autowired
	StudentService studentService;

	@Autowired
	HttpServletResponse response;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadContent(@RequestParam("trainingInfoId") int trainingInfoId,
				@RequestPart("file")  ArrayList<MultipartFile> files, @RequestParam("tutorId") int tutorId 
				)
	{
		
		
		return tutorService.createContent(trainingInfoId, tutorId,  files);
		
	}
	
//	@GetMapping(value="/download/{filename}") 
//	 public void loadResourceFile(@PathVariable("filename") String fileName) 
//	 { 
//	   
//	  studentService.downloadContent(fileName, response); 
//	   
//	 }
	
	
	@PostMapping(value="/download") 
	 public void loadResourceFile(@RequestBody Dto dto) 
	 { 
		
	   String fileName=dto.getFileName();
	  studentService.downloadContent(fileName, response); 
	   MapStudentTrainingContent mapping=new MapStudentTrainingContent();
	   mapping.setTrainingContentId(dto.getTrainingContentId());
	   mapping.setStudentId(dto.getStudentId());
	   mapping.setTrainingInfoId(dto.getTrainingInfoId());
	   mapping.setTutorId(dto.getTutorId());
	   
	   save(mapping);
	 }

	@PostMapping(path = "/getDownloadRequestForStudent")
	  public void save(@RequestBody MapStudentTrainingContent mapStudentTrainingContent){
	    studentService.saveDownloadRequest(mapStudentTrainingContent);
	  }
}
