package com.cybage.tms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tms.dto.EmailDTO;
import com.cybage.tms.dto.JwtRequest;
import com.cybage.tms.dto.JwtResponse;
import com.cybage.tms.dto.UserDTO;
import com.cybage.tms.jwtConfig.JwtUtil;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.Role;
import com.cybage.tms.service.CustomUserDetailsService;


@CrossOrigin
@RestController
public class UserController {

	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		System.out.println(authenticationRequest.getUserEmail() + authenticationRequest.getUserPassword());
		authenticate(authenticationRequest.getUserEmail(), authenticationRequest.getUserPassword());
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserEmail());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		GenericUser user=userDetailsService.getUser(authenticationRequest.getUserEmail());
		userDetailsService.userActivity(user,"login");
		boolean foundEntry = userDetailsService.foundRoleEntry(user);
		return ResponseEntity
				.ok(new JwtResponse(token,user.getUserId(),user.getUserName(),user.getUserRole(),foundEntry));
		
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello()
	{
		return "Hello";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public void logout(@RequestBody EmailDTO email) throws Exception {
		System.out.println("logedout");
		GenericUser user=userDetailsService.getUser(email.getEmail());
		userDetailsService.userActivity(user,"logout");
	}
}
