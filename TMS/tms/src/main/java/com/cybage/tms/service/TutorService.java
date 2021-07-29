package com.cybage.tms.service;

import java.io.IOException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.tms.dto.MaterialDTO;
import com.cybage.tms.dto.TechnologyDTO;
import com.cybage.tms.model.GenericUser;
import com.cybage.tms.model.Technology;
import com.cybage.tms.model.TrainingMaterial;
import com.cybage.tms.repository.TechnologyRepository;
import com.cybage.tms.repository.TrainingMaterialRepository;
import com.cybage.tms.repository.UserRepository;

@Service
@Transactional
public class TutorService {
	
	@Autowired
	TechnologyRepository techRepo;
    
	@Autowired
	TrainingMaterialRepository trainingmaterial;
	

	
	public Technology addTechnology(int id,TechnologyDTO technologyDTO){
		GenericUser genericUser=new GenericUser();
		Technology technology=new Technology();
		genericUser.setUserId(id);
		technology.setBelongsToTutors(genericUser);
		technology.setTechnologyId(technologyDTO.getTechnologyId());
		technology.setTechnologyName(technologyDTO.getTechnologyName());
		return techRepo.save(technology);
	}




	public TrainingMaterial addMaterial(MaterialDTO materialDto) {
		TrainingMaterial material=new TrainingMaterial();
		GenericUser tutor=new GenericUser();
		tutor.setUserId(materialDto.getUserId());
		Technology technology=new Technology();
		technology.setTechnologyId(materialDto.getTechnologyId());
		material.setBelongsTechnology(technology);
		material.setBelongsToTutor(tutor);
		material.setFileName(materialDto.getFileName());
		try {
			material.setFileData(materialDto.getFileData().getBytes());
			material.setFileType(materialDto.getFileData().getContentType());
		} catch (IOException e) {
			
			return null;
			
		}
		
		
		return trainingmaterial.save(material);
	}

	
	
	
}
