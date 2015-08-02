<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Date;"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="search-response.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<script>
	$(document).ready(function() {

		var totprice = parseInt("0");
		$('#billTable tr').each(function() {
			var price = $(this).find(".price").html();
			if (price) {
				totprice = totprice + parseInt(price);
			}
		});

		$("#totalPrice").text(totprice);

	});
</script>
</head>
<body>

	<div id="poBody" style="width: 100%; height: 10%;">

		<hr />

		<h1>Ecommerce : Purchase Order</h1>

		<br /> <br />

		<h3>
			Printed on : <font color="#FF0000"> <%=new java.util.Date()%></font>
			<br /> Bill number : BILL-<%=(int) (Math.random() * 100)%>

		</h3>


		<hr />

		<table id="billTable" border="1">

			<tr>

				<td>Item name</td>
				<td>Quantity</td>
				<td>Price</td>

			</tr>

			<c:forEach items="${orderItems}" var="orderItem">

				<tr>
					<td><c:out value="${orderItem.productName}" /></td>
					<td><c:out value="${orderItem.quantity}" /></td>
					<td class="price"><c:out value="${orderItem.price}" /></td>
				</tr>

			</c:forEach>
			<tr>

				<td>Total Price</td>
				<td colspan="2" align="right" style="text-align: right"><div
						id="totalPrice"></div></td>

			</tr>


		</table>


	</div>


</body>
</html>