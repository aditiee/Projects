package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.MapStudentTrainingContent;

@Repository
public interface MapStudentTrainingContentRepository extends JpaRepository<MapStudentTrainingContent, Integer>{

	List<MapStudentTrainingContent> findBytutorId(int tutorId);

	
}
