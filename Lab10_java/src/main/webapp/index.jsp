<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="models.User" %>
<%@ page import="models.SortMethod" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="requests.DisciplineRequest" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
    <style>
        form {
            display: inline-block;
            margin-right: 100px;
        }

        table {
            border: 1px solid black;
            border-collapse: collapse;
            min-width: 300px;
            background: #795eb8;
            text-align: center;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<% User user = (User) session.getAttribute("user"); %>
<h3>Welcome, <%= user.getLogin() %>, <%= user.getStatus() %>.</h3>
<h4>
    <%
        try {
            DisciplineRequest sortRequest = new DisciplineRequest();
            ArrayList<SortMethod> methods = sortRequest.selectSorts();
            for (SortMethod method : methods) {
    %>
    <table>
        <tr>
            <td><%= method.getName() %>
            </td>
            <td><%= method.getDiscipline() %>
            </td>
        </tr>
    </table>
    <%
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
</h4>
<form action="addSort.jsp" method="post">
    <input type="submit" value="add">
</form>
<form action="updateSort.jsp" method="post">
    <input type="submit" value="update">
</form>
<form action="deleteSort.jsp" method="post">
    <input type="submit" value="delete">
</form>

<br>
<%@include file="footer.jsp" %>
</body>
</html>