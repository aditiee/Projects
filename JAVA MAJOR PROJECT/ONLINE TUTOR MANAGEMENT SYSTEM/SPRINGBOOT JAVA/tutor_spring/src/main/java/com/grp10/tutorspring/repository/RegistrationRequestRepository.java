package com.grp10.tutorspring.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.RegistrationRequest;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Integer> 
{
	
	@Query(value="select * from registration_request where role_id = 3",nativeQuery=true)
	public List<RegistrationRequest> getStudentRequests();

	 @Modifying
	    @Transactional
	@Query(value="delete from registration_request where id =:id",nativeQuery=true)
	public void deleteStudentRequest(@Param("id") int id);

	 @Modifying
	 @Transactional
	 @Query(value="update registration_request set status_id=2 where id=:id",nativeQuery=true)
	 public void statusApproved(@Param("id") int id);

		@Query(value="select * from registration_request where role_id = 2",nativeQuery=true)
	public List<RegistrationRequest> getTutorRequests();

		@Modifying
	    @Transactional
	@Query(value="delete from registration_request where id =:id",nativeQuery=true)
		public void deleteTutorRequest(@Param("id") int id);
		
		
		

}
