<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="views/Bootstrap/common_css_js.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="views/css/login.css">
<script src="views/js/registration.js"></script>
</head>
<style>
label[id*='custom']::after {
	content: "*";
	color: red;
}

@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

body {
	width: 100%;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	background: #5372F0;
}

::selection {
	color: #fff;
	background: #5372F0;
}

.wrapper {
	width: auto;
	padding: 40px 30px 50px 30px;
	background: #fff;
	border-radius: 5px;
	text-align: center;
	box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.1);
}

.wrapper header {
	font-size: 35px;
	font-weight: 600;
}

.wrapper form {
	margin: 40px 0;
}

form .field {
	width: 100%;
	margin-bottom: 20px;
}

form .field.shake {
	animation: shake 0.3s ease-in-out;
}

@
keyframes shake { 0%, 100%{
	margin-left: 0px;
}

20%,
80%{
margin-left
:
 
-12
px
;

  
}
40%,
60%{
margin-left
:
 
12
px
;

  
}
}
form .field .input-area {
	height: 50px;
	width: 100%;
	position: relative;
}

form input {
	width: 100%;
	height: 100%;
	outline: none;
	padding: 0 45px;
	font-size: 18px;
	background: none;
	caret-color: #5372F0;
	border-radius: 5px;
	border: 1px solid #bfbfbf;
	border-bottom-width: 2px;
	transition: all 0.2s ease;
}

form .field input:focus, form .field.valid input {
	border-color: #5372F0;
}

form .field.shake input, form .field.error input {
	border-color: #dc3545;
}

.field .input-area i {
	position: absolute;
	top: 50%;
	font-size: 18px;
	pointer-events: none;
	transform: translateY(-50%);
}

.input-area .icon {
	left: 15px;
	color: #bfbfbf;
	transition: color 0.2s ease;
}

.input-area .error-icon {
	right: 15px;
	color: #dc3545;
}

form input:focus ~ .icon, form .field.valid .icon {
	color: #5372F0;
}

form .field.shake input:focus ~ .icon, form .field.error input:focus ~
	.icon {
	color: #bfbfbf;
}

form input::placeholder {
	color: #bfbfbf;
	font-size: 17px;
}

form .field .error-txt {
	color: #dc3545;
	text-align: left;
	margin-top: 5px;
}

form .field .error {
	display: none;
}

form .field.shake .error, form .field.error .error {
	display: block;
}

form .pass-txt {
	text-align: left;
	margin-top: -10px;
}

.wrapper a {
	color: #5372F0;
	text-decoration: none;
}

.wrapper a:hover {
	text-decoration: underline;
}

form input[type="submit"] {
	height: 50px;
	margin-top: 30px;
	color: #fff;
	padding: 0;
	border: none;
	background: #5372F0;
	cursor: pointer;
	border-bottom: 2px solid rgba(0, 0, 0, 0.1);
	transition: all 0.3s ease;
}

form input[type="submit"]:hover {
	background: #2c52ed;
}
</style>

<body>
	<div class="wrapper">
		<header>Registration Form</header>
		<form action="<%=request.getContextPath()%>/register" method="post"
			onsubmit="return validation()">
			<div class="row">
				<div class="col">
					<div class="field email">

						<div class="input-area">
							<label for="fname" class="font-weight-bold" id="custom">
								First Name: </label> <input type="text" name="FirstName"
								class="form-control" placeholder="Enter your Firstname"
								id="fname" autocomplete="off" required>
						</div>
						<span id="firstname" class="text-danger font-weight-bold">
						</span>
					</div>
				</div>
				<div class="col">
					<div class="field email">
						<label for="mname" class="font-weight-bold"> Middle Name:
						</label>
						<div class="input-area">
							<input type="text" name="MiddleName" class="form-control"
								placeholder="Enter your middlename" id="mname"
								autocomplete="off">
						</div>
						<span id="middlename" class="text-danger font-weight-bold">
						</span>
					</div>
				</div>
				<div class="col">
					<div class="field email">
						<label for="lname" class="font-weight-bold" id="custom">
							Last Name: </label>
						<div class="input-area">
							<input type="text" name="LastName" class="form-control"
								id="lname" placeholder="Enter your lastname" autocomplete="off"
								required>
						</div>
						<span id="lastname" class="text-danger font-weight-bold"> </span>
					</div>
				</div>
			</div>
			<div class="row">

				<div class="col-7">
					<div class="field email">
						<label class="font-weight-bold" id="custom"> Email: </label>
						<div class="input-area">
							<input type="text" name="email" class="form-control" id="emails"
								placeholder="Enter Email address" autocomplete="off" required>
						</div>
						<span id="emailids" class="text-danger font-weight-bold"> </span>
					</div>
				</div>
				<div class="col">
					<div class="field email">
						<label class="font-weight-bold" id="custom"> Mobile
							Number: </label>
						<div class="input-area">
							<input type="text" name="mobileNo" class="form-control"
								id="mobileNumber" placeholder="Enter Mobile number"
								autocomplete="off" required>
						</div>
						<span id="mobileno" class="text-danger font-weight-bold"> </span>
					</div>
				</div>

			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">

						<label class="font-weight-bold" id="custom"> Role:</label> <select
							id="roles" name="role" class="form-control">
							<option selected>Please select your role...</option>
							<option value="2">Tutor</option>
							<option value="3">Student</option>
						</select>

					</div>
				</div>
				<div class="col-4">

					<div class="field password">
						<div class="input-area">
							<label class="font-weight-bold" id="custom"> Password: </label> <input
								class="form-control" type="password" id="conpass"
								placeholder="password" name="password" autocomplete="off"
								required>
						</div>
						<span id="passwords" class="text-danger font-weight-bold">
						</span>
					</div>
				</div>
				<div class="col-4">

					<div class="field password">
						<div class="input-area">
							<label class="font-weight-bold" id="custom"> Confirm
								Password: </label> <input type="password" placeholder="confirm Password"
								id="password" placeholder="Confirm Password" autocomplete="off"
								required>
						</div>
						<span id="confrmpass" class="text-danger font-weight-bold">
						</span>
					</div>
				</div>
			</div>
			<div
				class="row d-flex align-items-center justify-content-centerd-flex align-items-center justify-content-center">
				<div class="col-3 ">
					<input type="submit" value="Register now" />
				</div>
			</div>
		</form>
		<div class="sign-txt">
			Already have an account? <a href="login.jsp">SignIn now</a>
		</div>
	</div>

</body>
<script type="text/javascript">
	function validation() {
		var fname = document.getElementById('fname').value;
		var lname = document.getElementById('lname').value;
		var pass = document.getElementById('pass').value;
		var confirmpass = document.getElementById('conpass').value;
		var mobileNumber = document.getElementById('mobileNumber').value;
		var emails = document.getElementById('emails').value;
		var roles = document.getElementById('roles').value;
		if (fname == "") {
			document.getElementById('firstname').innerHTML = " ** Please fill the FirstName  field";
			return false;
		}
		if (lname == "") {
			document.getElementById('lastname').innerHTML = " ** Please fill the LastName field";
			return false;
		}
		if ((fname.length <= 2) || (fname.length > 20)) {
			document.getElementById('firstname').innerHTML = " ** First Name lenght must be between 2 and 20";
			return false;
		}

		if ((lname.length <= 2) || (lname.length > 20)) {
			document.getElementById('lastname').innerHTML = " ** Middle Name lenght must be between 2 and 20";
			return false;
		}
		if (!isNaN(fname)) {
			document.getElementById('firstname').innerHTML = " ** only characters are allowed";
			return false;
		}
		if (!isNaN(lname)) {
			document.getElementById('lastname').innerHTML = " ** only characters are allowed";
			return false;
		}
		if (pass == "") {
			document.getElementById('passwords').innerHTML = " ** Please fill the password field";
			return false;
		}
		if ((pass.length <= 5) || (pass.length > 20)) {
			document.getElementById('passwords').innerHTML = " ** Passwords lenght must be between  5 and 20";
			return false;
		}
		if (pass != confirmpass) {
			document.getElementById('confrmpass').innerHTML = " ** Password does not match the confirm password";
			return false;
		}
		if (confirmpass == "") {
			document.getElementById('confrmpass').innerHTML = " ** Please fill the confirmpassword field";
			return false;
		}
		if (mobileNumber == "") {
			document.getElementById('mobileno').innerHTML = " ** Please fill the mobile NUmber field";
			return false;
		}
		if (isNaN(mobileNumber)) {
			document.getElementById('mobileno').innerHTML = " ** user must write digits only not characters";
			return false;
		}
		if (mobileNumber.length != 10) {
			document.getElementById('mobileno').innerHTML = " ** Mobile Number must be 10 digits only";
			return false;
		}
		if (emails == "") {
			document.getElementById('emailids').innerHTML = " ** Please fill the email id field";
			return false;
		}
		if (emails.indexOf('@') <= 0) {
			document.getElementById('emailids').innerHTML = " ** @ Invalid Position";
			return false;
		}
		if ((emails.charAt(emails.length - 4) != '.')
				&& (emails.charAt(emails.length - 3) != '.')) {
			document.getElementById('emailids').innerHTML = " ** . Invalid Position";
			return false;
		}
		if (roles == "")
			document.getElementById('firstname').innerHTML = " ** Please fill the FirstName  field";
		return false;
	}
</script>
</html>
