<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>

<html>
<head>
    <title>Login</title>

</head>

<body>
<header>
    <jsp:include page="${pageContext.request.contextPath}/pages/header.jsp"/>
</header>

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
<footer>
    <jsp:include page="${pageContext.request.contextPath}/pages/footer.jsp"/>
</footer>
</body>
</html>
