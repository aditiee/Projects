package com.grp10.dao;

import static com.grp10.util.DbUtilities.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;

import com.grp10.model.RegistrationRequest;
import com.grp10.model.Status;
public class RegistrationRequestDaoImple implements IRegistrationRequestDao {
	private Connection connect;
	private PreparedStatement statement;
	
	
	
	
	public RegistrationRequestDaoImple() {
		connect = fetchDBConnection();
	}




	public boolean registerUser(RegistrationRequest user) throws SQLException {
	
		String query = "insert into registeration_request(registeration_id,first_name,middle_name,last_name,mobile_no,email,password,status_id,role_id,created_on,last_modified_by,last_modified_on) values (?,?,?,?,?,?,?,?,?,?,?,?) ";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1,user.getId());
		statement.setString(2, user.getFirstName());
		statement.setString(3, user.getMiddleName());
		statement.setString(4, user.getLastName());
		statement.setString(5,user.getMobile());
		statement.setString(6,user.getEmail());
		statement.setString(7, user.getPassword());
		statement.setInt(8, user.getStatusId());
		statement.setInt(9, user.getRoleId());
		statement.setDate(10, (java.sql.Date) user.getCreatedOn());
		statement.setInt(11,user.getLastModifiedBy());
		statement.setDate(12, (java.sql.Date) user.getCreatedOn() );

		boolean rowInserted = statement.executeUpdate() > 0;
		return rowInserted;
		
		

	}

}
