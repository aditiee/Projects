package com.cybage.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.TrainingMaterial;
import com.cybage.tms.service.AdminService;
import com.cybage.tms.service.StudentService;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	AdminService adminServ;
	
	@Autowired
	StudentService studentServ; 
	
	@RequestMapping(value = "/allTutorPending", method = RequestMethod.GET)
	public List<GenericUser> getTutorPending()
	{
		return adminServ.findAllTutorPending();
	}
	
	@RequestMapping(value = "/allStudentPending", method = RequestMethod.GET)
	public List<GenericUser> getStudentPending()
	{
		return adminServ.findAllStudentPending();
	}
	
	@RequestMapping(value="/approvePendingUser/{id}",method=RequestMethod.PUT)
	public GenericUser approvedPendingRequest(@PathVariable("id") int id){
		return adminServ.pendingRequestApproved(id);
	}
	
	@RequestMapping(value = "/allTutorApprove", method = RequestMethod.GET)
	public List<GenericUser> getTutorApprove()
	{
		return adminServ.findAllTutorApprove();
	}
	
	@RequestMapping(value="/deleteTutor/{id}",method=RequestMethod.DELETE)
	public List<GenericUser> deleteTutor(@PathVariable("id") int id){
		adminServ.deleteUser(id);
		return adminServ.findAllTutorApprove();
	}
	
	@RequestMapping(value = "/allStudentApprove", method = RequestMethod.GET)
	public List<GenericUser> getStudentApprove()
	{
		return adminServ.findAllStudentApprove();
	}
	
	@RequestMapping(value="/deleteStudent/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteStudent(@PathVariable("id") int id){
		adminServ.deleteUser(id);
		return ResponseEntity.ok(null);
	}
	
	@RequestMapping(value = "/allTutorWithTech", method = RequestMethod.GET)
	public List<TrainingMaterial> getTutorWithTech()
	{
		return adminServ.tutorWithTech();
	}
	
}
