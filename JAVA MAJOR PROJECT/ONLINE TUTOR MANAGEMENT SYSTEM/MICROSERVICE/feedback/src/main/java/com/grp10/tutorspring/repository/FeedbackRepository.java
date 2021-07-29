package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.Feedback;


@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

	public List<Feedback> findByAdminId(int adminId); 

}
