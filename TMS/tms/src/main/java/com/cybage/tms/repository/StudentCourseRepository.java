package com.cybage.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tms.model.ApprovalStatus;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.StudentCourseDetail;

public interface StudentCourseRepository extends JpaRepository<StudentCourseDetail, Integer> {



	List<StudentCourseDetail> findByBelongsToUserAndRequestApproval(GenericUser user1, ApprovalStatus approved);

	
	
	

}
