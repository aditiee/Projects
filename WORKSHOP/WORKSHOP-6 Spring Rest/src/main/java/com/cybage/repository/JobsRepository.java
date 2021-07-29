package com.cybage.repository;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.cybage.model.Job;

@RepositoryRestResource(collectionResourceRel="jobs")
public interface JobsRepository extends PagingAndSortingRepository<Job,Integer>{
	
}
