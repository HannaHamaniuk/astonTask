<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Union</title>
</head>
<body>
<sf:form method="post" action="/saveUnion" modelAttribute="union">
    <sf:input path="country_id" type="hidden"/><br>
    Title: <sf:input path="title"/><br>
    <input type="submit" value="Save">
</sf:form>
</body>
</html>