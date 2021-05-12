<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Trains</title>
</head>
<body>
<header>
    <jsp:include page="${pageContext.request.contextPath}/pages/header.jsp"/>
</header>
<hr/>

<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col"><fmt:message key="username"/></th>
        <th scope="col"><fmt:message key="email"/></th>
        <th scope="col"><fmt:message key="role"/></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
                <%--            <td>--%>
                <%--                <a href="${pageContext.request.contextPath}/controller?command=find_train_by_id&trainId=${short_train_data.trainId}">--%>
                <%--                        ${short_train_data.trainId}--%>
                <%--                </a>--%>
                <%--            </td>--%>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.role.toString()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>
