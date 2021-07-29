package com.grp10.tutorspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.SubjectInfo;

@Repository
public interface SubjectInfoRepository extends JpaRepository<SubjectInfo, Integer>{

	public List<SubjectInfo> findBysubjectIdIn(List<Integer> subjectIds);
}
