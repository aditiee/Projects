package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.grp10.tutorspring.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer>{

	//tutor
	public UserInfo findByemail(String email);
	
	public List<UserInfo> findByuserIdIn(List<Integer> userId);

	public List<UserInfo> findByroleId(int id);
	

	//admin
	@Modifying
	@Transactional
	@Query(value="INSERT INTO user_info ( first_name, middle_name,last_name, mobile,email, password, created_on, last_modified_by, last_modified_on,created_by,is_active,role_id) SELECT first_name, middle_name,last_name, mobile,email, password, created_on, last_modified_by, last_modified_on,'1',b'1',role_id FROM registration_request where status_id=2 and id=:id",nativeQuery=true)
	public void enrollStudent(@Param("id") int id);

	@Modifying
	@Transactional
	@Query(value="INSERT INTO user_info ( first_name, middle_name,last_name, mobile,email, password, created_on, last_modified_by, last_modified_on,created_by,is_active,role_id) SELECT first_name, middle_name,last_name, mobile,email, password, created_on, last_modified_by, last_modified_on,'1',b'1',role_id FROM registration_request where status_id=2 and id=:id",nativeQuery=true)
	public void enrollTutor(@Param("id") int id);
	
	
	
	@Query(value="select * from user_info",nativeQuery=true)
	public List<UserInfo> getSome();


	@Query(value="select * from user_info where role_id=3",nativeQuery=true)
	public List<UserInfo> getAllStuents();
	
	@Query(value="select * from user_info where role_id=2",nativeQuery=true)
	public List<UserInfo> getAllTutors();

	@Query(value="select * from user_info where user_id IN(select student_id from map_student_tutor_training_info where tutor_id= :id)", nativeQuery=true)
	public List<UserInfo> getAllStudentsByTutor(@Param("id")int id);
}
