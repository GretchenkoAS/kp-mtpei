<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Persons</title>
</head>
<body>
<table border="1px" style="border-collapse: collapse">
    <th>email</th>
    <th>username</th>
    <th>role</th>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.email}</td>
            <td>${user.username}</td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
