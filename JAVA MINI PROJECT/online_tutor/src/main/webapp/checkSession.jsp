<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

HttpSession  checkSession = request.getSession();
if(checkSession.getAttribute("studentId")==null)
{
	response.sendRedirect("login.jsp");
}

%>