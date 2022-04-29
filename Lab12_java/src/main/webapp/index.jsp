<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="dml" uri="myTags.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSTL tags</title>
</head>
<body>
    <form action="tags/core.jsp">
        <dml:DMLSubmit text="Core"/>
    </form>
    <form action="tags/formatting.jsp">
        <dml:DMLSubmit text="Formatting"/>
    </form>
    <form action="tags/functions.jsp">
        <dml:DMLSubmit text="Functions"/>
    </form>
    <form action="tags/sql.jsp">
        <dml:DMLSubmit text="SQL"/>
    </form>
    <form action="tags/xml.jsp">
        <dml:DMLSubmit text="XML"/>
    </form>
    <form action="table.jsp">
        <dml:DMLSubmit text="Table"/>
    </form>
</body>
</html>