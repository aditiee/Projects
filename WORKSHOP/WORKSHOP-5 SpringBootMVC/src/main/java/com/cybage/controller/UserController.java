package com.cybage.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cybage.model.User;
import com.cybage.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userservice;
	@GetMapping("/user")
	public String users(Model m) {
	
		
		m.addAttribute("user",userservice.getUsers());
		return "user";
	}
	
	@GetMapping("/adduser")
	public String	createuser(Model m) {
		m.addAttribute("user",new User());
		return "adduser";
	}
	
	@PostMapping("/user")
	public String adduser(@Valid @ModelAttribute("emp") User u, BindingResult result,Model m) {
		if(result.hasErrors()) {
			System.out.println("Inside post error");
			return "adduser";
		}
		userservice.adduser(u);
		m.addAttribute("user",userservice.getUsers());
		return"user";
	}

	
	@GetMapping("/remove/{id}")
	public ModelAndView deleteuser(@PathVariable int id) {
		userservice.deleteuserById(id);
		return new ModelAndView("user","user",userservice.getUsers());
	}
	
	@GetMapping("/update/{id}")
	public String edituser(@PathVariable int id,Model m) {
		User user = userservice.finduserById(id);
		m.addAttribute("user",user);
		return "updateuser";
	}
	
	@PostMapping("/update")
	public String updateuser(@Valid @ModelAttribute("user") User user, BindingResult result, Model m) {
		if(result.hasErrors()) {			
			return "updateuser";
		}
		userservice.edituser(user);
		m.addAttribute("user",userservice.getUsers());
		return "user";
	}
	

}
