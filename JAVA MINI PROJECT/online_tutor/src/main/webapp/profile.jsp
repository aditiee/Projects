<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="views/Bootstrap/common_css_js.jsp"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.StudentMapping"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.UserInfo"%>

<%
UserInfo user = (UserInfo)request.getAttribute("user");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="views/css/student.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" />
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js" />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<style>


.form-control:focus {
	box-shadow: none;
	border-color: #BA68C8
}

.profile-button {
	background: #BA68C8;
	box-shadow: none;
	border: none
}

.profile-button:hover {
	background: #682773
}

.profile-button:focus {
	background: #682773;
	box-shadow: none
}

.profile-button:active {
	background: #682773;
	box-shadow: none
}

.back:hover {
	color: #682773;
	cursor: pointer
}
</style>
<body>
	<nav class="navbar navbar-expand-lg sticky-top"
		style="background: #5372F0; color: #fff;">
		<div class="container-fluid">

			<i class="fas fa-chalkboard-teacher fa-2x" style="color: #fff"></i>
			<div class="collapse navbar-collapse" style="margin-left: 180px"
				id="navbarColor02"></div>
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
			<li><a class="dropdown-item" href="studenthome">Home</a></li>
				<li><a class="dropdown-item"
					href="subscriptiontable?userId=<%=session.getAttribute("studentId")%>">Subscription</a></li>
				<li><a class="dropdown-item" href="#"></a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>


	<div class="container rounded bg-white mt-5">
		<div class="row">
			<div class="col-md-4 border-right">
				<div
					class="d-flex flex-column align-items-center text-center p-3 py-5">
					<i class="rounded-circle mt-5 fas fa-user-circle fa-4x "
						style="color: black"></i><img width="90">
						<span
						class="font-weight-bold"><%=user.getFirstName()%> <%=user.getLastName() %></span>
						<span
						class="text-black-50"><%=user.getEmail() %></span>
				</div>
			</div>
			<div class="col-md-8">
				<div class="p-3 py-5">
					<div class="d-flex justify-content-between align-items-center mb-3">
						<div class="d-flex flex-row align-items-center back">
							<i class="fa fa-long-arrow-left mr-1 mb-1"></i>
				
						</div>
						<h6 class="text-right">Edit Profile</h6>
					</div>
					<div class="row mt-2">
						<div class="col-md-3">
							<strong>Name :</strong>
						</div>
						<div class="col-md-6">
							<p><%=user.getFirstName()%> <%=user.getMiddleName() %>  <%=user.getLastName() %></p>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-3">
							<strong>E-mail :</strong>
						</div>
						<div class="col-md-6">
							<p><%=user.getEmail() %></p>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-md-3">
							<strong>Contact Number :</strong>
						</div>
						<div class="col-md-6">
							<p><%=user.getMobile() %></p>
						</div>
					</div>
					
					<div class="mt-5 text-right">
						<button class="btn btn-primary " type="button">Edit
							Profile</button>
					</div>
				</div>
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
</html>