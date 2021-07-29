package com.cybage.service;

import java.util.List;

import com.cybage.model.Feedback;

public interface FeedbackService {
	void saveFeedback(Feedback feedback);
	List<Feedback> getAllFeedback();
	Feedback getByAppointmentId(int appointMentId);
	List<Feedback> getByDoctorId(int doctorId);
	List<Feedback> getByPatientId(int patientId);
}
