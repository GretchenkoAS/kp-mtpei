<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>Header</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>



<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <a class="navbar-brand" href="#">Что-то</a>

    <div class="collapse navbar-collapse">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="home"/><span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Что-то</a>
            </li>
        </ul>
        <form class="form-inline mr-auto my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder=<fmt:message key="departureStation"/> aria-label="Search">
            <input class="form-control mr-sm-2" type="search" placeholder=<fmt:message key="arrivalStation"/> aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit"><fmt:message key="search"/></button>
        </form>

        <c:if test="${sessionScope.user == null}">
            <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller"
                  method="get">
                <input type="hidden" name="command" value="to_login_page"/>
                <button  class="btn btn-dark btn-lg active" type="submit"><fmt:message key="login"/></button>
            </form>
        </c:if>
        <c:if test="${sessionScope.user != null}">
            <div class="dropdown">
                <a class="btn btn-dark btn-lg active" href="#" role="button" id="dropdownMenuLink"
                   data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.user.username}
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/controller">
                        <fmt:message key="profile"/>
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/controller?command=logout">
                        <fmt:message key="logout"/>
                    </a>
                </div>
            </div>
        </c:if>
        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/controller"
              method="get">
            <input type="hidden" name="command" value="change_locale"/>
            <div class="dropdown">
                <a class="nav-item nav-link dropdown-toggle mr-md-2" href="#" id="bd-versions" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-globe fa-2x"></i>
                </a>
                <div class="dropdown-menu" aria-labelledby="change_language">
                    <button class="dropdown-item" type="submit" name="language" value="en">English</button>
                    <button class="dropdown-item" type="submit" name="language" value="ru">Русский</button>
                </div>
            </div>
        </form>
    </div>
</nav>

</body>
</html>