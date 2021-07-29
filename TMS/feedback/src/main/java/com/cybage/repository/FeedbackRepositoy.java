package com.cybage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.model.Feedback;
@Repository
public interface FeedbackRepositoy extends JpaRepository<Feedback,Integer> {
	
	 Feedback findByAppointmentId(int appointMentId);
	List<Feedback> findByDoctorId(int doctorId);
	List<Feedback> findByPatientId(int patientId);
	
}
