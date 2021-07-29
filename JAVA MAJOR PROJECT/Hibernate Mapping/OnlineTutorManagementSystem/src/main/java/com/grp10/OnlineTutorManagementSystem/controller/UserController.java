package com.grp10.OnlineTutorManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.grp10.OnlineTutorManagementSystem.exception.OnlineTutorException;
import com.grp10.OnlineTutorManagementSystem.model.TrainingInfo;
import com.grp10.OnlineTutorManagementSystem.model.UserInfo;
import com.grp10.OnlineTutorManagementSystem.response.LoginResponse;
import com.grp10.OnlineTutorManagementSystem.service.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService; 
	
	
	@GetMapping(path="/getUser/{userId}")
	public ResponseEntity<UserInfo> getUser(@PathVariable int userId)
	{
		UserInfo user = userService.findByUserId(new UserInfo(userId));
		return new ResponseEntity<>(user,HttpStatus.OK);
		
		
	}
	
	@GetMapping(path="/getUserByEmail/{email}")
	public ResponseEntity<UserInfo> getUserByEmail(@PathVariable String email)
	{
		UserInfo user = userService.findByEmail(email);
		return new ResponseEntity<>(user,HttpStatus.OK);
		
		
	}
	
	@PostMapping(path="/getUserByEmailAndPassword")
	public ResponseEntity<UserInfo> getUserByEmailAndPassword( String email , String password)
	{
		System.out.println(email + password);
		UserInfo user = userService.findByEmailAndPassword("admin@gmail.com", "qwerty123!");
		System.out.println("user " + user);
		return new ResponseEntity<UserInfo>(user,HttpStatus.OK);
		
		
	}
	
	
	


}