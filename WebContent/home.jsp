<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <script src="/jquery-2.1.4.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="table.css">
<link rel="stylesheet" type="text/css" href="registration.css">
	<link rel="stylesheet" type="text/css" href="header.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
	$(document).ready(function() {
		$("#pagebody").load("./homebody.jsp");
		$("#search").click(function() {
			$("#pagebody").load("./search.jsp");
		});
		$("#home").click(function() {
			$("#pagebody").load("./homebody.jsp");
		});
		$("#cart").click(function() {
			$("#pagebody").load("./cart.jsp");
		});
	});
</script>
<title>Ecommerce</title>
</head>
<body>
	<ul>
		<li>Welcome : <%
			out.println(request.getAttribute("username"));
		%>
		</li>
	</ul>
	<hr />
	
	<div id="header">
		<a href="#" id="home">Home</a>
		<a href="#" id="search">Search</a>
		<a href="#" id="cart">Cart</a>
		<a href="#" id="contact">Contact</a>
		<a href="/ecommerce/logout.jsp" id="logout">Logout</a>
	</div>
	<br />
<hr />
	<div id="pagebody"></div>
<body>
</html>