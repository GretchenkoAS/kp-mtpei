<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>


<form action="controller" method="get">
    <input type="hidden" name="command" value="change_locale"/>
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false">
            <fmt:message
                    key="button.language"/>
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
            <input class="dropdown-item" type="submit" name="language" value="en"/>
            <input class="dropdown-item" type="submit" name="language" value="ru"/>
        </div>
    </div>
</form>


<%--<form action="controller" method="post">--%>
<%--    <input type="hidden" name="command" value="change_locale"/>--%>
<%--    <input type="hidden" name="language" value="en"/>--%>
<%--    <button class="btn btn-secondary nav-link button-margin"><fmt:message--%>
<%--            key="local.en"/></button>--%>
<%--</form>--%>
<%--<form action="controller" method="post">--%>
<%--    <input type="hidden" name="command" value="change_locale"/>--%>
<%--    <input type="hidden" name="language" value="ru"/>--%>
<%--    <button class="btn btn-secondary nav-link button-margin"><fmt:message--%>
<%--            key="local.ru"/></button>--%>
<%--</form>--%>
</body>
</html>
