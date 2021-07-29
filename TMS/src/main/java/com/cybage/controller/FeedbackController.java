package com.cybage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cybage.model.Feedback;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
public class FeedbackController {
	
	private RestTemplate restTemplate=new RestTemplate();
	
	Logger logger = LogManager.getLogger(FeedbackController.class);
	@PostMapping("/feedback/save")
	public void saveFeedback(@RequestBody Feedback feedback) {
		HttpEntity<Feedback> request = new HttpEntity<>(feedback);

		ResponseEntity<Feedback> response = 
		restTemplate.exchange("http://localhost:8090/feedback/save", HttpMethod.POST, request, Feedback.class);
	    Feedback ref=response.getBody();
	    logger.info(ref);
	
	}
	
	@GetMapping("/feedback/getAllFeedback")
	public List<Feedback> getAllFeedback() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<Feedback> request = new HttpEntity<>(null, headers);
		ObjectMapper mapper = new ObjectMapper();
		ResponseEntity<Feedback[]> response = 
		 restTemplate.exchange("http://localhost:8090/feedback/getAllFeedback", HttpMethod.GET, request, Feedback[].class);
	   Feedback[] feedbackArray=response.getBody();
	   return Arrays.stream(feedbackArray)
			   .map(f->mapper.convertValue(f, Feedback.class)).collect(Collectors.toList());
	}
}
