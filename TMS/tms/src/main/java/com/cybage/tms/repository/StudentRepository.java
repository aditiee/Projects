package com.cybage.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.tms.dto.TutorDTO;
import com.cybage.tms.model.GenericUser;


@Repository
public interface StudentRepository extends JpaRepository<GenericUser, Integer>{

	@Query(value="select new com.cybage.tms.dto.TutorDTO(u.userId,u.userName,u.userEmail,t.technologyId,t.technologyName)from GenericUser u join Technology t on u.userId=t.belongsToTutors")
	List<TutorDTO> findAllTutor();

	
	@Query(value="select new com.cybage.tms.dto.TutorDTO(u.userId,u.userName,u.userEmail,t.technologyId,t.technologyName)from GenericUser u join Technology t on u.userId=t.belongsToTutors where u.userName LIKE %?1%" 
			+ " OR t.technologyName LIKE %?1%")
	List<TutorDTO> listAll(String searchtext);

}
