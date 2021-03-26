<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 22.03.2021
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
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
