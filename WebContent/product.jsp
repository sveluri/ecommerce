<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="search-response.css">
<title>Ecommerce</title>
</head>
<body>

<br />
<br />

	<div class="CSSTableGenerator">
		<table id="productsTable">
			<tr>
				<td colspan="2">Product Detail for 
				<c:out value="${product.name}"></c:out>
				</td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td>
				<c:out value="${product.name}"></c:out>
				</td>
			</tr>
			<tr>
				<td>Product Type</td>
				<td>
				<c:out value="${product.productType}"></c:out>
				</td>
			</tr>
			<tr>
				<td>Product Description</td>
				<td>
				<c:out value="${product.productType}"></c:out>
				</td>
			</tr>
			<tr>
				<td>Available Quantity</td>
				<td>
				<c:out value="${product.name}"></c:out>
				</td>
			</tr>
		</table>
	</div>


</body>
</html>