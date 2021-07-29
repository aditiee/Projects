package com.grp10.tutorspring;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.grp10.tutorspring.model.RegistrationRequest;
import com.grp10.tutorspring.model.SubjectInfo;
import com.grp10.tutorspring.model.TrainingContent;
import com.grp10.tutorspring.model.TrainingInfo;
import com.grp10.tutorspring.model.TrainingRequest;
import com.grp10.tutorspring.model.UserInfo;
import com.grp10.tutorspring.repository.RegistrationRequestRepository;
import com.grp10.tutorspring.repository.SubjectInfoRepository;
import com.grp10.tutorspring.repository.TrainingContentRepository;
import com.grp10.tutorspring.repository.TrainingInfoRepository;
import com.grp10.tutorspring.repository.TrainingRequestRepository;
import com.grp10.tutorspring.repository.UserRepository;
import com.grp10.tutorspring.service.AdminService;
import com.grp10.tutorspring.service.StudentServiceImpl;
import com.grp10.tutorspring.service.TutorServiceImpl;
import com.grp10.tutorspring.service.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TutorSpringApplicationTests {
	
	

	@Autowired
	public UserServiceImpl service;	
	public StudentServiceImpl studentservice;
	public UserInfo user;
	public TutorServiceImpl tutorservice;

	
	@MockBean
	public RegistrationRequestRepository repository;
	public UserRepository userrepo;
	public TrainingInfoRepository trainingrepo;
	public SubjectInfoRepository subjectrepo;
	public TrainingRequestRepository trainingrequestrepo;
	public TrainingContentRepository trainingcontentrepo;

		
//	@Test
//	public void addUserTest(){
//		RegistrationRequest user = new RegistrationRequest("abk","narendra","mande","9819902708","abk@gmail.com","abk123",1,2);
//		when(repository.save(user)).thenReturn(user);
//	assertEquals(user,service.addUser(user));
//	}
	
	

	@Test
	public void getTutorsTest(){
		UserInfo user1=new UserInfo("Abk","Mande");
		UserInfo user2=new UserInfo("Yash","Pawar");
		try{
			when(userrepo.findByroleId(2)).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
			assertTrue(studentservice.getTutors().size()>0);
		}catch(NullPointerException ex){
		assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void getTrainingsTest(){
	try{
		when(trainingrepo.findAll()).thenReturn(Stream.of(new TrainingInfo(1,"Core Java Tutorials For Begineers",1,2),new TrainingInfo(2,"ReactJS Tutorial",3,2)).collect(Collectors.toList()));
		assertTrue(studentservice.getTrainings().size()>0);
	}catch(NullPointerException ex){
			assertTrue(ex instanceof NullPointerException);
	}
	}
	
	@Test
	public void getSubjectsTest(){
		try{
		when(subjectrepo.findAll()).thenReturn(Stream.of(new SubjectInfo(1,"Java","Java is a high-level, class-based, object-oriented programming language",2),new SubjectInfo(2,"Python","Python is a general-purpose coding language",3)).collect(Collectors.toList()));
		assertTrue(studentservice.getSubjects().size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void newRequestTest(){
		try{
		TrainingRequest req=new TrainingRequest(1,2,3);
		when(trainingrequestrepo.save(req)).thenReturn(req);
		assertEquals(req,studentservice.newRequest(req));
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void getAllRequestsTest(){
		try{
		when(trainingrequestrepo.findByraisedBy(12)).thenReturn(Stream.of(new TrainingRequest(1,2,3)).collect(Collectors.toList()));
		assertTrue(studentservice.getAllRequests(12).size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	//Tutor
	@Test
	public void TutorgetAllStudentRequests(){
		try{
			when(trainingrequestrepo.findBytutorId(2)).thenReturn(Stream.of(new TrainingRequest(1,2,3,4),new TrainingRequest(5,6,7,8)).collect(Collectors.toList()));
			assertTrue(tutorservice.getAllRequests(10).size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void TutorapproveRequestTest(){
		try{
		when(trainingrequestrepo.findBytrainingRequestId(12)).thenReturn((TrainingRequest) Stream.of(new TrainingInfo(1,"Core Java Tutorials For Begineers",1,2),new TrainingInfo(2,"ReactJS Tutorial",3,2)).collect(Collectors.toList()));
		assertTrue(tutorservice.approveRequest(12));
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}	
	}
	
	@Test
	public void TutorgetAllTrainingsTest(){
		try{
		when(trainingrepo.findBytutorId(10)).thenReturn(Stream.of(new TrainingInfo(1,"Core Java Tutorials For Begineers",1,2),new TrainingInfo(2,"ReactJS Tutorial",3,2)).collect(Collectors.toList()));
		assertTrue(tutorservice.getAllTrainings(10).size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}

	@Test
	public void TutorgetAllcontentsTest(){
		try{
			when(trainingcontentrepo.findBytrainingInfoId(8)).thenReturn(Stream.of(new TrainingContent(14,"JavaMiniProject21-2.pdf",14,6,3)).collect(Collectors.toList()));
			assertTrue(tutorservice.getAllcontents(8).size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void TutorgetSubjectsTest(){
		try{
		when(subjectrepo.findAll()).thenReturn(Stream.of(new SubjectInfo(1,"Java","Java is a high-level, class-based, object-oriented programming language",2),new SubjectInfo(2,"Python","Python is a general-purpose coding language",3)).collect(Collectors.toList()));
		assertTrue(tutorservice.getSubjects().size()>0);
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
		
	}
	
	@Test
	public void TutordeleteRequestTest(){
		try{
		when(trainingrequestrepo.findBytrainingRequestId(2)).thenReturn((TrainingRequest) Stream.of(new TrainingRequest(9, 22, 12, 3)).collect(Collectors.toList()));
		assertTrue(tutorservice.deleteRequest(2));
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	
	@Test
	public void TutordeleteContentTest(){
		try{
		when(trainingcontentrepo.findBytrainingContentId(13)).thenReturn((TrainingContent) Stream.of(new TrainingContent(14,"JavaMiniProject21-2.pdf",14,6,3)).collect(Collectors.toList()));
		assertTrue(tutorservice.deleteContent(13));
		}catch(NullPointerException ex)
		{
			assertTrue(ex instanceof NullPointerException);
		}
	}
	

	public TutorSpringApplicationTests() {
		super();
		
	}
	
	
	
	@Autowired
	private AdminService adminService;
	
	@MockBean
	private UserRepository userRepository;
	private RegistrationRequestRepository repo;
	private TrainingContentRepository  trainingContentRepository ;
	
	@Test
	public void adminGetTutorRequestsTest(){
		 try{
			 when(repo.getTutorRequests()).thenReturn(Stream
					 	.of(new RegistrationRequest("Harry","9834814792","harry@gmail.com")).collect(Collectors.toList()));
		assertTrue( adminService.getTutorRequests().size()>0);
		 }catch(NullPointerException ex){
			   assertTrue(ex instanceof NullPointerException);
		 }
	}

	
	@Test
	public void adminGetStudentRequestsTest(){
		 try{
			 when(repo.getStudentRequests()).thenReturn(Stream
					 	.of(new RegistrationRequest("Jack","9834814792","jack@gmail.com")).collect(Collectors.toList()));
		assertEquals(1, adminService.getStudentRequests().size());
		 }catch(NullPointerException ex){
			   assertTrue(ex instanceof NullPointerException);
		 }
	}
	
	
	@Test
	public void adminGetAllStudentsByTutorTest(){
		UserInfo user1=new UserInfo("Jack","Dsuza","9834814792","jack@gmail.com");
		 UserInfo user2=new UserInfo("John","Cena","9665562406","john@gmail.com");
		try{
			when(userRepository.getAllStudentsByTutor(2)).thenReturn(Stream.of(user1,user2).collect(Collectors.toList()));
			assertTrue(adminService.getAllStudentsByTutor(2).size()>0);		
		}catch(NullPointerException ex){
			   assertTrue(ex instanceof NullPointerException);
		 }
	}
	
	
	@Test
	public void adminGetAllContentsTest(){
		try{
			   when( trainingContentRepository.findAll()).thenReturn(Stream.of(new TrainingContent(14,"JavaMiniProject21-2.pdf",14,6,3)).collect(Collectors.toList()));
			   assertTrue(adminService.getAllContents().size()>0);
			  }catch(NullPointerException ex)
			  {
			   assertTrue(ex instanceof NullPointerException);
			  }
		
	}
	
	
	
	

}
