package com.grp10.dao;

import static com.grp10.util.DbUtilities.fetchDBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.grp10.model.Contentmapping;
import com.grp10.model.UserInfo;

public class TutorContentDaoImpl implements TutorContentDao{
//	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	private Connection connect;
    
	public TutorContentDaoImpl() {
		connect = fetchDBConnection();
		
	}


	public ArrayList<Contentmapping> getAllContents(int id) {
		ArrayList<Contentmapping> retList=new ArrayList<Contentmapping>();
		try {
			System.out.println("inside try");
			PreparedStatement ps1=connect.prepareStatement("select c.training_content_id,a.subject_name,b.training_name,c.content,c.uploaded_on from subject_info a,training_info b,training_content c  where a.subject_id=b.subject_id and b.training_info_id=c.training_info_id and c.tutor_id = ? order by c.training_content_id desc");
           ps1.setInt(1,id);
			ResultSet rs=ps1.executeQuery();
           while(rs.next())
           {
        	   Contentmapping content=new Contentmapping();
        	   content.setTrainingContentId(rs.getInt("training_content_id"));
        	   content.setSubjectName(rs.getString("subject_name"));
        	   content.setTrainingName(rs.getString("training_name"));
        	   content.setContents(rs.getString("content"));
        	   content.setCreatedOn(rs.getDate("uploaded_on"));
        	   retList.add(content);
           }
           return retList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<Contentmapping>();
	}


	public boolean deleteContent(int contentId) throws SQLException {
		boolean rowDeleted;
		
				PreparedStatement statement = connect.prepareStatement("delete from training_content where training_content_id=?") ;
			statement.setInt(1, contentId);
			rowDeleted = statement.executeUpdate() > 0;
		
		return rowDeleted;

		
	}
	public ArrayList<UserInfo> getAllRequests(int id) {
		ArrayList<UserInfo> retList=new ArrayList<UserInfo>();
		try {
			PreparedStatement ps1=connect.prepareStatement("select a.first_name,a.last_name,a.email,b.raised_by,b.status_id from user_info a, training_request b where a.user_id=b.raised_by and b.status_id=1;");
		ResultSet rs=ps1.executeQuery();
           while(rs.next())
           {
            UserInfo user=new UserInfo();
            user.setUserId(rs.getInt("raised_by"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            retList.add(user);
        	   
           }
              	   
           return retList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<UserInfo>();
	}
	Date date =java.sql.Date.valueOf(java.time.LocalDate.now());
	public void approveStudents(int id) throws SQLException
	{
		
		PreparedStatement statement = connect.prepareStatement("update training_request set status_id=2, action_taken_on = ? where raised_by = ? and status_id=1 ") ;
	    
		statement.setDate(1,(java.sql.Date) date);

	    statement.setInt(2, id);
		statement.executeUpdate();
		PreparedStatement statement1 = connect.prepareStatement("select * from training_request where tutor_id=?") ; 
		   
	     statement1.setInt(1, id); 
	      
	     ResultSet rs=statement1.executeQuery(); 
	     int trainingId=0; 
	     int studId=0; 
	     while(rs.next()) 
	     { 
	       trainingId=rs.getInt("training_info_id"); 
	       studId=rs.getInt("raised_by"); 
	          
	     } 
	      System.out.println("statement fetch " + statement1.toString());
	     PreparedStatement statement2 = connect.prepareStatement("insert into map_student_tutor_training_info (training_info_id,student_id,tutor_id,approved_on) values (?,?,?,?)"); 
	     statement2.setInt(1,trainingId); 
	     statement2.setInt(2, studId); 
	     statement2.setInt(3,id); 
	     statement2.setDate(4, (java.sql.Date) date);
	     System.out.println("statement fetch " + statement2.toString());
	}

	public void rejectStudents(int id) throws SQLException
	{
		PreparedStatement statement = connect.prepareStatement("update training_request set status_id=3, action_taken_on = ? where raised_by = ? and status_id=1 ");
		statement.setDate(1,(java.sql.Date) date);

	    statement.setInt(2, id);
		statement.executeUpdate();

	}

	
}
