package com.cybage.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.tms.dto.MaterialDTO;
import com.cybage.tms.dto.TechnologyDTO;
import com.cybage.tms.model.Technology;
import com.cybage.tms.model.TrainingMaterial;
import com.cybage.tms.service.TutorService;

@CrossOrigin
@RestController
public class TutorController {

	@Autowired
	TutorService tutorServ;
	
	//@RequestMapping(value="/addTechnology/{id}",method=RequestMethod.POST)
	@PostMapping("/addTechnology")
	public ResponseEntity<?> addTechnology(@RequestParam Integer userId, @RequestBody TechnologyDTO tech){
		try{
			return new ResponseEntity<>(tutorServ.addTechnology(userId, tech),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
	}

	
	//@RequestMapping(value="/addmaterial",method=RequestMethod.POST)
	@PostMapping("/addmaterial")
	public ResponseEntity<?> addMaterial(@ModelAttribute MaterialDTO materialDto)
	{
		
		try{
			return new ResponseEntity<>(tutorServ.addMaterial(materialDto),HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	
	
	
}
