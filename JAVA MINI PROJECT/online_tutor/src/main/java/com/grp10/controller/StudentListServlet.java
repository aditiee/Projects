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
import javax.servlet.http.HttpSession;

import com.grp10.dao.StudentListDaoImpe;
import com.grp10.model.UserInfo;



@WebServlet("/listStudent")
public class StudentListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
//	int tutorId= 3;
	
	private StudentListDaoImpe studentDAO;   
   
	public void init()
	{
		studentDAO = new StudentListDaoImpe();
	}
	
//    public StudentListServlet() {
//        super();
//      
//    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String action = request.getServletPath();
	
		HttpSession session = request.getSession();
		int tutorId = (int) session.getAttribute("tutorId");
		
		List<UserInfo> listStudent = studentDAO.selectAllStudents(tutorId);
	
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sidebar.jsp");
		dispatcher.forward(request, response);

		
		/*try {
			switch (action) {
			case "/listStudent":
				listStudent(request,response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}*/
	}
	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	
	/*private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException
	{
		List<UserInfo> listStudent = studentDAO.selectAllStudents(tutorId);
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
		
	}*/
}

