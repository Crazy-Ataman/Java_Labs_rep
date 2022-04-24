<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<form action="SecondServlet" method="get">
    <input type="submit" value="click">
</form>

<a href="${pageContext.request.contextPath}/LoginPass.jsp">Hello Servlet</a>
</body>
</html>