<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="search-response.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$("#cartTable").on("click", "td[name='remove']", function() {
			var temp = $(this).closest("tr").find('.rowProductName').text();
			var changeRemove = "remove";
			$.post("cart", {
				productName : temp,
				change : changeRemove
			}, function(responseText) {
				if (responseText) {
					$("#responseText").text("Removed from cart successfully ");
					$("#cartBody").html(responseText);
				}

			});

		});

		$("#checkout").click(function() {
			var rows = [];var errorP = false;
			$('#cartTable tr').each(function() {
				
				var productNames = $(this).find(".rowProductName").html();
				var prdquantity = $(this).find(".tdQuantity").find("input").val();
				if (productNames) {
					if (prdquantity) {
						rows.push({
							productName : productNames,
							quantity : prdquantity
						});
					} else {
						alert("Please enter quantity");
						errorP = true;
					}
				}

			});

			if(!errorP){
				var postData = JSON.stringify(rows);
				alert("Checking out the data");
				$.post("checkout", {
					data : postData
				}, function(responseText) {

					$("#cartBody").html(responseText);

				});	
			}
			

		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
</head>
<body>

	<div id="responseText"></div>
	<div id="cartBody">

		<br /> <br /> <br />
		<div class="CSSTableGenerator">
			<table id="cartTable">
				<tr>

					<td>Product Name</td>
					<td>Required Quantity</td>
					<td></td>

				</tr>
				<c:forEach items="${carts}" var="cart">

					<tr>
						<td name="cart" class="rowProductName"><c:out
								value="${cart.name}" /></td>
						<td class="tdQuantity"><input type="text"
							name="requiredQuantity" class="quantity" /></td>
						<td name="remove"><button id="removeFromCart">Remove</button></td>
					</tr>

				</c:forEach>
				<tr>
					<td colspan="3" align="center" style="align: center"><button
							id="checkout" name="checkout">Checkout</button></td>
				</tr>
			</table>
		</div>

		<br />
	</div>
</body>
</html>