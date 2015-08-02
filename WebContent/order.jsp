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

		$("#orderTable").on("click", "td[name='orderId']", function() {
			var temp = $(this).closest("tr").find('.orderID').text();
			var single = "single";
			$.get("checkout", {
				data : single, orderId : temp }, function(responseText) {
				if (responseText) {
					$("#orderBody").html(responseText);
				}
			});

		});
		
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
</head>
<body>

	<div id="responseText"></div>
	<div id="orderBody">

		<br /> <br /> <br />
		<div class="CSSTableGenerator">
			<table id="orderTable">
				<tr>

					<td>OrderId</td>
					<td>Created</td>

				</tr>
				<c:forEach items="${orders}" var="order">

					<tr>
						<td name="orderId" class="orderID"><c:out
								value="${order.id}" /></td>
						<td name="tdOrder" class="tdOrder"><c:out value="${order.created}" /></td>
					</tr>

				</c:forEach>

			</table>
		</div>

		<br />
	</div>

</body>
</html>