<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <title> CountryPage</title>
</head>
<body>
Country name: ${country.name}
<h2>Unions:</h2>

<table border="1">
    <tr>
        <th>Title</th>
    </tr>
    <c:forEach var="union" items="${country.unions}">
        <tr>
            <td>${union.title}</td>

        </tr>
    </c:forEach>
</table>

<p>
    <a href="/addUnion/${country.id}">Add union</a>
</p>
<p>
    <a href="/"></a>
</p>
</body>
</html>