package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Feedback;
import com.cybage.service.FeedbackService;
//feedback controller here
@RestController
public class FeedbackController {
    @Autowired
	private FeedbackService  feedbackService;
	@PostMapping("/feedback/save")
	public void save(@RequestBody Feedback feedback) {
		feedbackService.saveFeedback(feedback);
	}
    @GetMapping("/feedback/getAllFeedback")
	public List<Feedback> getAllFeedback(){
		return feedbackService.getAllFeedback();
	}
    @GetMapping("/feedback/getAllFeedbackForPatient/{id}")
	public List<Feedback> getAllFeedbackByPatient(@PathVariable int id){
		return feedbackService.getByPatientId(id);
	}
    @GetMapping("/feedback/getAllFeedbackForDoctor/{id}")
   	public List<Feedback> getAllFeedbackForDoctor(@PathVariable int id){
   		return feedbackService.getByDoctorId(id);
   	}
    
    @GetMapping("/feedback/lowestRating")
   	public List<Feedback> lowestRating(){
   		return feedbackService.lowestRating();
   	}
	
}
