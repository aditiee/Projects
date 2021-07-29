package com.grp10.OnlineTutorManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.OnlineTutorManagementSystem.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer>{

	public UserInfo findByemail(String email);
	
	public List<UserInfo> findByuserIdIn(List<Integer> userId);
}
