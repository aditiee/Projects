package com.cybage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.User;

import com.cybage.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	public UserRepository userRepo;
	public UserService() {
		
	}
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	public void adduser(User user) {
		userRepo.save(user);
	}
	public void deleteuser(User user) {
		userRepo.delete(user);
	}
	public void edituser(User user) {
		userRepo.save(user);
	}
	public User finduserById(int id) {
		return userRepo.getById(id);
	}
	
	public void deleteuserById(int id) {
		userRepo.deleteById(id);
	}
	

}
