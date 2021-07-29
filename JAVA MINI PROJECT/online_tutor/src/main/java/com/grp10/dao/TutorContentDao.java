package com.grp10.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grp10.model.Contentmapping;
import com.grp10.model.UserInfo;

public interface TutorContentDao {

	public ArrayList<Contentmapping> getAllContents(int id);
	public boolean deleteContent(int contentId) throws SQLException ;
	public ArrayList<UserInfo> getAllRequests(int id) ;
	public void approveStudents(int id) throws SQLException;
	public void rejectStudents(int id) throws SQLException;
}
