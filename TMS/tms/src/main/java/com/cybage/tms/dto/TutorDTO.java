package com.cybage.tms.dto;



public class TutorDTO {
	
	private int userId;
	private int technologyId;

	private String userName;
	private String userEmail;
	private String technologyName ;
	
	
	
	
	
	public TutorDTO() {
		super();
	}





	public TutorDTO(int userId, String userName, String userEmail,int technologyId, String technologyName) {
		super();
		this.userId = userId;
		this.technologyId = technologyId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.technologyName = technologyName;
	}





	public int getUserId() {
		return userId;
	}





	public void setUserId(Integer userId) {
		this.userId = userId;
	}





	public int getTechnologyId() {
		return technologyId;
	}





	public void setTechnologyId(Integer technologyId) {
		this.technologyId = technologyId;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
	}





	public String getUserEmail() {
		return userEmail;
	}





	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}





	public String getTechnologyName() {
		return technologyName;
	}





	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}


	

}
