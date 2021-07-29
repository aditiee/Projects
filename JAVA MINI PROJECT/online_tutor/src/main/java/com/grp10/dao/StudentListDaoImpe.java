package com.grp10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grp10.model.UserInfo;

public class StudentListDaoImpe 
{
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinetutormanagementsystemproject?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	
	//private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
	private static final String SELECT_ALL_STUDENTS_BY_TUTORID = "select user_id,first_name,mobile_no,email from user_info where user_id IN(select student_id from map_student_tutor_training_info where tutor_id=?)";
	
	
	public StudentListDaoImpe() {
	}
	
	
	
	//getconnection
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	
	
	public List<UserInfo> selectAllStudents(int tutorId) {
		
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<UserInfo> users = new ArrayList<>();
		
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
	
		// Step 2:Create a statement using connection object
		PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS_BY_TUTORID);){
		
		preparedStatement.setInt(1, tutorId);
		
		System.out.println(preparedStatement);
		
		// Step 3: Execute the query or update query
		ResultSet rs = preparedStatement.executeQuery();
	
		// Step 4: Process the ResultSet object.
		while (rs.next())
		{
		int userId = rs.getInt("user_id");
		String firstName = rs.getString("first_name");
		String mobile = rs.getString("mobile_no");
		String email = rs.getString("email");
		users.add(new UserInfo(userId, firstName,mobile,email));
		}
		} 
		catch (SQLException e)
		{
			printSQLException(e);
		}
	return users;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
