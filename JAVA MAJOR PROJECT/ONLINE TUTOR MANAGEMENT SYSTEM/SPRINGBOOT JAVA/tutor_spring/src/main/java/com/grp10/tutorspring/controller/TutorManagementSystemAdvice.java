package com.grp10.tutorspring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.grp10.tutorspring.exception.OnlineTutorException;
import com.grp10.tutorspring.response.LoginResponse;

@RestControllerAdvice
public class TutorManagementSystemAdvice {

	@ExceptionHandler(OnlineTutorException.class)
	public LoginResponse tutorManagementErrorResponse(OnlineTutorException e) {
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setStatusCode(400);
		loginResponse.setMessage("Failure");
		loginResponse.setDescription(e.getMessage());
		return loginResponse;
	}
}
