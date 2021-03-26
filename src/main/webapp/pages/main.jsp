<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 18.03.2021
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MainNuha</title>
</head>
<body>
<table align="center">
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
<br/>
<br/>
<br/>
<form align="center" name="ShowUsers" method="POST" action="controller">
    <input type="hidden" name="command" value="show_users" />
    <input type="submit" value="Show users"/>
</form><hr/>
</body>
</html>
