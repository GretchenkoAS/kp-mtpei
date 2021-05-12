<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Persons</title>
</head>
<body>
<c:if test="${not empty incorrect_data}">
    <p class="alert-warning"><fmt:message key="${incorrect_data}"/></p>
</c:if>
<c:forEach items="${short_trains_data}" var="short_train_data">
    ${short_train_data}
</c:forEach>
</body>
</html>
