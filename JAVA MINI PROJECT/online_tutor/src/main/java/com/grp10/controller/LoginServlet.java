package com.grp10.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.grp10.dao.LoginDaoImpl;
import com.grp10.model.MapUserRole;
import com.grp10.model.UserInfo;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDaoImpl loginDao;
//	private static final Logger logger = Logger.getLogger(LoginServlet.class);

	public void init() {

		loginDao = new LoginDaoImpl();
	}

	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");

		try {
			authenticate(request, response);
		}

		catch (Exception e) {

			e.printStackTrace();
		}
	}

	private void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		UserInfo user = new UserInfo();
		user = loginDao.login(email, password);
		if (user != null) {
			
			HttpSession session = request.getSession(true);
			session.setAttribute("Username", user.getFirstName() + " " + user.getLastName());
			session.setAttribute("email", user.getEmail());
			session.setAttribute("studentId", user.getUserId());
			session.setAttribute("tutorId", user.getUserId());
			int uid = user.getUserId();
			MapUserRole userRole = new MapUserRole();
			userRole = loginDao.getStatus(uid);

			if (userRole.getRoleId() == 3) {
//				logger.info("user is student");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/studenthome");
				dispatcher.forward(request, response);
			} else if (userRole.getRoleId() == 2) {
//				logger.info("user is tutor");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("tutorDashboard.jsp");
				dispatcher.forward(request, response);
			} else {
//				logger.info("user is Admin");
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("adminDashboard.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			request.setAttribute("error", "invalid credentials");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}

	}
}
