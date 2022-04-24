<%@ page import="sapegina.model.User" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    LocalDateTime now = LocalDateTime.now();
%>
<h3>Hi, <%= user.getLogin() %>, <%= user.getStatus() %>. <%= now.toLocalDate() %></h3>
<form action="TimeServlet" method="get">
    <input type="submit" value="Show time"/>
</form>
<form action="LoginRedirectServlet" method="post">
    <input type="submit" value="Login"/>
</form>
<form action="RegistrationRedirectServlet" method="post">
    <input type="submit" value="Registration"/>
</form>
<form action="CookieRedirectServlet" method="post">
    <input type="submit" value="Cookie"/>
</form>
<form action="RedirectServlet" method="get">
    <input type="submit" value="Get"/>
</form>
<form action="RedirectServlet" method="post">
    <input type="submit" value="Post"/>
</form>
</body>
</html>