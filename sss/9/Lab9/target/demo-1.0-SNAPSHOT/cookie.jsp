<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie info</title>
</head>
<body>
  <% Cookie[] cookies = request.getCookies(); %>
  <ol>
    <% for (Cookie cookie : cookies) { %>
    <li><%= cookie.getName() %>: <%= cookie.getValue() %></li>
    <% } %>
  </ol>
</body>
</html>
