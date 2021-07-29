<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="form-signup text-center">
		<form action="addtutor" class="was-validated">
			<h1 class="h3 mb-3 fw-normal">Tutor Register</h1>
			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="Enter Name" name="name" required> <label
					for="name">Name</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="email" class="form-control" id="floatingInput"
					placeholder="name@example.com" name="email" required> <label
					for="email">Email address</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="password" class="form-control" id="floatingPassword"
					placeholder="Password" name="psw" required> <label
					for="psw">Password</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="number" class="form-control" id="floatingInput"
					placeholder="Enter Experience" name="experience" required>
				<label for="experience">Experience</label>
			</div>
			<br>
			<div class="form-floating">
				<input type="text" class="form-control" id="floatingInput"
					placeholder="Enter Specialization" name="specialization" required>
				<label for="specialization">Specialization</label>
			</div>
			<br>
			<div class="form-floating">
				<select class="form-select" aria-label="Default select example"
					name="gender" id="gender" required>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select> <label for="gender">Gender</label>
			</div>
			<br>
			<button class="w-100 btn btn-lg btn-primary signupbtn" type="submit">Sign
				Up</button>
		</form>
	</div>

</body>
</html>