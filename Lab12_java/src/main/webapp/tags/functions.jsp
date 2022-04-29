<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Functions tags</title>
</head>
<body>
    <h2>Functions tags</h2>
    <c:set var="str" value="The road to hell!"/>

    <c:if test="${fn:contains(str, 'road')}">
        <p>The string contains the word 'road'(contains).</p>
    </c:if>

    <c:if test="${fn:containsIgnoreCase(str, 'hell')}">
        <p>The string contains the word 'hell'(contains ignore case).</p>
    </c:if>

    <c:if test="${fn:endsWith(str, '!')}">
        <p>The string ends with '!'(ends with).</p>
    </c:if>


    <c:out value="The string length 'str' is ${fn:length(str)} (length)."/>
    <br>

    <c:if test="${fn:substringBefore(str, 'to')}">
        <c:out value="SubstringBefore: ${fn:substringBefore(str, 'to')}"/>
    </c:if>
    <br>

    <c:set var="str_replace" value="${fn:replace(str, 'hell', 'paradise')}"/>
    <c:out value="${str_replace}"/>
    <br>
    <c:set var="str_split_to_array" value="${fn:split(str, ' ')}"/>
    <c:forEach items="${str_split_to_array}" var="word">
    <li>${word}</li>
    </c:forEach>
    <br>

    <c:set var="str_join" value="${fn:join(str_split_to_array, '-')}"/>
    <c:out value="${str_join}"/>
    <br>
</html>
