package com.grp10.OnlineTutorManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp10.OnlineTutorManagementSystem.model.Role;
import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;
import com.grp10.OnlineTutorManagementSystem.repository.UserInfoRepository;




@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserInfoRepository userRepo;
	
	@Override
	public UserInfo findByUserId(UserInfo userId) {
		// TODO Auto-generated method stub
		return userRepo.findByUserId(userId);
	}

	@Override
	public UserInfo findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public UserInfo findByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public List<UserInfo> findByRole(Role role) {
		// TODO Auto-generated method stub
		return userRepo.findByRole(role);
	}

	@Override
	public List<UserInfo> findByStatus(Status status) {
		// TODO Auto-generated method stub
		return userRepo.findByStatus(status);
	}

	@Override
	public List<UserInfo> findByIsActive(boolean active) {
		// TODO Auto-generated method stub
		return userRepo.findByIsActive(active);
	}



	
}
