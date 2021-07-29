<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="views/Bootstrap/common_css_js.jsp" %>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap5.min.css" >
	<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>   
	<script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap5.min.js"></script>
	
	
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
    background-color:#708090;
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
    background-color:#708090;
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
    <nav class="navbar navbar-expand d-flex flex-column align-item-start" id="sidebar">
        <a href="#" class="navbar-brand text-light mt-5">
            <div class="display-5 font-weight-bold">TUTOR</div>
        </a>
        <ul class="navbar-nav d-flex flex-column mt-5 w-100">
            <li class="nav-item w-100">
                <a href="tutorDashboard.jsp" class="nav-link text-light pl-4">Tutor Dashboard</a>
            </li>
            <li class="nav-item w-100">
                <a href="<%=request.getContextPath()%>/listContent" class="nav-link text-light pl-4">Content Materials </a>
            </li>
            <li class="nav-item w-100">
                <a href="<%=request.getContextPath()%>/requests" class="nav-link text-light pl-4">Student Approvals </a>
            </li>
           <li class="nav-item w-100">
                <a href="<%=request.getContextPath()%>/listStudent" class="nav-link text-light pl-4">Student List</a>
            </li>
         <li><a class="dropdown-item" href="logout">Logout</a></li>
        
        </ul>
    </nav>
    <section class="p-4 my-container">
     	 <div class="header" ><div class="container-fluid" style="max-height: 35px">
			<h3>Manage Students</h3></div> 
     	  
        <button class="btn my-4" id="menu-btn">Toggle Sidebar</button>
        
       

	<div class="row">
		
		<div class="container" style="margin-top:20px">
			<h3 class="text-center">List of Students</h3>
			
			<div class="container text-left">

				
			</div>
			<br>
	
		<table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
               			<th>Student Id</th>
						<th>Student Name</th>
						<th>Contact Number</th>
						<th>Email Id</th>
					
            </tr>
        </thead>
        <tbody>
           <c:forEach var="users" items="${listStudent}">

						<tr>
							<td><c:out value="${users.userId}" /></td>
							<td><c:out value="${users.firstName}" /></td>
							<td><c:out value="${users.mobile}" /></td>
							<td><c:out value="${users.email}" /></td>	
						</tr>
			</c:forEach>
			
			<!-- <tr>
							<td>1</td>
							<td>Garrett Winters</td>
							<td>8308358559</td>
							<td>jack@gmail.com</td>
							
						</tr>
					
           <tr>
                			<td>2</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
                <td>3</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>jeel@gmail.com</td>
            </tr>
            <tr>
              <td>4</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
                <td>5</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>
            </tr>
            <tr>
               <td>6</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>
            </tr>
            <tr>
                <td>7</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>
            </tr>
            <tr>
                <td>8</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
                <td>9</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
               <td>10</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
               <td>11</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
               <td>12</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
                <td>13</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
                <td>14</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

            </tr>
            <tr>
               <td>15</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>john@gmail.com</td>

</tr>
            <tr>
                <td>16</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>17</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>18</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>19</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
              <td>20</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>21</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>22</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>23</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>24</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>25</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>26</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>27</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>28</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>29</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>30</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>31</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
           
            <tr>
                <td>32</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>33</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>
            </tr>
            <tr>
               <td>34</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>
            </tr>
            <tr>
                <td>35</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>
            </tr>
            <tr>
                <td>36</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>37</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>38</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>39</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>40</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
              <td>41</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>42</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>43</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
               <td>44</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>
            <tr>
                <td>45</td>
							<td>Ashton Cox</td>
							<td>8308358559</td>
							<td>Email Id</td>

            </tr>-->	
         
			
			
			
			
			
			
			
		</tbody>
        <!-- </tfoot> -->
    </table>
			
	
		</div>
	</div>

	
        
       
    </section>
    <!-- bootstrap js 
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/js/bootstrap.min.js" integrity="sha384-5h4UG+6GOuV9qXh6HqOLwZMY4mnLPraeTrjT5v07o347pj6IkfuoASuGBhfDsp3d" crossorigin="anonymous"></script>
    <!-- custom js -->
 
    
</body>
   <script >
    $(document).ready(function() {
    $('#example').DataTable();
} );
 </script>
 
 <script >
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