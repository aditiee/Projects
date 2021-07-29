<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8"> 
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap 5 Side Bar Navigation</title>
<!-- bootstrap 5 css 
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
     custom css 
<link rel="stylesheet" href="css/style.css">-->
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
.nav-link:active,
.nav-link:focus,
.nav-link:hover {
    background-color: #ffffff26;
}
.dropdown-menu {
    background-color: #7952b3;
}
.dropdown-item:active,
.dropdown-item:focus,
.dropdown-item:hover {
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
 .header{
  padding: 20px;
  background: #fff;
  color: #717171;
  border-bottom: 1px solid #e0e4e8;
}




</style>	
	
	
	
	
</head>
<body>
	<nav class="navbar navbar-expand d-flex flex-column align-item-start"
		id="sidebar"  style="background: #5372F0; color: #fff;">
		<a href="#" class="navbar-brand text-light mt-5">
			<div class="display-5 font-weight-bold">ADMIN</div>
		</a>
		<ul class="navbar-nav d-flex flex-column mt-5 w-100">
			<li class="nav-item w-100"><a href="adminDashboard.jsp"
				class="nav-link text-light pl-4">Admin Dashboard</a></li>
			<li class="nav-item w-100"><a href="<%=request.getContextPath()%>/list"
				class="nav-link text-light pl-4">Manage Tutor </a></li>
	  	<li class="nav-item w-100"><a href="managestudent.jsp"
				class="nav-link text-light pl-4">Manage Student </a></li>
			<li class="nav-item w-100"><a href="approveRequestDashboard.jsp"
				class="nav-link text-light pl-4">Approve Request Dashboard </a></li>


		<li><a class="dropdown-item" href="logout" style="color: #fff;">Logout</a></li>
		</ul>
	</nav> 
	
 	<section class="p-4 my-container">
		<div class="header">
			<div class="container-fluid" style="max-height: 10px">
				<h3>Approve Student</h3>
				
				
		
			</div>
			</div>
			  <button class="btn my-4" id="menu-btn"  style="background: #5372F0; color: #fff;"> <-</button>



			<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container"style="margin-top: 20px">
			<h3 class="text-center"><a href = "<%=request.getContextPath()%>/student">Approval List of Student</a></h3>
			
			
			<div class="container text-left"></div>
			<br>
		<table  id="example" class="table table-bordered" style="width: 100%" >
				<thead>
					<tr>
						<th>Student ID</th>
						<th>Student Name</th>
						<th>Contact</th>
						<th>Email</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="user" items="${listUser}">

						<tr>
							<td><c:out value="${user.id}" /></td>
							<td><c:out value="${user.firstName}" /></td>
							<td><c:out value="${user.mobile}" /></td>
							<td><c:out value="${user.email}" /></td>
							<td>
						  	<a href="updatestudent?id=<c:out value='${user.id}' />">Approve</a>
								 
							  <a href="deletestudent?id=<c:out value='${user.id}' />">Reject</a>
								</td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
	</section> 
	<!-- bootstrap js -->
	
</body>
<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.min.js"
		integrity="sha384-5h4UG+6GOuV9qXh6HqOLwZMY4mnLPraeTrjT5v07o347pj6IkfuoASuGBhfDsp3d"
		crossorigin="anonymous"></script>
	<!-- custom js -->
	
	<script >
	
	  var menu_btn = document.querySelector("#menu-btn")
      var sidebar = document.querySelector("#sidebar")
      var container = document.querySelector(".my-container")
      menu_btn.addEventListener("click", () => {
          sidebar.classList.toggle("active-nav")
          container.classList.toggle("active-cont")
      });



	
	</script>

<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
 </script>
</html>