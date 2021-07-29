package com.grp10.dao;

import java.sql.SQLException;

import com.grp10.model.RegistrationRequest;

public interface IRegistrationRequestDao {
	
	public boolean registerUser(RegistrationRequest user) throws SQLException;

}
