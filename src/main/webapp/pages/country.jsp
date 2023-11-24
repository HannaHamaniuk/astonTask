<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title> CountryPage</title>
</head>
<body>

<h2>Unions:</h2>

<table border="1">
    <tr>
        <th>Title</th>
        <th>Action</th>
    </tr>
    <c:forEach var="union" items="${unions}">
        <tr>
            <td>${union.title}</td>

            <td><a href="/deleteUnion/${union.id}">delete</a></td>

        </tr>
    </c:forEach>
</table>

<p>
    <a href="/addBook/${country.id}">Add union</a>
</p>
<p>
    <a href="/"></a>
</p>
</body>
</html>