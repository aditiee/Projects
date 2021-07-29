package com.grp10.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.grp10.model.Contentmapping;
import com.grp10.model.UserInfo;


public class AdminManageTutorDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinetutormanagementsystemproject?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO user_info" + "  (first_name,mobile_no, email) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select user_id,first_name, mobile_no, email from user_info where user_id =?";
	private static final String SELECT_ALL_TUTORS = "select user_id,first_name,mobile_no,email from user_info where user_id IN (select user_id from map_user_role where role_id=2)";
	
	private static final String SELECT_TUTOR_INFO = "select user_id,first_name, mobile_no, email from user_info where user_id =?";
	
	private static final String DELETE_USERS_SQL = "delete from user_info where user_id =?;";
	private static final String UPDATE_USERS_SQL = "update user_info set first_name = ?, mobile_no= ?,email =? where user_id = ?;";
	private static final String SELECT_ALL_STUDENTS_BY_TUTORID = "select user_id,first_name,mobile_no,email from user_info where user_id IN(select student_id from map_student_tutor_training_info where tutor_id=?)";
	
	private static final String SHOW_TUTOR_CONTENT = "select c.training_content_id,a.subject_name,b.training_name,c.content,c.uploaded_on from subject_info a,training_info b,training_content c  where a.subject_id=b.subject_id and b.training_info_id=c.training_info_id and c.tutor_id = ? order by c.uploaded_on desc";
	
	public AdminManageTutorDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(UserInfo user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getMobile());
			preparedStatement.setString(3, user. getEmail());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public UserInfo selectUser(int userId) {
		UserInfo user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
			preparedStatement.setInt(1, userId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String mobile = rs.getString("mobile");
				String  email = rs.getString("email");
				user = new UserInfo(userId, firstName,mobile,email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<UserInfo> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<UserInfo> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TUTORS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String mobile = rs.getString("mobile_no");
				String email = rs.getString("email");
				users.add(new UserInfo(userId, firstName,mobile,email));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}
	
	

	
	public List<UserInfo> selectAllStudents(int tutorId) {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<UserInfo> users = new ArrayList<>();
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
				int userId = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String mobile = rs.getString("mobile_no");
				String email = rs.getString("email");
				users.add(new UserInfo(userId, firstName,mobile,email));
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

	public boolean updateUser(UserInfo user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getMobile());
			statement.setString(3, user.getEmail());
			statement.setInt(4, user.getUserId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
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

	public UserInfo selectTutorInfo(int tutorId) {

		UserInfo user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TUTOR_INFO)) {
			preparedStatement.setInt(1, tutorId);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstName = rs.getString("firstName");
				String mobile = rs.getString("mobile");
				String  email = rs.getString("email");
				user = new UserInfo(tutorId, firstName,mobile,email);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	
	}

	public ArrayList<Contentmapping> getAllContents(Integer id) {
		ArrayList<Contentmapping> retList=new ArrayList<Contentmapping>();
		try {Connection connection = getConnection();
			PreparedStatement ps1=connection.prepareStatement(SHOW_TUTOR_CONTENT);
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
		Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement("delete from training_content where training_content_id=?") ;
			statement.setInt(1, contentId);
			rowDeleted = statement.executeUpdate() > 0;
		
		return rowDeleted;

		
	}

	

}
