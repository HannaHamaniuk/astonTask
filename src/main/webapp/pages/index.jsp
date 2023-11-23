<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Index Page</title>

</head>
<body>
All available  countries
<table border="1">
    <tr>
        <th>Name</th>
        <th>President</th>
        <th>Capital</th>
        <th>action</th>
    </tr>
    <c:forEach var="country" items="${countries}">
        <tr>
            <td>${country.name}</td>
            <td>${country.president}</td>
            <td>${country.capital}</td>
            <td>
                <a href="/view/${country.id}">view</a>
                <a href="/delete/${library.id}">delete</a>
                <a href="/update/${library.id}">update</a>
            </td>
        </tr>
    </c:forEach>

</table>
<p>
    <a href="/add">Add new country</a>
</p>
</body>k
</html>
