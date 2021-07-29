package com.cybage.tms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cybage.tms.dto.UserDTO;
import com.cybage.tms.model.ApprovalStatus;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.UserActivity;
import com.cybage.tms.repository.UserActivityRepository;
import com.cybage.tms.repository.UserRepository;
 


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Autowired
	private UserActivityRepository userActivityRepository;
	
	@Autowired
	private UserRepository usrRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		GenericUser user=usrRepo.findByUserEmail(email);
		ApprovalStatus approvalStatus = ApprovalStatus.APPROVED;
		
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
		else if(user.getApprovalStatus()!=approvalStatus){
			throw new UsernameNotFoundException("User not found with username: " + email);
		}
		//return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(),
				//new ArrayList<>());
		List<SimpleGrantedAuthority> roles= Arrays.asList(new SimpleGrantedAuthority("ADMIN"));
		return new User(user.getUserEmail(), user.getUserPassword(), roles);
	}

	public GenericUser save(UserDTO user){
		GenericUser newUser=new GenericUser();
		ApprovalStatus approvalStatus=ApprovalStatus.PENDING;
		newUser.setUserName(user.getUsername());
		newUser.setUserPassword(bcryptEncoder.encode(user.getPassword()));
//		newUser.setUserLocked(user.isUserLocked());
		newUser.setUserRole(user.getUserRole());
		newUser.setUserEmail(user.getUserEmail());
		newUser.setApprovalStatus(approvalStatus);
		return usrRepo.save(newUser);
	}

	public GenericUser getUser(String email) {
		System.out.println(email);
		return usrRepo.findByUserEmail(email);
	}

	public void userActivity(GenericUser user,String validate) {
		UserActivity useractivity=new UserActivity();
		if(validate.equals("login"))
		useractivity.setActivityContent("User LogedIn");
		else
			useractivity.setActivityContent("User LogedOut");
		useractivity.setActivityTime(LocalDateTime.now());
		useractivity.setUser(user);
		userActivityRepository.save(useractivity);
	}
	
	// checking based on role
		public boolean foundRoleEntry(GenericUser user) {
			if ("ADMIN".equals(user.getUserRole())) {
				return true;
			} else if ("TUTOR".equals(user.getUserRole())) {
				return true;
			}else if ("STUDENT".equals(user.getUserRole())) {
				return true;
			}
			return true;
		}

}
