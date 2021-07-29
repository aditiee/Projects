package com.grp10.tutorspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.MapUserRoleRepository;
import com.grp10.tutorspring.repository.RegistrationRequestRepository;
import com.grp10.tutorspring.repository.UserRepository;
import com.grp10.tutorspring.validation.TutorValidation;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RegistrationRequestRepository registerRepo;
	UserInfo userlogin=null;
	@Autowired
	private TutorValidation validation;

	
	public UserInfo login(String email, String password) {
		if (validation.emailValidation(email)) {
			UserInfo userinfo=null;
			userinfo=userRepo.findByemail(email);
			if(userinfo.getPassword().equals(password))
			{
				this.userlogin=userinfo;
			}
			else
			{
				this.userlogin=null;
			}
	
	} else {
		throw new OnlineTutorException("Email must be in abc@gmail.com format");
	}
		return userlogin;
	}
	public void addUser(RegistrationRequest user) 
	{
		registerRepo.save(user);
	}
	
	

}
