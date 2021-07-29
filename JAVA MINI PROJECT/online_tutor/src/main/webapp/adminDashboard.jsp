<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="views/Bootstrap/common_css_js.jsp"%>
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
</head>
<header> </header>
<style>
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: underline;
}

a:active {
	text-decoration: underline;
}

.card:hover {
	box-shadow: 0 8px 17px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
}
</style>
<body style="background-color: #F9F6F6">


	<nav class="navbar navbar-expand-lg sticky-top"
		style="background: #5372F0; color: #fff;">
		<div class="container-fluid">


			<div class="collapse navbar-collapse" style="margin-left: 180px"
				id="navbarColor02">
				<form action="tutorByTechnoName" method="post" class="d-flex ">
					<input class="form-control me-sm-2 " style="width: 20rem"
						type="text" placeholder="Search...." name="subjectName"> <input
						type="submit" class="btn my-2 my-sm-0"
						style="background: #5372F0; color: #fff;" value="Search">
				</form>

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

				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="logout" style="color: #fff;">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">
		<div class="row mt-5">
			<!-- column1 -->

			<div class="col-md-4 ">

				<div class="card">
					<div class="card ">
						<div class="card-body" style="text-align: center">
							<img style="max-width: 80px"
								src="https://image.flaticon.com/icons/png/512/3449/3449692.png"
								alt="material"> <a
								href="<%=request.getContextPath()%>/list"><h3>Manage
									Tutor</h3></a>
						</div>
					</div>
				</div>
			</div>

			<!-- column2 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card ">
						<div class="card-body" style="text-align: center">
							<img style="max-width: 80px"
								src="https://image.flaticon.com/icons/png/512/1058/1058509.png"
								alt="material"> <a
								href="<%=request.getContextPath()%>/list1"><h3>Manage
									Student</h3></a>
						</div>
					</div>
				</div>
			</div>
			<!-- column2 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card ">
						<div class="card-body" style="text-align: center">
							<img style="max-width: 80px"
								src="https://image.flaticon.com/icons/png/512/1721/1721929.png"
								alt="material"> <a href="approveRequestDashboard.jsp"><h3>Approval
									List</h3></a>
						</div>
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