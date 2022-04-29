<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Formatting JSTL tags</title>
</head>
<body>
    <h2>Dates</h2>
    <p>
        <c:set var="date" value="<%=new java.util.Date()%>" />
        <fmt:setLocale value="en_US" />
        <c:out value="en_US date: ${date}"/>
        <br>
        <fmt:setLocale value="de_DE" />
        <c:out value="de_DE date: ${date}"/>
    </p>

    <h2>Styles of time</h2>
    <li>
        short: <fmt:formatDate value="${date}" type="time" timeStyle="short" />
    </li>
    <li>
        medium: <fmt:formatDate value="${date}" type="time" timeStyle="medium" />
    </li>
    <li>
        long: <fmt:formatDate value="${date}" type="time" timeStyle="long" />
    </li>
    <li>
        full: <fmt:formatDate value="${date}" type="time" timeStyle="full" />
    </li>

    <h2>Formatted date and time</h2>
    <fmt:formatDate value="${date}" type="both" />

    <h2>Formatted date and time with time zone</h2>
    <fmt:formatDate value="${date}" type="both" timeZone="GMT" />

    <h2>Number formatting</h2>
    <c:set var="number" value="357.07547" />
    <li>
        Default: <fmt:formatNumber value="${number}" />
    </li>
    <li>
        Percent: <fmt:formatNumber value="${number}" type="percent" />
    </li>
    <li>
        Currency: <fmt:formatNumber value="${number}" type="currency" />
    </li>
    <li>
        Max fraction 5: <fmt:formatNumber value="${number}" type="number" maxFractionDigits="5" />
    </li>

    <br>
    <table>
        <tr>
            <td colspan="2" class="table-header">
                <p>
                    <b>
                        Formatting:
                        <fmt:formatDate value="${date}" type="both"
                                        timeStyle="long" dateStyle="long" />
                    </b>
                </p>
            </td>
        </tr>

        <c:forEach var="zone"
                   items="<%=java.util.TimeZone.getAvailableIDs()%>">
            <tr>
                <td>
                    <c:out value="${zone}" />
                </td>
                <td>
                    <fmt:timeZone value="${zone}">
                        <fmt:formatDate value="${date}" timeZone="${zone}"
                                        type="both"/>
                    </fmt:timeZone>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
