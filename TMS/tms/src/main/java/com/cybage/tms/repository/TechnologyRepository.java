package com.cybage.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.cybage.tms.model.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Integer>{

	Technology findByTechnologyId(int technologyId);

}
