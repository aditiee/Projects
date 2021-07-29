<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="views/Bootstrap/common_css_js.jsp" %>          
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="views/css/updatecontents.css">
<style type="text/css">
.btn:hover{
    background-color: rgb(23, 194, 194);
    color: black;
    font-size:large;
}
.form-control{
  padding: 10px 10px 10px 10px;
}
.row
{
    padding: 10px 10px 10px 10px;
}
#formcard{
    background-color: lightyellow;
}
label:before{
  content:"*";
  font-weight:bold;
  color: red;
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
                            <i class="fs-5 bi-house"></i><span class="ms-1 d-none d-sm-inline">MyDashboard</span>
                        </a>
                    </li>
                   
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/list" class="nav-link px-sm-0 px-2">
                            <i class="fs-5 bi-house"></i><span class="ms-1 d-none d-sm-inline">My Contents</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/requests" class="nav-link px-sm-0 px-2">
                            <i class="fs-5 bi-house"></i><span class="ms-1 d-none d-sm-inline">Approve Students</span>
                        </a>
                    </li>
                     <li class="nav-item">
                        <a href="uploadcontents.jsp" class="nav-link px-sm-0 px-2">
                            <i class="fs-5 bi-house"></i><span class="ms-1 d-none d-sm-inline">Upload Contents</span>
                        </a>
                    </li>
                     <li class="nav-item">
                        <a href="<%=request.getContextPath()%>/listStudent" class="nav-link px-sm-0 px-2">
                            <i class="fs-5 bi-house"></i><span class="ms-1 d-none d-sm-inline">My Students</span>
                        </a>
                    </li>
                    
                </ul>
                <div class="dropdown py-sm-4 mt-sm-auto ms-auto ms-sm-0 flex-shrink-1">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                      <i class="fa fa-user" aria-hidden="true"></i>
                        <span class="d-none d-sm-inline mx-1">User</span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                        <li><a class="dropdown-item" href="tutordashboard.jsp">MyDashboard</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listStudent" >Students</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/requests">Approve students</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/listContent">Contents</a></li>
                        <li><a class="dropdown-item" href="uploadcontents.jsp">Upload Contents</a></li>
                        <li><a class="dropdown-item" href="<%=request.getContextPath()%>/logout">Sign out</a></li>
                    </ul>
                </div>
            </div>
        </div>
   
        <div class="col d-flex flex-column h-sm-100">
            <main class="row overflow-auto">
                <div class="col pt-4">
                    
    <div class="col-md-6 offset-md-3 mt-5 card card-body border border-dark" id="formcard">
    <h4 class="text-center">
        Update Content
    </h4>
    <hr>
    <form action="upload" method="POST" enctype="multipart/form-data">

        
        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="contentId">
                        Subject Name:
                    </label>
                    <input type="text" name="contentId" class="form-control" required>
                </div>
            </div>
            <div class="col">
                <div class="form-group">
                    <label for="desc">
                       Description:
                    </label>
                    <input type="text" name="desc" class="form-control" required >
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="trainingName">
                        Training name:
                    </label>
                    <input type="text" name="trainingName" class="form-control" required>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col">
                <div class="form-group">
                    <label for="contentType">
                        Content type:
                    </label>
                    <select name="type" id="type" class="form-control">
  <option value="video">Video</option>
  <option value="excel">Excel</option>
  <option value="pdf">PDF</option>
  <option value="doc">DOC</option>
</select>
                </div>
</div>
            </div>
    <div class="row">
        <div class="form-group">
            <label for="productPrice">
                File:
            </label>
            <input type="file" id="files" name="files" multiple><br><br>

        </div>
    </div>

    <div class="row">
        <div class="btn-group float-right">
            <button class="btn btn-outline-dark" type="reset">
                Reset
            </button>
            &nbsp;&nbsp;
            <button class="btn btn-outline-dark" type="submit" value="Upload">
                Upload
            </button>
        </div>
    </div>
    </form>
</div>
        </div>
            </main>
        </div>
    </div>

</div>

</body>
</html>