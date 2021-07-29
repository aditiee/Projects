package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.TrainingInfo;

@Repository
public interface TrainingInfoRepository extends JpaRepository<TrainingInfo,Integer> {
	
	public List<TrainingInfo> findBytrainingInfoIdIn(List<Integer> trainingInfoIds);
	public List<TrainingInfo> findBytutorId(int tutorId);
	public TrainingInfo findBytrainingInfoId(int trainingInfoId);

}
