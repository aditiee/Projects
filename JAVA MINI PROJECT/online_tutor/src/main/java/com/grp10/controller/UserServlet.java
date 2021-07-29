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

import com.grp10.dao.UserInfoDAO;
//import com.grp10.model.User;
import com.grp10.model.UserInfo;



@WebServlet(urlPatterns={"/delete1","/list1"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfoDAO userInfoDAO;
	
	public void init() {
		userInfoDAO = new UserInfoDAO();
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
			case "/delete1":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
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
		List<UserInfo> listUser = userInfoDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("managestudent.jsp");
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
		response.sendRedirect("list1");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String firstName = request.getParameter("firstName");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");

		UserInfo book = new UserInfo(userId,firstName,mobile,email);
		userInfoDAO.updateUser(book);
		response.sendRedirect("list1");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		userInfoDAO.deleteUser(userId);
		response.sendRedirect("list1");

	}

}
