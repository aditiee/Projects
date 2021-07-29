<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.grp10.model.StudentMapping"%>

<% 	List<StudentMapping> tutorList = (ArrayList<StudentMapping>)request.getAttribute("tutorList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="views/css/student.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<nav class="navbar navbar-expand-lg sticky-top" style="background: #5372F0;color:#fff;">
  <div class="container-fluid">
   

    <div class="collapse navbar-collapse" style="margin-left:180px" id="navbarColor02" >
       <form  action="tutorByTechnoName"  method="post" class="d-flex ">
        <input class="form-control me-sm-2 " style="width:20rem"  type="text" placeholder="Search...." name="subjectName">
        <input type="submit"   class="btn my-2 my-sm-0" style="background: #5372F0;color:#fff;" value="Search">
      </form>
   
    </div>
  </div>
   		<div class="dropdown" style="margin-right:90px">
  <button class="btn fas fa-user-circle fa-2x dropdown-toggle" style="color:#fff" type="button" id="dropdownMenuButton2" data-bs-toggle="dropdown" aria-expanded="false">

  </button>
  <ul class="dropdown-menu dropdown-menu-light" aria-labelledby="dropdownMenuButton2">
    <li><a class="dropdown-item " href="#">Profile</a></li>
    <li><a class="dropdown-item" href="#">Subscription</a></li>
    <li><a class="dropdown-item" href="#"></a></li>
    <li><hr class="dropdown-divider"></li>
    <li><a class="dropdown-item" href="logout">Logout</a></li>
  </ul>
</div>	
</nav>




	<div class="container text-center my-3  bg-light" style="margin-top:100px; height: 100%">

		<div class="row mx-auto my-auto">
		
					<%
						for(StudentMapping tutors : tutorList) {
					%>
						<div class="col-md-3" id="1">
					
							<div class="card card-body">
								<img class="img-fluid" src="1.jpg" />
								<div class="card-body">
									
									
									<p class="card-text">
										<strong style="font-size:15px"><%=tutors.getTrainingName()%></strong></p>
										<p class="card-text">
										<strong style="font-size:10px"><i>by <%=tutors.getFirstName()%></i>
										<%=tutors.getLastName()%></strong></p>
										<p style="text-align:left"><%=tutors.getDescription() %></p>
										
									<p class="card-text" style="text-align:right;font-size:10px">
									<strong >created on : </strong> <%=tutors.getCreatedOn()%></p>
									<a href="studentrequest?trainingInfoId=<%=tutors.getTraining_info_id()%>" class="btn" style="background: #5372F0;color:#fff;">Get
										Started</a>
										
								</div>
							</div>
						
						</div>
					
					
					<%
						}
					%>
</div>



			
					
				<a class="carousel-control-prev w-auto" href="#recipeCarousel"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon bg-dark border border-dark rounded-circle"
					aria-hidden="true"></span> <span class="sr-only">Previous</span>
				</a> <a class="carousel-control-next w-auto" href="#recipeCarousel"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon bg-dark border border-dark rounded-circle"
					aria-hidden="true"></span> <span class="sr-only">Next</span>
				</a>
		
	</div>




	<footer id="sticky-footer" class="py-4 text-white-50 fixed-bottom"
		style="background: #5372F0; color: #fff;">
		<div class="container text-center">
			<small>Copyright &copy; Your Website</small>
		</div>
	</footer>







</body>
<script >/**
 * 
 */
$('#recipeCarousel').carousel({
    interval: 10000
  })
  
  $('.carousel .carousel-item').each(function(){
      var minPerSlide = 3;
      var next = $(this).next();
      if (!next.length) {
      next = $(this).siblings(':first');
      }
      next.children(':first-child').clone().appendTo($(this));
      
      for (var i=0;i<minPerSlide;i++) {
          next=next.next();
          if (!next.length) {
              next = $(this).siblings(':first');
            }
          
          next.children(':first-child').clone().appendTo($(this));
        }
  });
  </script>
</html>