package com.grp10.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grp10.dao.ManageStudentDAO;
import com.grp10.model.RegistrationRequest;



@WebServlet(urlPatterns={"/deletestudent","/student","/updatestudent"})
public class ManageStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ManageStudentDAO userInfoDAO;
	
	public void init() {
		userInfoDAO = new ManageStudentDAO();
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
			case "/insert":
				insertUser(request, response);
				break;
			case "/deletestudent":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/updatestudent":
				updateUser(request, response);
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
		List<RegistrationRequest> listUser = userInfoDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("studentsidebar.jsp");
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
		RegistrationRequest existingUser = userInfoDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String firstName= request.getParameter("firstName");
		String mobile= request.getParameter("mobile");
		String email = request.getParameter("email");
		RegistrationRequest newUser = new RegistrationRequest( firstName,  mobile,  email);
		userInfoDAO.insertUser(newUser);
		response.sendRedirect("liststudent");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		//String firstName = request.getParameter("firstName");
		//String mobile = request.getParameter("mobile");
	//	String email = request.getParameter("email");

	//	RegistrationRequest book = new RegistrationRequest(userId,firstName,mobile,email);
		userInfoDAO.updateUser(id);
		response.sendRedirect("adminDashboard.jsp");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userInfoDAO.deleteUser(id);
		response.sendRedirect("student");

	}

}
