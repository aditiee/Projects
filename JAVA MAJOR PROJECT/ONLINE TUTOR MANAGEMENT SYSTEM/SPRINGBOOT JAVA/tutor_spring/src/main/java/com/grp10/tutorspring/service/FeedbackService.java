package com.grp10.tutorspring.service;

import java.util.List;

import com.grp10.tutorspring.model.Feedback;
import com.grp10.tutorspring.response.FeedbackResponse;

public interface FeedbackService {

	FeedbackResponse getAllFeedbackByTutor(List<Feedback> feedbacks, int id);
	
}
