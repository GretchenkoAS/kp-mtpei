<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="pagecontent"/>
<html>
<head>
    <title>MainNuha</title>
</head>
<body>
<header>
    <jsp:include page="${pageContext.request.contextPath}/pages/header.jsp"/>
</header>
<h3>Welcome</h3>
<hr />
${user}, hello!
<hr />
<br/>
<br/>
<br/>
<form class="form-inline mr-auto my-2 my-lg-0" method="GET" action="controller">
    <input type="hidden" name="command" value="find_trains_by_stations"/>
    <input class="form-control mr-sm-2" type="search" name="departureStation" placeholder=<fmt:message key="departureStation"/> aria-label="Search">
    <input class="form-control mr-sm-2" type="search" name="arrivalStation" placeholder=<fmt:message key="arrivalStation"/> aria-label="Search">
    <button class="btn btn-outline-light my-2 my-sm-0" type="submit"><fmt:message key="search"/></button>
</form>
<form align="center" name="ShowUsers" method="POST" action="controller">
    <input type="hidden" name="command" value="show_users" />
    <div class="form-group">
        <button type="submit" class="btn btn-default"><fmt:message key="submit"/></button>
    </div>
</form><hr/>
<form align="center" name="ShowTrains" method="POST" action="controller">
    <input type="hidden" name="command" value="show_all_trains" />
    <div class="form-group">
        <button type="submit" class="btn btn-default"><fmt:message key="submit"/></button>
    </div>
</form><hr/>
<footer>
    <jsp:include page="${pageContext.request.contextPath}/pages/footer.jsp"/>
</footer>
</body>
</html>
