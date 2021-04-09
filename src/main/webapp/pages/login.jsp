<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<%--<fmt:setLocale value="ru_RU"/>--%>
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

</head>

<header>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="change_locale"/>
        <input type="hidden" name="language" value="en"/>
        <button class="btn btn-secondary nav-link button-margin"><fmt:message
                key="local.en"/></button>
    </form>
    <form action="controller" method="post">
        <input type="hidden" name="command" value="change_locale"/>
        <input type="hidden" name="language" value="ru"/>
        <button class="btn btn-secondary nav-link button-margin"><fmt:message
                key="local.ru"/></button>
    </form>
</header>

<body>
<div class="container">
    <div class="row">
        <div class="col-4 mx-auto my-lg-4 p-3 bg-light">
            <form class="form-horizontal" name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="login"/>
                <span class="heading"><fmt:message key="label.authorization"/></span>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder=<fmt:message key="label.email"/>>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" placeholder=<fmt:message
                            key="label.password"/>>
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default"><fmt:message key="label.submit"/></button>
                </div>
                ${error_login}
                ${wrongAction}
                ${nullPage}
            </form>
        </div>
    </div>
</div>
</body>
</html>
