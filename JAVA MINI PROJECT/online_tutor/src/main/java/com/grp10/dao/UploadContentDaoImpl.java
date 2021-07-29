package com.grp10.dao;

import static com.grp10.util.DbUtilities.fetchDBConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.grp10.model.Contentmapping;

public class UploadContentDaoImpl implements UploadContentDao{
	
//	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	private Connection connect;
    
	public UploadContentDaoImpl() {
		connect = fetchDBConnection();
	}
	
	

	public void uploadFile(Contentmapping content) {
	
		try {
			
			//inserting into subject_info
			PreparedStatement ps1=connect.prepareStatement("insert into subject_info(subject_name,description,created_by,created_on,last_modified_by,last_modified_on) values(?,?,?,?,?,?) ");
			ps1.setString(1,content.getSubjectName());
			ps1.setString(2, content.getDescription());
			ps1.setInt(3,content.getCreatedBy());
			ps1.setDate(4, (Date) content.getCreatedOn());
			ps1.setInt(5,content.getCreatedBy());
			ps1.setDate(6, (Date) content.getCreatedOn());
			ps1.executeUpdate();
			
			int subId=getsubjectId();
			//inserting into training_info
			PreparedStatement ps2=connect.prepareStatement("insert into training_info(training_name,subject_id,tutor_id,created_on,last_modified_on) values(?,?,?,?,?) ");
			ps2.setString(1,content.getTrainingName());
			ps2.setInt(2, subId);
			ps2.setInt(3,content.getUserId());
			ps2.setDate(4, (Date) content.getCreatedOn());
			ps2.setDate(5, (Date) content.getCreatedOn());
			
			ps2.executeUpdate();
			
			
			int trainingInfoId=getTrainingInfoId();
			//inserting into training_content
			PreparedStatement ps3=connect.prepareStatement("insert into training_content(training_info_id,content,tutor_id,uploaded_on) values(?,?,?,?) ");
			int count=0;
			List<String> clist=content.getContent();
			
			for(String s:clist)
			{
				ps3.setInt(1,trainingInfoId);
				ps3.setString(2, s);
				
				ps3.setInt(3, content.getUserId());
				ps3.setDate(4, (Date) content.getCreatedOn());
				
					ps3.addBatch();
				
				count++;
				if (count % 100 == 0 || count == clist.size()) {
                    ps3.executeBatch();
			}
				
			}
//			
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	public int getsubjectId() {
		int id=0;
		try {
			
			PreparedStatement ps=connect.prepareStatement("select subject_id from subject_info ORDER BY subject_id DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				 id=rs.getInt("subject_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public int getTrainingInfoId() {
		int id=0;
		try {
			
			PreparedStatement ps=connect.prepareStatement("select training_info_id from training_info ORDER BY training_info_id DESC LIMIT 1");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				 id=rs.getInt("training_info_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}


	}
