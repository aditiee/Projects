package com.grp10.OnlineTutorManagementSystem.service;


import java.util.List;

import com.grp10.OnlineTutorManagementSystem.model.Role;
import com.grp10.OnlineTutorManagementSystem.model.Status;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;

public interface UserService {

	public UserInfo findByUserId(UserInfo userId);
	public UserInfo findByEmail(String email);
	public UserInfo findByEmailAndPassword(String email,String password);
	public List<UserInfo> findByRole(Role role);
	public List<UserInfo> findByStatus(Status status);
	public List<UserInfo> findByIsActive(boolean active);
}
