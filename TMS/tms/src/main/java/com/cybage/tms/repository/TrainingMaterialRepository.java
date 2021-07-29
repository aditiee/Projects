package com.cybage.tms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cybage.tms.model.ApprovalStatus;
import com.cybage.tms.model.TrainingMaterial;

@Repository
public interface TrainingMaterialRepository extends JpaRepository<TrainingMaterial, Integer> {
	
	@Query(value="Select m from TrainingMaterial m inner join StudentCourseDetail stud on m.belongsTechnology=stud.technologies"
			+ " where stud.belongsToUser.userId=?1 and stud.requestApproval=?2")
	public List<TrainingMaterial> findMaterial(Integer id,ApprovalStatus status);
	

}
