package com.grp10.tutorspring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp10.tutorspring.model.Feedback;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.UserRepository;
import com.grp10.tutorspring.response.FeedbackResponse;
@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	UserRepository userRepository;
	
	
	public FeedbackResponse getAllFeedbackByTutor(List<Feedback> feedbacks, int id) {
		// TODO Auto-generated method stub
		UserInfo tutor = userRepository.getTutor(id);
		FeedbackResponse feedbackResponse= new FeedbackResponse();
		feedbackResponse.setUserinfo(tutor);
		feedbackResponse.setFeedbacks(feedbacks);
		return feedbackResponse;
	}

	

}
