package com.grp10.tutorspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grp10.tutorspring.model.MapUserRole;
@Repository
public interface MapUserRoleRepository extends JpaRepository<MapUserRole, Integer> {

	public MapUserRole findByuserId(int userId);
}
