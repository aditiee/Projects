package com.grp10.tutorspring.service;

import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.UserInfo;

public interface UserService {

	public UserInfo login(String email, String password);
	

	public void addUser(RegistrationRequest user);

}
