<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
            <%@include file="views/Bootstrap/common_css_js.jsp" %>
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link href="views/css/contents.css" rel="stylesheet">
    <link rel="stylesheet" 
 href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style type="text/css">
    
    @media (min-width: 576px) {
    .h-sm-100 {
        height: 100%;
    }
}

.col
{
    background-color: linen;
}
    
    </style>
</head>
<body>
 <div class="container-fluid overflow-hidden">
    <div class="row vh-100 overflow-auto">
        <div class="col-12 col-sm-3 col-xl-2 px-sm-2 px-0 bg-dark d-flex sticky-top">
            <div class="d-flex flex-sm-column flex-row flex-grow-1 align-items-center align-items-sm-start px-3 pt-2 text-white">
                <a href="/" class="d-flex align-items-center pb-sm-3 mb-md-0 me-md-auto text-white text-decoration-none">
                    <span class="fs-5">Tutor</span>
                </a>
                <ul class="nav nav-pills flex-sm-column flex-row flex-nowrap flex-shrink-1 flex-sm-grow-0 flex-grow-1 mb-sm-auto mb-0 justify-content-center align-items-center align-items-sm-start" id="menu">
                    <li class="nav-item">
                        <a href="tutorDashboard.jsp" class="nav-link px-sm-0 px-2">
                            <em class="fs-5 bi-house"></em><span class="ms-1 d-none d-sm-inline">MyDashboard</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/list" class="nav-link px-sm-0 px-2">
                            <em class="fs-5 bi-house"></em><span class="ms-1 d-none d-sm-inline">My Contents</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="uploadcontents.jsp" class="nav-link px-sm-0 px-2">
                            <em class="fs-5 bi-house"></em><span class="ms-1 d-none d-sm-inline">Upload Contents</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/requests" class="nav-link px-sm-0 px-2">
                            <em class="fs-5 bi-house"></em><span class="ms-1 d-none d-sm-inline">Approve Students</span>
                        </a>
                    </li>
                      <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/listStudent" class="nav-link px-sm-0 px-2">
                            <em class="fs-5 bi-house"></em><span class="ms-1 d-none d-sm-inline">My Students</span>
                        </a>
                    </li>
                    
                </ul>
                <div class="dropdown py-sm-4 mt-sm-auto ms-auto ms-sm-0 flex-shrink-1">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                      <i class="fa fa-user" aria-hidden="true"></i>
                        <span class="d-none d-sm-inline mx-1">User</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                        <li><a class="dropdown-item" href="tutorDashboard.jsp">MyDashboard</a></li>
                        <li><a class="dropdown-item" href="#">Students</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/requests">Approve students</a></li>
                        <li><a class="dropdown-item" href="uploadcontents.jsp">Upload Content</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listStudent">My Contents</a></li>
                        <li><a class="dropdown-item" href="logout">Sign out</a></li>
                        
                    </ul>
                </div>
            </div>
        </div>
        <div class="col d-flex flex-column h-sm-100">
            <main class="row overflow-auto">
                <div class="col pt-4">
              <table id="example" class="table table-striped" style="width:100%">
        <thead>
            <tr>
                <th>StudentId</th>
                <th>Student Name</th>
                <th>email</th>
                <th>Action</th>
                
            </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${listContent}">
                <tr>
                    <td><c:out value="${user.userId}"></c:out></td>
                    <td><c:out value="${user.firstName}" ></c:out>
                    <c:out value="${user.lastName}" ></c:out>
                    </td>
                    <td><c:out value="${user.email}"></c:out></td>
                    
                    <td><a href="approve?userId=<c:out value='${user.userId}' />"><i class="material-icons" title="">done</i></a>&nbsp  
                    <a href="reject?userId=<c:out value='${user.userId}' />"><i class="material-icons" title="Delete">&#xE872;</i></a>
                </td>
                </tr>
            </c:forEach>
         
        </tbody>
        
    </table>
    </div>
            </main>
        </div>
    </div>
</div>	

<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>	
<script src="views/js/contents.js"></script>
</body>
</body>
</html>