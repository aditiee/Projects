package com.grp10.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtilities {
	private static Connection connect;

	// add static method to get FIXED DB connection from D.M
	public static void createSingletonDBConn(String driverClass, String url, String name, String password)
			throws ClassNotFoundException, SQLException {
		// load
		Class.forName(driverClass);
		// connect
		 connect= DriverManager.getConnection(url, name, password);
	}

	// clean up : close DB connection
	public static void cleanUp() throws Exception {
		if ( connect != null)
			 connect.close();
	}

	// add a static method to get already created SINGLETON DB connection instance
	public static Connection fetchDBConnection() {
		return  connect;
	}
}
