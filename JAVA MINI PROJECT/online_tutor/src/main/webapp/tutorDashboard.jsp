<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="views/Bootstrap/common_css_js.jsp"%>
<!DOCTYPE html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
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


	<header>
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
					
					<li><hr class="dropdown-divider"></li>
					<li><a class="dropdown-item" href="logout"
						style="color: #fff;">Logout</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="container">
		<div class="row mt-5">
			<!-- column1 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body" style="text-align: center">
						<img style="max-width: 80px"
							src="https://image.flaticon.com/icons/png/512/2702/2702069.png"
							alt="materail"> <a href="<%=request.getContextPath()%>/listContents"><h4>content material</h4></a>
					</div>
				</div>
			</div>

			<!-- column2 -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body" style="text-align: center">
						<img style="max-width: 80px"
							src="https://image.flaticon.com/icons/png/512/2752/2752517.png"
							alt="materail"> <a href="<%=request.getContextPath()%>/requests"><h4>Students Approval</h4></a>
					</div>
				</div>
			</div>


			<!-- column2 -->

			<div class="col-md-4">
				<div class="card">
					<div class="card-body" style="text-align: center">
						<img style="max-width: 80px"
							src="https://image.flaticon.com/icons/png/512/4717/4717944.png"
							alt="materail"> <a
							href="<%=request.getContextPath()%>/listStudent"><h4>Students
								List</h4></a>
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