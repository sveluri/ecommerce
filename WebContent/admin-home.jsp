<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Ecommerce</title>
</head>
<body>
	<div>
		<div class="welcomeText">
			Welcome :
			<%
			out.println(request.getAttribute("username"));
		%>
		</div>
		<div class="logout">
			<a href="/ecommerce/logout.jsp">Logout</a>
		</div>
	</div>
	<hr />
</body>
</html>