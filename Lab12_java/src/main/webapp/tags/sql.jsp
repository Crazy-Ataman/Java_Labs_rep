<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>SQL tags</title>
    <style>
        table {
            border-collapse: collapse;
        }
        td {
            border: 1px solid black;
            padding: 5px;
            width: 100px;
            background: gainsboro;
        }
    </style>
</head>
<body>
    <sql:setDataSource var="dataSource"
    url="jdbc:sqlserver://USER-PC; databaseName=Lab9; trustServerCertificate=true; encrypt=false; IntegratedSecurity=false"
    driver="com.microsoft.sqlserver.jdbc.SQLServerDriver" user="sa" password="1111"/>

    <sql:query var="query" dataSource="${dataSource}">
        SELECT * FROM disciplines_methods;
    </sql:query>

    <table>
        <tr>
            <th>name</th>
            <th>discipline</th>
        </tr>
        <c:forEach items="${query.rows}" var="row">
            <tr>
                <td>${row.name}</td>
                <td>${row.discipline}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
