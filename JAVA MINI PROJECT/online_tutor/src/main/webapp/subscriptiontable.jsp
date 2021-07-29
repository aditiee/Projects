<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.StudentMapping"%>
<%@ include file="checkSession.jsp" %>

<%
	List<StudentMapping> subscribeList = (ArrayList<StudentMapping>) request.getAttribute("subscribedList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link
	rel="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css">
<script
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>
	
</head>
<body>
	<div class="row">
		<nav class="navbar navbar-expand-lg sticky-top"
			style="background: #5372F0; color: #fff;">
			<div class="container-fluid">
				<i class="fas fa-chalkboard-teacher fa-2x" style="color: #fff"></i>
			</div>
			<h6 style="">
				<%
					String email = (String) session.getAttribute("email");
					if (email != null)
						out.print(email);
					else
						response.sendRedirect("login.jsp");
				%>
			</h6>
			<div class="dropdown" style="margin-right: 90px">
				<button class="btn fas fa-user-circle fa-2x dropdown-toggle"
					style="color: #fff" type="button" id="dropdownMenuButton2"
					data-bs-toggle="dropdown" aria-expanded="false"></button>
				<ul class="dropdown-menu dropdown-menu-light"
					aria-labelledby="dropdownMenuButton2">
					<li><a class="dropdown-item" href="studenthome">Home</a></li>
					<li><a class="dropdown-item " href="profile?userId=<%=session.getAttribute("studentId")%>">Profile</a></li>
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="logout">Logout</a></li>
				</ul>
			</div>
		</nav>
		<div class="container" style="margin-top: 20px; padding: 20px">
			<h3 class="text-center">Subscription List</h3>
			<table class="table table-bordered" id="example" >
				<thead>
					<tr>
						<th>Sr.No</th>
						<th>Tutor Name</th>
						<th>Technology</th>
						<th>Contents</th>
					</tr>
				</thead>
				<tbody>

					<%
						int i =0;
						for (StudentMapping list : subscribeList) {
							
							i++;
					%>

					<tr>
						<td><%=i %></td>
						<td><%=list.getFirstName()%> <%=list.getLastName()%></td>
						<td><%=list.getTrainingName()%></td>

						<td><a
							href="view?training_info_id=<%=list.getTraining_info_id()%>">View</a>
						</td>


					</tr>
					<%
						}
					%>
				</tbody>

			</table>
		</div>


		<footer id="sticky-footer" class="py-4 text-white-50 fixed-bottom"
			style="background: #5372F0; color: #fff;">
			<div class="container text-center">
				<small>Copyright &copy; Your Website</small>
			</div>
		</footer>


	</div>
	
<script>
    $(document).ready(function() {
    $('#example').DataTable();
} );
 </script>
</body>

</html>