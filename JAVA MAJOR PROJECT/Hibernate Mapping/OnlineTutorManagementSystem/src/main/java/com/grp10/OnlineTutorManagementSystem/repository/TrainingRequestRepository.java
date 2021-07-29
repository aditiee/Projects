package com.grp10.OnlineTutorManagementSystem.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.TrainingRequest;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;

public interface TrainingRequestRepository  extends CrudRepository<TrainingRequest, Integer>{

	public List<TrainingRequest> findByRaisedByAndStatusId(UserInfo raisedBy , Status statusId);
	
}
