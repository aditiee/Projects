package com.grp10.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.grp10.model.UserInfo;


public class UserInfoDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/onlinetutormanagementsystemproject?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";

	private static final String INSERT_USERS_SQL = "INSERT INTO user_info" + "  (first_name,mobile_no, email) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select user_id,first_name, mobile_no, email from user_info where user_id =?";
	private static final String SELECT_ALL_STUDENTS = "select user_id,first_name,mobile_no,email from user_info where user_id IN (select user_id from map_user_role where role_id=3)";
	//private static final String SELECT_ALL_STUDENTS ="select user_id" +",concat(first_name," + " ,last_name) as"+ "Student Name"+" ,mobile_no,email from user_info where user_id IN (select user_id from map_user_role where role_id=3)";
	private static final String DELETE_USERS_SQL = "delete from user_info where user_id =?;";
	private static final String UPDATE_USERS_SQL = "update user_info set first_name = ?, mobile_no= ?,email =? where user_id = ?;";

	public UserInfoDAO() {
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
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
		//	Date date =java.sql.Date.valueOf(java.time.LocalDate.now());
			
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

}
