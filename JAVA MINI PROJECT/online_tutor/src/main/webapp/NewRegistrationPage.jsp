<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <title></title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</head>
<style>
form .form-control input:focus{
border-color: #5372F0;
}
form input[type="password"]{
margin-left:24px;
width:90%;
display:inline-block;
}
form input[type="text"]{
margin-left:24px;
width:90%;
display:inline-block;
}
form input[type="submit"]{
    margin-bottom:15px;
    margin-left:25px;
    border: none;
    background: #5372F0;
    cursor: pointer;
    border-bottom: 2px solid rgba(0,0,0,0.1);
    transition: all 0.3s ease;
    color:#fff;
  }
  form input[type="submit"]:hover{
    background: #2c52ed;
  }
body{
background-color: #5372F0;
}
    label[id*='custom']::after
    {
        content:"*";
        color:red;
    }
    label[id*='custom']
    {
    margin-left:25px;
    }
    </style>
<body>
 <div class="container"><br>
  <div class="col-lg-6 m-auto d-block" style="margin-bottom:120px;">
   <form action="<%=request.getContextPath()%>/register"   method="post" onsubmit="return validation()" class="bg-light">
    <div class="form-group">
        <h3 style="margin-left: 100px;">SignUp </h3><hr>
     <label for="fname" class="font-weight-bold" id="custom"> First Name: </label>
     <input type="text" name="FirstName" class="form-control" id="fname" autocomplete="off" required><br>
     <span id="firstname" class="text-danger font-weight-bold"> </span>
    </div>
    <div class="form-group">
        <label for="mname" class="font-weight-bold" style="margin-left:24px" > Middle Name: </label>
        <input type="text" name="MiddleName" class="form-control" id="mname" autocomplete="off">
        <span id="middlename" class="text-danger font-weight-bold"> </span>
       </div>
       <div class="form-group" >
        <label for="lname" class="font-weight-bold" id="custom"> Last Name: </label>
        <input type="text" name="LastName" class="form-control" id="lname" autocomplete="off"required>
        <span id="lastname" class="text-danger font-weight-bold"> </span>
       </div>
    <div class="form-group">
     <label class="font-weight-bold" id="custom"> Password: </label>
     <input type="password" name="password" class="form-control" id="pass" autocomplete="off"required>
     <span id="passwords" class="text-danger font-weight-bold"> </span>
    </div>
    <div class="form-group">
     <label class="font-weight-bold" id="custom"> Confirm Password: </label>
     <input type="password" name="conpass" class="form-control" id="conpass" autocomplete="off"required>
     <span id="confrmpass" class="text-danger font-weight-bold"> </span>
    </div>
    <div class="form-group">
     <label class="font-weight-bold" id="custom"> Mobile Number: </label>
     <input type="text" name="mobileNo" class="form-control" id="mobileNumber" autocomplete="off"required>
     <span id="mobileno" class="text-danger font-weight-bold"> </span>
    </div>
    <div class="form-group">
     <label class="font-weight-bold" id="custom"> Email: </label>
     <input type="text" name="email" class="form-control" id="emails" autocomplete="off"required>
     <span id="emailids" class="text-danger font-weight-bold"> </span>
    </div>

    <div class="form-group">
   <label class="font-weight-bold" id="custom"> Role:</label> <select
							id="roles" name="role" class="form-control">
							<option selected>Please select your role...</option>
							<option value="2">Tutor</option>
							<option value="3">Student</option>
						</select>

  </div>

    <input type="submit" name="submit" value="submit" class="btn"  autocomplete="off"required>
   </form><br><br>
  </div>
 </div>
 <script type="text/javascript">
  function validation(){
   var fname = document.getElementById('fname').value;
   var lname=document.getElementById('lname').value;
   var pass = document.getElementById('pass').value;
   var confirmpass = document.getElementById('conpass').value;
   var mobileNumber = document.getElementById('mobileNumber').value;
   var emails = document.getElementById('emails').value;
   if(fname == "" ){
    document.getElementById('firstname').innerHTML =" ** Please fill the FirstName  field";
    return false;
   }
   if(lname == "" ){
    document.getElementById('lastname').innerHTML =" ** Please fill the LastName field";
    return false;
   }
   if((fname.length <= 2) || (fname.length > 20)) {
    document.getElementById('firstname').innerHTML =" ** First Name lenght must be between 2 and 20";
    return false; 
   }

   if((lname.length <= 2) || (lname.length > 20)) {
    document.getElementById('lastname').innerHTML =" ** Middle Name lenght must be between 2 and 20";
    return false; 
   }
   if(!isNaN(fname)){
    document.getElementById('firstname').innerHTML =" ** only characters are allowed";
    return false;
   }
   if(!isNaN(lname)){
    document.getElementById('lastname').innerHTML =" ** only characters are allowed";
    return false;
   }
   if(pass == ""){
    document.getElementById('passwords').innerHTML =" ** Please fill the password field";
    return false;
   }
   if((pass.length <= 5) || (pass.length > 20)) {
    document.getElementById('passwords').innerHTML =" ** Passwords lenght must be between  5 and 20";
    return false; 
   }
   if(pass!=confirmpass){
    document.getElementById('confrmpass').innerHTML =" ** Password does not match the confirm password";
    return false;
   }
   if(confirmpass == ""){
    document.getElementById('confrmpass').innerHTML =" ** Please fill the confirmpassword field";
    return false;
   }
   if(mobileNumber == ""){
    document.getElementById('mobileno').innerHTML =" ** Please fill the mobile NUmber field";
    return false;
   }
   if(isNaN(mobileNumber)){
    document.getElementById('mobileno').innerHTML =" ** user must write digits only not characters";
    return false;
   }
   if(mobileNumber.length!=10){
    document.getElementById('mobileno').innerHTML =" ** Mobile Number must be 10 digits only";
    return false;
   }
if(emails == ""){
    document.getElementById('emailids').innerHTML =" ** Please fill the email id field";
    return false;
   }
   if(emails.indexOf('@') <= 0 ){
    document.getElementById('emailids').innerHTML =" ** @ Invalid Position";
    return false;
   }
   if((emails.charAt(emails.length-4)!='.') && (emails.charAt(emails.length-3)!='.')){
    document.getElementById('emailids').innerHTML =" ** . Invalid Position";
    return false;
   }
}
  
 </script>
</body>
</html>
    