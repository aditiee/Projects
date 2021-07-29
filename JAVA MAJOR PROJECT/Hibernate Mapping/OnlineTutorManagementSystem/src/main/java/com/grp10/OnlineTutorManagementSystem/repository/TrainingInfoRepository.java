package com.grp10.OnlineTutorManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;


@Repository
public interface TrainingInfoRepository extends CrudRepository<TrainingInfo, Integer> {

	
	public List<TrainingInfo> findAll();
	public List<TrainingInfo> findByTutorId(UserInfo tutorId);
	public List<TrainingInfo> findByTrainingName(String trainingName);
	public List<TrainingInfo> findByTutorIdAndTrainingName(UserInfo tutorId, String trainingName);
	

}
