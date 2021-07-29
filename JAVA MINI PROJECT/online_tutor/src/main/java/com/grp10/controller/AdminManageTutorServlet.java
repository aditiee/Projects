package com.grp10.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.grp10.dao.AdminManageTutorDAO;
import com.grp10.model.Contentmapping;
//import com.grp10.model.User;
import com.grp10.model.UserInfo;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet(urlPatterns= {"/list","/listContent","/studentlist"})
public class AdminManageTutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminManageTutorDAO userInfoDAO;
	
	public void init() {
		userInfoDAO = new AdminManageTutorDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/listContent":
				listContent(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/tutorprofile":
				tutorprofile(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/studentlist":
				listStudent(request, response);
				break;
			default:
				listUser(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	
	
	
	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<UserInfo> listUser = userInfoDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminTutorManage.jsp");
		dispatcher.forward(request, response);
	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int tutorId = Integer.parseInt(request.getParameter("userId"));
		List<UserInfo> listUser = userInfoDAO.selectAllStudents(tutorId);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("adminTutorStudentList.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	private void tutorprofile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		int tutorId = Integer.parseInt(request.getParameter("userId"));
		UserInfo listUser = userInfoDAO.selectTutorInfo(tutorId);
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("tutorProfile.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	
	
	
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		UserInfo existingUser = userInfoDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String firstName= request.getParameter("firstName");
		String mobile= request.getParameter("mobile");
		String email = request.getParameter("email");
		UserInfo newUser = new UserInfo( firstName,  mobile,  email);
		userInfoDAO.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");

		UserInfo book = new UserInfo(userId,firstName,mobile,email);
		userInfoDAO.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userInfoDAO.deleteUser(userId);
		response.sendRedirect("list");

	}
	
	
	

	private void listContent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("doGet");
        HttpSession session=request.getSession();
		
        int userId = Integer.parseInt(request.getParameter("userId"));
		ArrayList<Contentmapping> contentList=new ArrayList<Contentmapping>();
				contentList=userInfoDAO.getAllContents(userId);
				System.out.println(contentList);
				
				request.setAttribute("listContent", contentList);
				  RequestDispatcher dispatcher = request.getRequestDispatcher("adminTutorContent.jsp");
				  dispatcher.forward(request, response);
	
	}
	
	private void deleteContent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int contentId = Integer.parseInt(request.getParameter("trainingContentId"));
		userInfoDAO.deleteContent(contentId);
		response.sendRedirect("list");

	}
	

}
