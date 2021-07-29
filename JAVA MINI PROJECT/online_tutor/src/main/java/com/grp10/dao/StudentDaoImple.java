package com.grp10.dao;

import static com.grp10.util.DbUtilities.fetchDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.grp10.model.MapStudentTutorTrainingInfo;
import com.grp10.model.StudentMapping;
import com.grp10.model.TrainingRequest;
import com.grp10.model.UserInfo;

public class StudentDaoImple implements IStudentdDao {

	private Connection connect;
	private PreparedStatement statement;

	public StudentDaoImple() {
		connect = fetchDBConnection();
	}

	public List<StudentMapping> getAllTutors() throws SQLException {

		List<StudentMapping> tutorList = new ArrayList<StudentMapping>();
		String query = "SELECT\r\n" + " user_info.first_name,\r\n" + " user_info.last_name,\r\n"
				+ " user_info.user_id,\r\n" + " training_info.training_name,\r\n" + " training_info.created_on,\r\n"
				+ " subject_info.description,\r\n" + " training_info.training_info_id\r\n" + " FROM user_info \r\n"
				+ "JOIN map_user_role\r\n" + "  ON user_info.user_id = map_user_role.user_id\r\n"
				+ "JOIN training_info\r\n" + "  ON  training_info.tutor_id =  map_user_role.user_id\r\n"
				+ "  JOIN subject_info\r\n" + "  ON 	subject_info.subject_id = training_info.subject_id;";

		PreparedStatement statement = connect.prepareStatement(query);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			StudentMapping tutors = new StudentMapping();
			tutors.setFirstName(rs.getString("first_name"));
			tutors.setLastName(rs.getString("last_name"));
//			tutors.setId(rs.getInt("user_id"));
			tutors.setTrainingName(rs.getString("training_name"));
			tutors.setCreatedOn(rs.getDate("created_on"));
			tutors.setDescription(rs.getString("description"));
			tutors.setTraining_info_id(rs.getInt("training_info_id"));
			tutors.setTutorId(rs.getInt("user_id"));
			tutorList.add(tutors);

		}

		return tutorList;
	}

	@Override
	public StudentMapping getTutor(int training_info_id) throws SQLException {
		StudentMapping tutor = new StudentMapping();
		String query = "SELECT\r\n" + " user_info.first_name,\r\n" + " user_info.last_name,\r\n"
				+ " user_info.user_id,\r\n" + " training_info.training_name,\r\n" + " training_info.created_on,\r\n"
				+ " subject_info.description,\r\n" + " subject_info.subject_name,\r\n"
				+ " training_info.training_info_id\r\n" + " FROM user_info \r\n" + "JOIN map_user_role\r\n"
				+ "  ON user_info.user_id = map_user_role.user_id\r\n" + "JOIN training_info\r\n"
				+ "  ON  training_info.tutor_id =  map_user_role.user_id\r\n" + "  JOIN subject_info\r\n"
				+ "  ON 	subject_info.subject_id = training_info.subject_id where training_info.training_info_id=?;";

		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, training_info_id);

		ResultSet rs = statement.executeQuery();
		if (rs.next()) {

			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			int id = rs.getInt("user_id");
			String trainingName = rs.getString("training_name");
			Date createdOn = rs.getDate("created_on");
			String description = rs.getString("description");
			String subjectName = rs.getString("subject_name");
			int tutorId =rs.getInt("user_id");
		
			tutor = new StudentMapping(firstName, lastName, id, trainingName, createdOn, description, training_info_id,
					subjectName);
			tutor.setTutorId(tutorId);
		}
		rs.close();
		statement.close();

		return tutor;
	}

	@Override
	public StudentMapping getTrainingContent(int training_info_id) throws SQLException {
		StudentMapping tutor = new StudentMapping();
		String query = "SELECT\r\n" + 
				"	user_info.first_name,\r\n" + 
				"    user_info.last_name,\r\n" + 
				"    training_info.training_name,\r\n" + 
				"    training_content.content,\r\n" + 
				"    training_info.training_info_id ,\r\n" + 
				"    training_content.training_content_id,\r\n" + 
				"    training_content.uploaded_on\r\n" + 
				"FROM user_info\r\n" + 
				"JOIN training_info\r\n" + 
				"  ON user_info.user_id = training_info.tutor_id\r\n" + 
				"JOIN training_content\r\n" + 
				"  ON training_content.training_info_id = training_info.training_info_id where training_info.training_info_id=?;";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, training_info_id);

		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String trainingName = rs.getString("training_name");
			Date uploadedOn = rs.getDate("uploaded_on");
			String contentName = rs.getString("content");
			int trainingContentId = rs.getInt("training_content_id");
			

			tutor = new StudentMapping(firstName, lastName, trainingName, training_info_id, contentName, uploadedOn, trainingContentId);
		}
		System.out.println("training content "+ tutor);
		rs.close();
		statement.close();

		return tutor;
	}
	
	@Override
	public UserInfo profile(int userId) throws SQLException {
	
		UserInfo user = new UserInfo();
		String query ="select * from user_info where user_id = ?";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1,userId);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			String middleName = rs.getString("middle_name");
			String email= rs.getString("email");
			String mobile = rs.getString("mobile_no");
			
			user = new UserInfo(userId, firstName, middleName, lastName, mobile, email);
			
		}
		return user;
	}

	@Override
	public List<StudentMapping> getAllTutorsByTechnologyName(String subjectName) throws SQLException {

		List<StudentMapping> tutorList = new ArrayList<StudentMapping>();
		String query = "SELECT\r\n" + " user_info.first_name,\r\n" + " user_info.last_name,\r\n"
				+ " user_info.user_id,\r\n" + " training_info.training_name,\r\n" + " training_info.created_on,\r\n"
				+ " subject_info.description,\r\n" + " subject_info.subject_name,\r\n"
				+ " training_info.training_info_id\r\n" + " FROM user_info \r\n" + "JOIN map_user_role\r\n"
				+ "  ON user_info.user_id = map_user_role.user_id\r\n" + "JOIN training_info\r\n"
				+ "  ON  training_info.tutor_id =  map_user_role.user_id\r\n" + "  JOIN subject_info\r\n"
				+ "  ON 	subject_info.subject_id = training_info.subject_id where  subject_info.subject_name = ? or user_info.first_name=? or user_info.last_name=?  ";

		String[] name = subjectName.split(" ");
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setString(1, name[0]);
		statement.setString(2, name[0]);

		if (name.length >= 2)
			statement.setString(3, name[1]);
		else
			statement.setString(3, name[0]);

		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			StudentMapping tutors = new StudentMapping();
			tutors.setFirstName(rs.getString("first_name"));
			tutors.setLastName(rs.getString("last_name"));
			tutors.setId(rs.getInt("user_id"));
			tutors.setTrainingName(rs.getString("training_name"));
			tutors.setCreatedOn(rs.getDate("created_on"));
			tutors.setDescription(rs.getString("description"));
			tutors.setTraining_info_id(rs.getInt("training_info_id"));
			tutors.setSubjectName(rs.getString("subject_name"));

			tutorList.add(tutors);

		}

		return tutorList;
	}

	@Override
	public List<StudentMapping> subscriptionList(int userId) throws SQLException {
		List<StudentMapping> subscribedList = new ArrayList<StudentMapping>();
		String query = "select \r\n" + 
				"training_request.status_id,\r\n" + 
				"training_request.training_info_id,\r\n" + 
				"training_request.training_request_id,\r\n" + 
				"training_request.raised_by,\r\n" + 
				"training_info.training_name,\r\n" + 
				"user_info.first_name,\r\n" + 
				"user_info.last_name\r\n" + 
				"from \r\n" + 
				"training_request\r\n" + 
				"JOIN \r\n" + 
				"training_info on training_request.training_info_id =training_info.training_info_id \r\n" + 
				"JOIN\r\n" + 
				"user_info on training_request.tutor_id = user_info.user_id\r\n" + 
				"where training_request.raised_by = ? and training_request.status_id =2;";
		PreparedStatement statement = connect.prepareStatement(query);
		statement.setInt(1, userId);
		ResultSet rs = statement.executeQuery();

		while (rs.next()) {
			StudentMapping tutors = new StudentMapping();
			MapStudentTutorTrainingInfo mapping = new MapStudentTutorTrainingInfo();
			tutors.setFirstName(rs.getString("first_name"));
			tutors.setLastName(rs.getString("last_name"));
			tutors.setTrainingName(rs.getString("training_name"));
			tutors.setTraining_info_id(rs.getInt("training_info_id"));


			subscribedList.add(tutors);

		}
		System.out.println("Subcription list" + subscribedList);
		return subscribedList;

	}

	@Override
	public boolean sendRequest(MapStudentTutorTrainingInfo req) throws SQLException {

		
		boolean rowInserted = false;
		String query = "insert into training_request(training_info_id,status_id,raised_by,raised_on,tutor_id) values(?,?,?,?,?)";
		Date date =java.sql.Date.valueOf(java.time.LocalDate.now());
		PreparedStatement statement = connect.prepareStatement(query);
		System.out.println("sendreq" + req);
		statement.setInt(1, req.getTrainingInfoId());
		statement.setInt(2, 1);
		statement.setInt(3, req.getStudentId());
		statement.setDate(4,(java.sql.Date) date);
		statement.setInt(5, req.getTutorId());
		statement.executeUpdate();
		
		return rowInserted;

	}

	

}
