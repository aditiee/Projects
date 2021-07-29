package com.grp10.dao;

import java.sql.SQLException;
import java.util.List;

import com.grp10.model.MapStudentTutorTrainingInfo;
import com.grp10.model.StudentMapping;
import com.grp10.model.TrainingRequest;
import com.grp10.model.UserInfo;


public interface IStudentdDao {

	public List<StudentMapping> getAllTutors() throws SQLException;
	public StudentMapping getTutor(int training_info_id) throws SQLException;
	public List<StudentMapping> getAllTutorsByTechnologyName(String subjectName) throws SQLException;
	public List<StudentMapping> subscriptionList(int userId)throws SQLException;
	public StudentMapping getTrainingContent(int training_info_id) throws SQLException;
	public boolean sendRequest(MapStudentTutorTrainingInfo req) throws SQLException;
	public UserInfo profile(int userId) throws SQLException;
	
}
