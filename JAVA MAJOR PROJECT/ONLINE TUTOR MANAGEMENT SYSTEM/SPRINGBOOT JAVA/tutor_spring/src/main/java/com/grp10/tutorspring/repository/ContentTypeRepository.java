package com.grp10.tutorspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.ContentType;

@Repository
public interface ContentTypeRepository extends CrudRepository<ContentType, Integer> {

}
