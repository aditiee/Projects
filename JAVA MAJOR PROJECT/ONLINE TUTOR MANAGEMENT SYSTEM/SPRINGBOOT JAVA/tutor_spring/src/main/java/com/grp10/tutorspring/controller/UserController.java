package com.grp10.tutorspring.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.model.MapUserRole;
import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.response.LoginResponse;
import com.grp10.tutorspring.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService; 
	
	
	
	@PostMapping("/registeration_request")
	public void adduser(@RequestBody RegistrationRequest register)
	{
		Date date=new Date();
		register.setCreatedOn(date);
		register.setStatusId(1);
	 userService.addUser(register);
	}
	
	@PostMapping(path = "/userLogin", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public LoginResponse userLogin(@RequestBody UserInfo userinfo) {
		String email = userinfo.getEmail();
		String password = userinfo.getPassword();
		UserInfo userinfo1 = userService.login(email, password);
		 LoginResponse loginResponse=new LoginResponse();
		if(userinfo1!=null)
		{
		
       
        	loginResponse.setStatusCode(200);
        	loginResponse.setMessage("success");
        	loginResponse.setDescription(userinfo1.getEmail());
        	loginResponse.setRole(userinfo1.getRoleId());
        	loginResponse.setUserinfo(userinfo1);
        
		}
        else {
        	
    
        	throw new OnlineTutorException("Wrong EmailId or Password");
        }
		
        return loginResponse;
		

	}

}