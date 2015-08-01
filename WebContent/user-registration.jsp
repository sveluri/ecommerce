<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="table.css">
<link rel="stylesheet" type="text/css" href="registration.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce : User Registration</title>
</head>
<body>
	<br />
	<br />

	<hr />
	<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
	%><div class="loginfail">
		<%
			out.print(message);
		%>
	</div>
	<%
		}
	%>
	<br />
	<br />
	<div id="container">
		<a href="/ecommerce/index.jsp">Home</a>
		<form id="registration" action="/ecommerce/registration" method="POST">
			<h1>Registration</h1>
			<div class="line">
				<label for="username">Username *: </label><input type="text"
					id="username" name="username" />
			</div>
			<div class="line">
				<label for="password">Password *: </label><input type="password"
					id="password" name="password" />
			</div>
			<div class="line">
				<label for="confirmPassowd">Confirm Password *: </label> <input
					type="password" id="cpwd" name="cpwd" />
			</div>
			<div class="line">
				<label for="dob">Date of Birth *: </label><input type="date"
					id="dob" name="dob" />
			</div>
			<div class="line">
				<label for="email">Email *: </label><input type="email" id="email"
					name="email" />
			</div>

			<div class="line">
				<label for="tel">Telephone: </label><input type="text" id="tel" />
			</div>
			<div class="line">
				<label for="add">Address *: </label><input type="text" id="add" />
			</div>
			<div class="line">
				<label for="ptc">Post Code *: </label><input type="text" id="ptc" />
			</div>

			<div class="line submit">
				<input type="submit" value="Submit" />
			</div>

			<p>Note: Please make sure your details are correct before
				submitting form and that all fields marked with * are completed!.</p>
		</form>
	</div>
</body>
</html>