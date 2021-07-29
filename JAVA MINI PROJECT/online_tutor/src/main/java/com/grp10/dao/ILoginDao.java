package com.grp10.dao;

import com.grp10.model.MapUserRole;
import com.grp10.model.RegistrationRequest;
import com.grp10.model.UserInfo;

public interface ILoginDao {

	public UserInfo login(String email, String password);
	public MapUserRole getStatus(int id);
	
}
