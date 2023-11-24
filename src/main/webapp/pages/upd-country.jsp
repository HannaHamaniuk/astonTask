<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Update Country Page</title>
</head>
<body>
<sf:form method="post" action="/save" modelAttribute="country">
    <sf:input path="id" type="hidden"/><br>
    Country Name: <sf:input path="name"/><br>
    Country President: <sf:input path="president"/><br>
    Country Capital: <sf:input path="capital"/><br>
    <input type="submit" value="update">
</sf:form>
</body>
</html>