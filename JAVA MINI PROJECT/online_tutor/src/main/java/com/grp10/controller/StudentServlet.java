package com.grp10.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.grp10.dao.StudentDaoImple;
import com.grp10.dao.TutorContentDaoImpl;
import com.grp10.dao.UploadContentDaoImpl;
import com.grp10.model.Contentmapping;
import com.grp10.model.MapStudentTutorTrainingInfo;
import com.grp10.model.StudentMapping;
import com.grp10.model.UserInfo;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentDaoImple studentDao;
	TutorContentDaoImpl content;
	Contentmapping contentobj;
	UploadContentDaoImpl upload;

	public void init() {

		studentDao = new StudentDaoImple();
		content = new TutorContentDaoImpl();
		contentobj = new Contentmapping();
		upload = new UploadContentDaoImpl();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/studenthome":
				listTutors(request, response);
				break;
			case "/studentrequest":
				showTutor(request, response);
				break;
			case "/tutorByTechnoName":
				listTutorsByTechnologyName(request, response);
				break;
			case "/subscriptiontable":
				subscribedList(request, response);
				break;
			case "/view":
				trainingContent(request, response);
				break;
			case "/profile":
				userProfile(request, response);
				break;
			case "/delete":
				deleteContent(request, response);
				break;
			case "/upload":
				uploadContent(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/listContents":
				listContent(request, response);
				break;
			case "/download":
				download(request, response);
				break;
			case "/sendRequest":
				request(request, response);
				break;
			case "/requests":
				studentRequests(request, response);
				break;
			case "/approve":
				approveRequest(request, response);
				break;
			case "/reject":
				rejectRequest(request, response);
				break;
				
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listTutors(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		if(email == null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		else
		{
		List<StudentMapping> tutorList = studentDao.getAllTutors();
		System.out.println(tutorList);
		request.setAttribute("tutorList", tutorList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studenthome.jsp");
		dispatcher.forward(request, response);
		}
	}

	private void subscribedList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		if(email == null || session.getAttribute("studentId")==null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		else {
			int	userId = (int)session.getAttribute("studentId");
		session.setAttribute("studentId", userId);
		System.out.println("userid" + userId);
		List<StudentMapping> subscribeList = studentDao.subscriptionList(userId);
		System.out.println(subscribeList);
		request.setAttribute("subscribedList", subscribeList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("subscriptiontable.jsp");
		dispatcher.forward(request, response);
		}

	}

	private void showTutor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		if(session.getAttribute("tutorId") == null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		else
		{
		int training_info_id = Integer.parseInt(request.getParameter("trainingInfoId"));
		StudentMapping tutor = studentDao.getTutor(training_info_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentrequest.jsp");
		request.setAttribute("tutor", tutor);
		dispatcher.forward(request, response);
		}
	}

	private void trainingContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		HttpSession session = request.getSession();
		if(session.getAttribute("tutorId") == null)
		{
			response.sendRedirect("login.jsp");
			return;
		}
		else
		{
		int training_info_id = Integer.parseInt(request.getParameter("training_info_id"));
		session.setAttribute("training_info_id", training_info_id);
		StudentMapping tutor = studentDao.getTrainingContent(training_info_id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("DownloadContent.jsp");
		request.setAttribute("tutor", tutor);
		dispatcher.forward(request, response);
		}
	}

	
	private void download(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String fileName = request.getParameter("id");
		
		if (fileName == null || fileName.equals("")) {
			throw new ServletException("File Name can't be null or empty");
		}
		File file = new File("D:\\abc\\" + fileName);
		if (!file.exists()) {
			throw new ServletException("File doesn't exists on server.");
		}
		System.out.println("File location on server::" + file.getAbsolutePath());
		ServletContext ctx = getServletContext();
		InputStream fis = new FileInputStream(file);
		String mimeType = ctx.getMimeType(file.getAbsolutePath());
		response.setContentType(mimeType != null ? mimeType : "application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

		ServletOutputStream os = response.getOutputStream();
		byte[] bufferData = new byte[1024];
		int read = 0;
		while ((read = fis.read(bufferData)) != -1) {
			os.write(bufferData, 0, read);
		}
		os.flush();
		os.close();
		fis.close();
		
	}

	private void userProfile(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		int userId = (int) session.getAttribute("studentId");
		session.setAttribute("studentId", userId);
		UserInfo user = studentDao.profile(userId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
		request.setAttribute("user", user);
		dispatcher.forward(request, response);

	}

	private void listTutorsByTechnologyName(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String subjectName = request.getParameter("subjectName");
		List<StudentMapping> tutorList = studentDao.getAllTutorsByTechnologyName(subjectName);
		request.setAttribute("tutorList", tutorList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studenthome.jsp");
		dispatcher.forward(request, response);
	}

	private void request(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		
		MapStudentTutorTrainingInfo req = new MapStudentTutorTrainingInfo();
		HttpSession session = request.getSession();
		int tutorId = Integer.parseInt(request.getParameter("tutorId"));
		req.setTutorId(tutorId);
		int studentId = (int) session.getAttribute("studentId");
		req.setStudentId(studentId);
		int trainingInfoId = Integer.parseInt(request.getParameter("trainingInfoId"));
		req.setTrainingInfoId(trainingInfoId);
		boolean tutorReq = studentDao.sendRequest(req);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/studenthome");
		dispatcher.forward(request, response);

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
		session.invalidate();
	}

	private void listContent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		Integer id = (Integer) session.getAttribute("tutorId");
		ArrayList<Contentmapping> contentList = new ArrayList<Contentmapping>();
		contentList = content.getAllContents(id);
		

		request.setAttribute("listContent", contentList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contents.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteContent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int contentId = Integer.parseInt(request.getParameter("trainingContentId"));
		content.deleteContent(contentId);
		response.sendRedirect("list");

	}

	private void uploadContent(HttpServletRequest request, HttpServletResponse response) {

		List<String> filename = new ArrayList<String>();
//		logger.info("doPost");
		HttpSession session = request.getSession();

		Integer id = (Integer) session.getAttribute("tutorId");
//		logger.info(id);
//		

		try {
			ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
			List<String> forms = new ArrayList<String>();
			List<FileItem> multifiles = sf.parseRequest(request);
			for (FileItem item : multifiles)// .subList(4, multifiles.size()))
			{

				int i = 0;
				if (item.isFormField()) {
					forms.add(item.getString());
				} else {
					filename.add(item.getName());
					item.write(new File("D:\\abc\\" + item.getName()));
				}
			}

			Date date = java.sql.Date.valueOf(java.time.LocalDate.now());
			contentobj.setSubjectName(forms.get(0));
			contentobj.setDescription(forms.get(1));
			contentobj.setTrainingName(forms.get(2));
			contentobj.setCreatedBy(id);
			contentobj.setCreatedOn(date);
			contentobj.setContent(filename);
			contentobj.setUserId(id);

			upload.uploadFile(contentobj);

			RequestDispatcher rd = request.getRequestDispatcher("list");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void studentRequests(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		
               HttpSession session=request.getSession();
		
		Integer id =(Integer)session.getAttribute("tutorId");
		ArrayList<UserInfo> users=new ArrayList<UserInfo>();
	   users=content.getAllRequests(id);
	   request.setAttribute("listContent", users);
		  
		RequestDispatcher dispatcher = request.getRequestDispatcher("approvestudent.jsp");
		  dispatcher.forward(request, response);
			
			
	}
	
	private void approveRequest(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException
	{
		int userId = Integer.parseInt(request.getParameter("userId"));
		content.approveStudents(userId);
		response.sendRedirect("approvestudent.jsp");

	}
	
	private void rejectRequest(HttpServletRequest request , HttpServletResponse response) throws SQLException, IOException
	{
		int userId = Integer.parseInt(request.getParameter("userId"));
		content.rejectStudents(userId);
		response.sendRedirect("approvestudent.jsp");

	}
}
