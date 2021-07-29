package com.cybage.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cybage.tms.model.GenericUser;

public interface AdminRepository extends JpaRepository<GenericUser, Integer>{
	
//	@Query(value="SELECT u FROM User where u.status='PENDING'")
//	List<User> findAllUsers();

}
