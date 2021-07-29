package com.grp10.tutorspring.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.grp10.tutorspring.model.MapStudentTrainingContent;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;

public interface StudentService {

	List<UserInfo> getTutors();

	List<TrainingInfo> getTrainings();

	List<SubjectInfo> getSubjects();

	boolean newRequest(TrainingRequest request);

	List<TrainingRequest> getAllRequests(int tutorId);

	List<UserInfo> getAllTutors(List<Integer> studentIds);

	List<TrainingInfo> getAllTrainings(List<Integer> trainingInfoIds);

	void saveDownloadRequest(MapStudentTrainingContent mapStudentTrainingContent);

	public  void downloadContent(String fileName, HttpServletResponse response);
}
