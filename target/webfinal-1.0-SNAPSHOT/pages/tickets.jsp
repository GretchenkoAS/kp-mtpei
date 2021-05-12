<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>

<head>
    <title>Tickets</title>
</head>
<header>
    <jsp:include page="${pageContext.request.contextPath}/pages/header.jsp"/>
</header>

<body>
<c:if test="${not empty message}">
    <p class="alert-warning"><fmt:message key="${message}"/></p>
</c:if>
<c:forEach items="${tickets}" var="ticket">
    ${ticket}
</c:forEach>
</body>