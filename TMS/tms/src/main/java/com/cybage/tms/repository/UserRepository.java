package com.cybage.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cybage.tms.model.GenericUser;

public interface UserRepository extends JpaRepository<GenericUser, Integer> {
	GenericUser findByUserEmail(String email);
	
	@Query(value="select * from user u where u.status='PENDING' and u.role='TUTOR'",nativeQuery=true)
	List<GenericUser> tutorWithPending();	
	
	@Query(value="select * from user u where u.status='PENDING' and u.role='STUDENT'",nativeQuery=true)
	List<GenericUser> studentWithPending();
	
	GenericUser findByUserId(int id);
	
	@Query(value="select * from user u where u.status='APPROVED' and u.role='TUTOR'",nativeQuery=true)
	List<GenericUser> tutorWithApprove();
	
	@Query(value="select * from user u where u.status='APPROVED' and u.role='STUDENT'",nativeQuery=true)
	List<GenericUser> studentWithApprove();
	
//	@Query(value="select t.name,u.user_name from technology t join user u on t.tutor_id=u.user_id",nativeQuery=true)
//	List<GenericUser> findTechnology();
	
	
}
