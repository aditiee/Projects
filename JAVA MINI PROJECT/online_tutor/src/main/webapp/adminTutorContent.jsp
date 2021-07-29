<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student List</title>
<!-- bootstrap 5 css 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
     custom css -->
<!-- <link rel="stylesheet" href="css/style.css"> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	rel="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
<script
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>


<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	min-height: 100vh;
	background-color: #fff;
}

.navbar {
	width: 250px;
	height: 100vh;
	position: fixed;
	margin-left: -300px;
	background-color: #408080;
	transition: 0.4s;
}

.nav-link {
	font-size: 1.25em;
}

.nav-link:active, .nav-link:focus, .nav-link:hover {
	background-color: #ffffff26;
}

.dropdown-menu {
	background-color: #7952b3;
}

.dropdown-item:active, .dropdown-item:focus, .dropdown-item:hover {
	background-color: #ffffff26;
}

.my-container {
	transition: 0.4s;
}
/* for navbar */
.active-nav {
	margin-left: 0;
}
/* for main section */
.active-cont {
	margin-left: 250px;
}

#menu-btn {
	background-color: #408080;
	color: #fff;
}

#menu-btn:focus {
	box-shadow: 0 0 0 0.25rem #7952b344;
}

.header {
	padding: 20px;
	background: #fff;
	color: #717171;
	border-bottom: 1px solid #e0e4e8;
}
</style>




</head>
<body>
	<nav class="navbar navbar-expand d-flex flex-column align-item-start"
		id="sidebar" style="background: #5372F0; color: #fff;">
		<a href="#" class="navbar-brand text-light mt-5">
			<div class="display-5 font-weight-bold">ADMIN</div>
		</a>
		<ul class="navbar-nav d-flex flex-column mt-5 w-100">
			<li class="nav-item w-100"><a href="adminDashboard.jsp"
				class="nav-link text-light pl-4">Admin Dashboard</a></li>
			<li class="nav-item w-100"><a
				href="<%=request.getContextPath()%>/list"
				class="nav-link text-light pl-4">Manage Tutor </a></li>
			<li class="nav-item w-100"><a
				href="<%=request.getContextPath()%>/list1"
				class="nav-link text-light pl-4">Manage Student </a></li>

			<li class="nav-item w-100"><a href="approveRequestDashboard.jsp"
				class="nav-link text-light pl-4">Approve Request Dashboard </a></li>


			<li><a class="dropdown-item" href="logout" style="color: #fff;">Logout</a></li>
		</ul>
	</nav>
	<section class="p-4 my-container">
		<div class="header">
			<div class="container-fluid" style="max-height: 35px">
				<h3>Manage Tutor</h3>
			</div>

			<button class="btn my-4" id="menu-btn"
				style="background: #5372F0; color: #fff;"><-</button>



			<div class="row">
				<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

				<div class="container">
					<h3 class="text-center" style="color: #5372F0;">List of
						Contents</h3>

					<hr>

					<br>
					<table id="example" class="table table-striped" style="width: 100%">
						<thead>
							<tr>
								<th>Subject Name</th>
								<th>Training Name</th>
								<th>Content</th>
								<th>Uploaded on</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${listContent}">
								<tr>
									<td><c:out value="${list.subjectName}"></c:out></td>
									<td><c:out value="${list.trainingName}"></c:out></td>
									<td><c:out value="${list.contents}"></c:out></td>
									<td><c:out value="${list.createdOn}"></c:out></td>

								</tr>
							</c:forEach>

						</tbody>

					</table>
				</div>
			</div>
	</section>



</body>
<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
 </script>

<script>
 var menu_btn = document.querySelector("#menu-btn")
 var sidebar = document.querySelector("#sidebar")
 var container = document.querySelector(".my-container")
 menu_btn.addEventListener("click", () => {
     sidebar.classList.toggle("active-nav")
     container.classList.toggle("active-cont")
 });
 </script>


<!-- <script src="js/sidebar.js"></script> -->
</html>