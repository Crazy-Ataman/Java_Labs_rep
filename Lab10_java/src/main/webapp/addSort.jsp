<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Add sort</title>
</head>
<body>
<h3>New method</h3>
<form action="AddMethodServlet" method="post">
    <label>Name</label>
    <br>
    <input type="text" name="name">
    <br>
    <label>Discipline</label>
    <br>
    <input type="text" name="discipline">
    <br>
    <input type="submit" value="add">
</form>
</body>
</html>
