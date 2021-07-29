package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Feedback;
import com.cybage.repository.FeedbackRepositoy;

@Service
public class FeedbackServiceImple implements FeedbackService {
    
	@Autowired
	private FeedbackRepositoy feedbackRepository;
	
	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
	public List<Feedback> getAllFeedback(){
		return feedbackRepository.findAll();
	}
	public Feedback getByAppointmentId(int appointMentId) {
		return feedbackRepository.findByAppointmentId(appointMentId);
	}
	public List<Feedback> getByDoctorId(int doctorId){
		return feedbackRepository.findByDoctorId(doctorId);
	}
	public List<Feedback> getByPatientId(int patientId){
		return feedbackRepository.findByPatientId(patientId);
	}
	
}
