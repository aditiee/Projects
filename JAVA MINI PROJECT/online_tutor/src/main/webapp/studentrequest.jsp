<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.StudentMapping"%>
<%@ include file="checkSession.jsp" %>
<%
	StudentMapping tutor = (StudentMapping) request.getAttribute("tutor");
%>

<%
request.setAttribute("tutorId", tutor.getTutorId());
request.setAttribute("trainingInfoId", tutor.getTraining_info_id());
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="views/css/student.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-expand-lg sticky-top"
		style="background: #5372F0; color: #fff;">
		<div class="container-fluid">	</div>
		<h6 style="red"><% String email =(String)session.getAttribute("email"); if( email !=null) 
			out.print(email);
		else
			response.sendRedirect("login.jsp");%></h6>
		<div class="dropdown" style="margin-right: 90px">
			<button class="btn fas fa-user-circle fa-2x dropdown-toggle"
				style="color: #fff" type="button" id="dropdownMenuButton2"
				data-bs-toggle="dropdown" aria-expanded="false"></button>
			<ul class="dropdown-menu dropdown-menu-light"
				aria-labelledby="dropdownMenuButton2">
				<li><a class="dropdown-item" href="studenthome">Home</a></li>
			<li><a class="dropdown-item " href="profile?userId=<%=session.getAttribute("studentId")%>">Profile</a></li>
			<li><a class="dropdown-item" href="subscriptiontable?userId=<%=session.getAttribute("studentId")%>">Subscription</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="logout" style="color: black;">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="card d-flex  align-items-center" style=" height: 100%;margin-left:250px;width:800px">
		<div class="row g-0  d-flex  align-items-center">
			
			<div class="col-md-8 ">
				<div class="card-body  d-flex  align-items-center">
					<div class="row   d-flex  align-items-center">



							<div class="card-body">


								<p class="card-text">
									<strong style="font-size: 15px"><%=tutor.getTrainingName()%></strong>
								</p>
								<p class="card-text">
									<strong style="font-size: 10px"><i>by <%=tutor.getFirstName()%></i>
										<%=tutor.getLastName()%></strong>
								</p>
								<p style="text-align: left"><%=tutor.getDescription()%></p>

								<p class="card-text" style="text-align: right; font-size: 10px">
									<strong>created on : </strong>
									<%=tutor.getCreatedOn()%></p>
								<a href="sendRequest?tutorId=<%=request.getAttribute("tutorId")%>&trainingInfoId=<%=tutor.getTraining_info_id()%>" class="btn"
									style="background: #5372F0; color: #fff;"> Follow</a>
							</div>
						

					</div>

				</div>



			</div>


		</div>
	</div>


	<footer id="sticky-footer" class="py-4 text-white-50 "
		style="background: #5372F0; color: #fff;">
		<div class="container text-center">
			<small>Copyright &copy; Your Website</small>
		</div>
	</footer>
</body>
</html>