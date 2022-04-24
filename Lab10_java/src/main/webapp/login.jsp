<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3 style="color: red">${message}</h3>
<fieldset>
    <legend>Login</legend>
    <form action="LoginServlet" method="post">
        <input type="text" name="login" placeholder="login">
        <input type="text" name="password" placeholder="password">
        <input type="submit" value="Login">
    </form>
    <form action="RegistrationRedirectServlet" method="post">
        <input type="submit" value="Registration"/>
    </form>
</fieldset>
</body>
</html>
