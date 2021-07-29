package com.grp10.OnlineTutorManagementSystem.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Repository;

@Repository
public class TutorValidationImpl implements TutorValidation{

	Pattern pattern = null;
	Matcher matcher = null;
	
	@Override
	public boolean emailValidation(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,4}$";
		pattern = Pattern.compile(emailRegex);
		if (pattern.matcher(email).matches()) {
			return true;
		}
		return false;
	}
	@Override
	public boolean passwordValidation(String password) {
		pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
		matcher = pattern.matcher(password);
		if (matcher.matches()) {
			return true;
		}//End of if

		return false;
	}
	

}
