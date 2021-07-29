package com.grp10.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import com.grp10.model.MapUserRole;
import com.grp10.model.UserInfo;
import static com.grp10.util.DbUtilities.fetchDBConnection;

public class LoginDaoImpl implements ILoginDao {

//	private static final Logger logger = Logger.getLogger(LoginDaoImpl.class);

	private Connection connect;
	

	public LoginDaoImpl() {
		connect = fetchDBConnection();
	}


	public UserInfo login(String email, String password) {

		UserInfo userinfo = new UserInfo();
		UserInfo user=new UserInfo();
		try {

//			logger.info(email + "dao");
			System.out.println(email + "dao");

			PreparedStatement preparedStatement = connect.prepareStatement("select * from user_info where email = ? and password = ? ");
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setUserId(rs.getInt("user_id"));
				userinfo.setFirstName(rs.getString("first_name"));
				userinfo.setLastName(rs.getString("last_name"));
//				logger.info( "while");
			}

			if (userinfo != null && userinfo.getPassword().equals(password)) {

				user=userinfo;
			}
			else
			{
				return null;
			}

			return user;
		} catch (Exception e) {
			return null;
		}
	}

	public MapUserRole getStatus(int id) {
		
		MapUserRole userRole = new MapUserRole();
//		 logger.info(id);
		System.out.println(id);
		try {
			PreparedStatement preparedStatement = connect.prepareStatement("select * from map_user_role where user_id=? ");
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				userRole.setRoleId(rs.getInt("role_id"));
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userRole;
	}

}
