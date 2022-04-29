<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Core JSTL tags</title>
</head>
<body>
<h2>Out tag</h2>
<c:out value="11 * 9 = ${11*9}"/>

<h2>If tag</h2>
<c:if test="${11*9} > 100">
    <c:out value="${11*9} is greater than 100"/>
</c:if>

<h2>Choose tag</h2>
<c:choose>
    <c:when test="${11*9} > 100">
        <c:out value="${11*9} is greater than 100"/>
    </c:when>
    <c:otherwise>
        <c:out value="${11*9} is less than 100"/>
    </c:otherwise>
</c:choose>

<h2>ForEach tag</h2>
<%
    String[] names = {"John", "Mary", "Peter", "Sally"};
    request.setAttribute("names", names);
%>
<c:forEach items="${names}" var="name">
    <li>${name}</li>
</c:forEach>

<h2>Catch tag</h2>
<c:catch var="exception">
    <%int error = 99 / 0; %>
</c:catch>
<c:if test="${exception} != null">
    <c:out value="${exception}"/>
    <br>
    <c:out value="Message error: ${exception.message}"/>
</c:if>
</body>
</html>
