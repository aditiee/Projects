package com.cybage.tms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.tms.model.UserActivity;



public interface UserActivityRepository extends JpaRepository<UserActivity, Integer> {

}
