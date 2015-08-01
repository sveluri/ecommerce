<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="table.css">
<link rel="stylesheet" type="text/css" href="registration.css">
<link rel="stylesheet" type="text/css" href="header.css">
<link rel="stylesheet" type="text/css" href="search.css">
<script>
	var update = function() {
		term = $("input[name='searchproduct']").val();
		$.post("search", {
			searchKey : term
		}, function(responseText) {
			$("#results").html(responseText);
		});
	};

	$('#searchproduct').keyup(update);
	$('#searchproduct').change(update);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>

	<!-- <div class="flexsearch">
		<div class="flexsearch--wrapper">
			<form class="flexsearch--form" action="#" method="post">
				<div class="flexsearch--input-wrapper">
					<input class="flexsearch--input" type="search" placeholder="search">
				</div>
				<input class="flexsearch--submit" type="submit" value="&#10140;"/>
			</form>
		</div>
</div>
 -->


	<div class="box">
		<div class="container-1">
			<span class="icon"><i class="fa fa-search"></i></span> <input
				type="search" name="searchproduct" id="searchproduct"
				placeholder="Search..." />
		</div>
	</div>

	<div id="results"></div>
	

</body>
</html>