package com.grp10.tutorspring.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grp10.tutorspring.model.Feedback;
import com.grp10.tutorspring.service.FeedbackService;

@RestController
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping("/feedback/save")
	public ResponseEntity<Feedback> save(@RequestBody Feedback  feedback){
		feedbackService.saveFeedback(feedback);
		return new ResponseEntity<Feedback>(HttpStatus.OK);
	}
	
	@GetMapping("/feedback/getAllFeedback")
	public List<Feedback> getAllFeedback(){
		 List<Feedback> feedbackList=   feedbackService.getAllFeedback();
		 System.out.println(feedbackList);
		return feedbackList;
	}
	
	@GetMapping("/feedback/getAllFeedbackByTutor/{id}")
	public List<Feedback> getAllFeedbackByTutor(@PathVariable int id){
		return feedbackService.getByAdminId(id);
	}
	
	
	
	
	

}
