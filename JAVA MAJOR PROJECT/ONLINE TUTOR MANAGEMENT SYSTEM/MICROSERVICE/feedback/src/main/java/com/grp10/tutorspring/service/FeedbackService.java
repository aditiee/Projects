package com.grp10.tutorspring.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.grp10.tutorspring.model.Feedback;
import com.grp10.tutorspring.repository.FeedbackRepository;
@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;
	
	

	
	public List<Feedback> getAllFeedback() {
		// TODO Auto-generated method stub
		return feedbackRepository.findAll();
	}

	public List<Feedback> getByAdminId(int id) {
		// TODO Auto-generated method stub
		return feedbackRepository.findByAdminId(id);
	}
	
	public void saveFeedback(Feedback feedback)
	{
		System.out.println("inside feedback method");
		LocalDateTime date =  LocalDateTime.of(LocalDate.now(), LocalTime.now());
       
       
        feedback.setCreated_on(date);
        System.out.println("Feedback "+ feedback);
     
		feedbackRepository.save(feedback);
     
	}



}
