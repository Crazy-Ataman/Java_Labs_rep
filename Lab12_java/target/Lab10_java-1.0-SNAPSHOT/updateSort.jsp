<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
    <title>Update sort</title>
</head>
<body>
<h3>Update method</h3>
<form action="UpdateMethodServlet" method="post">
  <label>Name</label>
  <br>
  <input type="text" name="name">
  <br>
  <label>Discipline</label>
  <br>
  <input type="text" name="discipline">
  <br>
  <input type="submit" value="update">
</form>
</body>
</html>
