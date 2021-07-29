package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.TrainingRequest;

@Repository
public interface TrainingRequestRepository extends JpaRepository<TrainingRequest,Integer>{

	List<TrainingRequest> findBytutorId(int tutorId);
	
	TrainingRequest findBytrainingRequestId(int id);

	List<TrainingRequest> findByraisedBy(int studentId);

	
}
