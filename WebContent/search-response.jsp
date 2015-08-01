<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
<link rel="stylesheet" type="text/css" href="search-response.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#productsTable").on("click", "td[name='productNametd']", function() {
			var temp = $(this).text();

			$.get("product", {
				productName : temp
			}, function(responseText) {
				$("#product").html(responseText);
			});
		});
		$("#productsTable").on("click", "td[name='cartActionAdd']", function() {
			var temp = $("td[name='productNametd']").text();

			alert(temp);
		});

	});
</script>

</head>
<body>

	<br />
	<br />
	<br />
	<div class="CSSTableGenerator">
		<table id="productsTable">
			<tr>

				<td>Product Name - Click on the product for further information
				</td>
				<td>Type</td>
				<td>Price</td>
				<td>Available Quantity</td>
				<td></td>
			</tr>
			<c:forEach items="${searchresults}" var="product">

				<tr>
					<td name="productNametd"><c:out value="${product.name}" /></td>
					<td><c:out value="${product.productType}" /></td>
					<td><c:out value="${product.price}" /> <c:out
							value="${product.priceType}" /></td>
					<td><c:out value="${product.availableQuantity}" /></td>
					<td name="cartActionAdd"><button id="addToCart">Add to cart</button>
							<button name="remove">Remove</button></td>
				</tr>

			</c:forEach>
		</table>
	</div>

	<br />
	<div id="product"></div>

</body>
</html>