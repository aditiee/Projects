package com.grp10.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grp10.dao.RegistrationRequestDaoImple;
import com.grp10.model.RegistrationRequest;
import com.grp10.model.Role;
import com.grp10.model.Status;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private RegistrationRequestDaoImple registerDao;
       
       public void init() {
    	   
    	   registerDao = new RegistrationRequestDaoImple();
       }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("FirstName");
		String middleName= request.getParameter("MiddleName");
		String lastName=request.getParameter("LastName");
		String email= request.getParameter("email");
		String mobileNo= request.getParameter("mobileNo");
		String password = request.getParameter("password");
		int role=Integer.valueOf(request.getParameter("role"));
	
		Date date =java.sql.Date.valueOf(java.time.LocalDate.now());

		
		RegistrationRequest user= new RegistrationRequest();
		user.setFirstName(firstName);
		user.setMiddleName(middleName);
		user.setLastName(lastName);
		user.setMobile(mobileNo);
		user.setEmail(email);
		user.setStatusId(1);
		user.setPassword(password);
		user.setRoleId(role);
		user.setCreatedOn(date);
		user.setLastModifiedOn(date);
		
		try {
			registerDao.registerUser(user);
			 RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp"); 
			 dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}

}
