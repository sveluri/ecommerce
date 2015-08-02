<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
<link rel="stylesheet" type="text/css" href="search-response.css">
<link rel="stylesheet" type="text/css" href="table.css">
<link rel="stylesheet" type="text/css" href="registration.css">
	<link rel="stylesheet" type="text/css" href="header.css">

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
			var temp = $(this).closest("tr").find('.rowProductName').text();

			var addChange = "add";
			$.post("cart", {
				productName : temp, change : addChange
			}, function(responseText) {
				if(responseText)  {
					$("#responseText").text("Added to cart successfully ");
				}
				
			});

		});
		$("#productsTable").on("click", "td[name='remove']", function() {
			var temp = $(this).closest("tr").find('.rowProductName').text();

			var add = true;
			$.post("cart", {
				productName : temp, change : remove
			}, function(responseText) {
				if(responseText)  {
					$("#responseText").text("Removed from cart successfully ");
				}
				
			});

		});

	});
</script>

</head>
<body id="body">
<div id="responseText"></div>
	<div id="divbody">
		<br /> <br /> <br />
		<div id="responseText"></div>
		<div class="CSSTableGenerator">
			<table id="productsTable">
				<tr>

					<td>Product Name - Click on the product for further
						information</td>
					<td>Type</td>
					<td>Price</td>
					<td>Available Quantity</td>
					<td></td>
				</tr>
				<c:forEach items="${searchresults}" var="product">

					<tr>
						<td class="rowProductName" name="productNametd"><c:out
								value="${product.name}" /></td>
						<td><c:out value="${product.productType}" /></td>
						<td><c:out value="${product.price}" /> <c:out
								value="${product.priceType}" /></td>
						<td><c:out value="${product.availableQuantity}" /></td>
						<td name="cartActionAdd"><button id="addToCart"
								value="<c:out value="${product.name}" />">Add to cart</button></td>
					</tr>

				</c:forEach>
			</table>
		</div>

		<br />
		<div id="product"></div>
	</div>
</body>
</html>