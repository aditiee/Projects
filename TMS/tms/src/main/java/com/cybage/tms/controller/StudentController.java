package com.cybage.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tms.dto.TutorDTO;
import com.cybage.tms.model.StudentCourseDetail;
import com.cybage.tms.model.TrainingMaterial;
import com.cybage.tms.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	//All Tutor Fetched done
	//@RequestMapping(value = "/getAllTutor", method = RequestMethod.GET)
	@GetMapping("/getAllTutor")
	public ResponseEntity<?> getAllTutor()
	{
		try{
			return new ResponseEntity<>(studentService.findAllTutor(),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	//Search done
	//@RequestMapping(value = "/getAllTutor/{searchtext}", method = RequestMethod.GET)
	@GetMapping("/searchtutor")
	public ResponseEntity<?> search(@RequestParam String searchtext)
	{
		try{
			return new ResponseEntity<>(studentService.listAll(searchtext),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
 // done send request for material
	
	//@RequestMapping(value="/enroll/{id}", method = RequestMethod.POST)
	@PostMapping("/enroll")
	public ResponseEntity<?> requestForMaterial(@RequestBody TutorDTO tutor,@RequestParam Integer userId)
	{
		try{
			return new ResponseEntity<>(studentService.requestToTutor(tutor,userId),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	//view approvedList material
	
	//@RequestMapping(value = "/viewMaterial/{id}", method = RequestMethod.GET)
	@GetMapping("/viewMaterial")
	public ResponseEntity<?> viewMaterial(@RequestParam Integer userId)
	{
		try{
			return new ResponseEntity<>(studentService.getMaterialList(userId),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	//get materialList

	//@RequestMapping(value = "/material/{id}", method = RequestMethod.GET)
	@GetMapping("/materialList")
	public ResponseEntity<?> getMaterial(@RequestParam Integer userId)
	{
		try{
			return new ResponseEntity<>(studentService.getMaterial(userId),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		
	}
	
	
	
}
