<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.List,java.util.Arrays"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ecommerce</title>
</head>
<body>
	<% 

Cookie[] cookieArray = request.getCookies();

if(cookieArray != null) {
	
	List<Cookie> cookieList = Arrays.asList(cookieArray);

	if(!cookieList.isEmpty()){
		Cookie loginCookie = new Cookie("LOGIN_USER", "");
		response.addCookie(loginCookie);
	}

	RequestDispatcher rd = request.getRequestDispatcher("/index.jsp"); 
	rd.forward(request, response);
}

%>
</body>
</html>