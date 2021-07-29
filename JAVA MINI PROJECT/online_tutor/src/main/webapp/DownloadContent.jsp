<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.StudentMapping"%>

<%
	StudentMapping tutor = (StudentMapping) request.getAttribute("tutor");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Download Content</title>
<link rel="stylesheet" href="views/css/student.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-expand-lg sticky-top"
		style="background: #5372F0; color: #fff;">
		<div class="container-fluid">

			<i class="fas fa-chalkboard-teacher fa-2x" style="color: #fff"></i>
			<div class="collapse navbar-collapse" style="margin-left: 180px"
				id="navbarColor02">
			

			</div>
		</div>
		<h6 style="">
			<%
				String email = request.getParameter("email");
				if (email != null)
					out.print(email);
			%>
		</h6>
		<div class="dropdown" style="margin-right: 90px">

			<button class="btn fas fa-user-circle fa-2x dropdown-toggle"
				style="color: #fff" type="button" id="dropdownMenuButton2"
				data-bs-toggle="dropdown" aria-expanded="false"></button>
			<ul class="dropdown-menu dropdown-menu-light"
				aria-labelledby="dropdownMenuButton2">
				<li><a class="dropdown-item " href="profile?userId=<%=session.getAttribute("studentId")%>">Profile</a></li>
					<li><a class="dropdown-item" href="studenthome">Home</a></li>
				<li><a class="dropdown-item"
					href="subscriptiontable?userId=<%=request.getAttribute("studentId")%>">Subscription</a></li>
				<li><a class="dropdown-item" href="#"></a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container d-flex justify-content-center align-items-center">
	<div class="card mb-3 "
		style="width: 500px; height: 500px; margin-top: 40px;">
		
		<div class="card-body ">
			<p class="card-text"><strong>Tutor Name : </strong><%=tutor.getFirstName() %> <%=tutor.getLastName() %></p>
			<p class="card-text"><strong>Technology : </strong><%=tutor.getTrainingName() %></p>
			<p class="card-text"><strong>Uploaded On : </strong><%=tutor.getUploadedOn() %></p>
			<p class="card-text"><strong>Content : </strong><%=tutor.getContentName() %></p>
			<p class="card-text"><strong>Action : </strong><a href="download?id=<%=tutor.getContentName() %>">Download <i class="fas fa-download"></i></a></p>
			
		</div>
	</div>
	</div>

					<footer id="sticky-footer" class="py-4 text-white-50 fixed-bottom"
						style="background: #5372F0; color: #fff;">
						<div class="container text-center">
							<small>Copyright &copy; Your Website</small>
						</div>
					</footer>
</body>
<script src="views/js/Studentrequest.js"></script>
</html>