package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;

@Repository
public interface TrainingContentRepository extends JpaRepository<TrainingContent, Integer>{

	public List<TrainingContent> findBytrainingInfoId(int trainingId);
	
	public TrainingContent findBytrainingContentId(int id);
	
	public List<TrainingContent> findBytrainingContentIdIn(List<Integer> trainingInfoIds);

	public void save(MapStudentTrainingContent mapStudentTrainingContent);
}
