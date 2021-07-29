package com.cybage.tms.dto;

public class EmailDTO {

	private String email;

	public EmailDTO() {}
	public EmailDTO(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailDTO [email=" + email + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
