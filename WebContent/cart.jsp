<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="search-response.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
</head>
<body>



	<br />
	<br />
	<br />
	<div class="CSSTableGenerator">
		<table id="cartTable">
			<tr>

				<td>Product Name</td>
				<td>Quantity</td>
				
			</tr>
			<c:forEach items="${carts}" var="cart">

				<tr>
					<td name="cart"><c:out value="${cart.name}" /></td>
					<td></td>
				</tr>

			</c:forEach>
		</table>
	</div>

	<br />

</body>
</html>