package com.grp10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grp10.model.RegistrationRequest;
//import com.grp10.model.UserInfo;


public class ManageTutorDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinetutormanagementsystemproject?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO registeration_request" + "  (first_name,mobile_no, email) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select registeration_id,first_name, mobile_no, email from registeration_request where registeration_id =?";
	private static final String SELECT_ALL_TUTORS = "select registeration_id,first_name, mobile_no, email from registeration_request where role_id = 2";
	private static final String DELETE_USERS_SQL = "delete from registeration_request where registeration_id =?;";
	private static final String UPDATE_USERS_SQL = "update registeration_request set status_id=2 where registeration_id=?";
	private static final String SELECT_ALL_STUDENTS_BY_TUTORID = "select registeration_id,first_name,mobile_no,email from registeration_request where registeration_id IN(select student_id from map_student_tutor_training_info where tutor_id=?)";
	public ManageTutorDAO() {
	}

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

	public void insertUser(RegistrationRequest newUser) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, newUser.getFirstName());
			preparedStatement.setString(2, newUser.getMobile());
			preparedStatement.setString(3, newUser. getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public RegistrationRequest selectUser(int userId) {
		RegistrationRequest user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, userId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String mobile = rs.getString("mobile");
				String  email = rs.getString("email");
				user = new RegistrationRequest(userId, firstName,mobile,email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<RegistrationRequest> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<RegistrationRequest> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TUTORS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userId = rs.getInt("registeration_id");
				String firstName = rs.getString("first_name");
				String mobile = rs.getString("mobile_no");
				String email = rs.getString("email");
				users.add(new RegistrationRequest(userId, firstName,mobile,email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	
	
	public List<RegistrationRequest> selectAllStudents(int tutorId) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<RegistrationRequest> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS_BY_TUTORID);) {
			preparedStatement.setInt(1, tutorId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userId = rs.getInt("registeration_id");
				String firstName = rs.getString("first_name");
				String mobile = rs.getString("mobile_no");
				String email = rs.getString("email");
				users.add(new RegistrationRequest(userId, firstName,mobile,email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public void updateUser(int id) throws SQLException {
		//int rowUpdated;
		
		RegistrationRequest newUser=new RegistrationRequest();
		try (Connection connection = getConnection();)
		{
			Date date =java.sql.Date.valueOf(java.time.LocalDate.now());
			PreparedStatement statement1 = connection.prepareStatement(UPDATE_USERS_SQL); 
			statement1.setInt(1, id);
//			statement.setString(2, book.getMobile());
//			statement.setString(3, book.getEmail());
//			statement.setInt(4, book.getId());

			//rowUpdated = statement1.executeUpdate() >0;
			statement1.executeUpdate();
			
			PreparedStatement statement2 = connection.prepareStatement(" select * from registeration_request where status_id=2 and registeration_id=?"); 
			statement2.setInt(1, id);
			//RegistrationRequest newUser=new RegistrationRequest();
//			statement2.setString(1, newUser.getFirstName());
//			statement2.setString(2, newUser.getMobile());
//			statement2.setString(3, newUser. getEmail());
//			System.out.println(statement2);
//			statement2.executeUpdate();
			int roleId=0;
			ResultSet rs = statement2 .executeQuery();
			while (rs.next()) {
				
				//int userId = rs.getInt("registeration_id");
//				String firstName = rs.getString("first_name");
//				String lastName = rs.getString("last_name");
//				String mobile = rs.getString("mobile_no");
//				String email = rs.getString("email");
				newUser.setFirstName(rs.getString("first_name"));
				newUser.setMiddleName(rs.getString("middle_name"));
				newUser.setLastName(rs.getString("last_name"));
				newUser.setMobile(rs.getString("mobile_no"));
				newUser.setEmail(rs.getString("email"));
				newUser.setPassword(rs.getString("password"));
				roleId=rs.getInt("role_id");
				
			}
			int is_active=1;
			int created_by=1;
			PreparedStatement statement3= connection.prepareStatement("insert into user_info ( first_name, middle_name, last_name, mobile_no, email, password,is_active, created_by,created_on, last_modified_by, last_modified_on) values(?,?,?,?,?,?,?,?,?,?,?)");
			 statement3.setString(1,newUser.getFirstName());
			 statement3.setString(2,newUser.getMiddleName() );
			 statement3.setString(3, newUser.getLastName());
			 statement3.setString(4,newUser.getMobile());
			 statement3.setString(5,newUser.getEmail());
			 statement3.setString(6,newUser.getPassword());
			 statement3.setInt(7, is_active);
			 statement3.setInt(8, created_by);
			 statement3.setDate(9,(java.sql.Date) date);
			 statement3.setInt(10, created_by);
			 statement3.setDate(11,(java.sql.Date) date);
			 
			 statement3.executeUpdate();
				
			 
			 int userId=getUserId();
			 
			 PreparedStatement statement5= connection.prepareStatement("insert into map_user_role values(?,?,?,?)");
			 statement5.setInt(1,userId);
			 statement5.setInt(2,roleId);
			 statement5.setInt(3,created_by);
			 statement5.setDate(4, (java.sql.Date) date);
			 
			 statement5.executeUpdate();
			 
			 
			 PreparedStatement statement6 = connection.prepareStatement("delete from registeration_request where registeration_id=? ");
			 
			 statement6.setInt(1,id);
			 
			 statement6.executeUpdate();
			 
		}
		
		
		
		//return rowUpdated;
	}
	 public int getUserId() throws SQLException
	 {
		 Connection connection = getConnection();
		 PreparedStatement statement4 = connection.prepareStatement("select user_id from user_info order by user_id desc limit 1"); 
		 int id=0;
		 ResultSet rs = statement4 .executeQuery();
		 while (rs.next()) {
			 id=rs.getInt("user_id");
			  }
		 return id;
		 
		 
		
		 
		 
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
