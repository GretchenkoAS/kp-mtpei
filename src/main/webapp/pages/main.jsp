<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<div class="content">
    <section class="hero-area bg-1 text-center overly">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="content-block">
                        <h1><fmt:message key="railway"/></h1>
                    </div>
                    <div class="advance-search">
                        <form method="GET" action="controller">
                            <input type="hidden" name="command" value="find_trains_by_stations"/>
                            <div class="row">
                                <div class="col-lg-6 col-md-12">
                                    <div class="block d-flex">
                                        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" type="search"
                                               name="departureStation" placeholder=
                                        <fmt:message key="departureStation"/>>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-12">
                                    <div class="block d-flex">
                                        <input type="text" class="form-control mb-2 mr-sm-2 mb-sm-0" type="search"
                                               name="arrivalStation" placeholder=
                                        <fmt:message key="arrivalStation"/>>
                                        <button class="btn btn-main"><fmt:message key="search"/></button>
                                    </div>
                                </div>
                            </div>
                        </form>

                    </div>

                </div>
            </div>
        </div>
    </section>


    <%--<div class="container">--%>
    <%--    <div class="row">--%>
    <%--        &lt;%&ndash;        <form class="form-inline mr-auto my-2 my-lg-0 " method="GET" action="controller">&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            <div class="col-4 mx-auto my-lg-4 p-3 bg-light">&ndash;%&gt;--%>
    <%--        <form class="form-inline col-10 p-10 my-2 my-lg-0 bg-light" method="GET" action="controller">--%>
    <%--            <input type="hidden" name="command" value="find_trains_by_stations"/>--%>
    <%--            <input class="form-control mr-sm-2" type="search" name="departureStation" placeholder=--%>
    <%--            <fmt:message key="departureStation"/> aria-label="Search">--%>
    <%--            <input class="form-control mr-sm-2" type="search" name="arrivalStation" placeholder=--%>
    <%--            <fmt:message key="arrivalStation"/> aria-label="Search">--%>
    <%--            <button class="btn btn-dark my-2 my-sm-0" type="submit"><fmt:message key="search"/></button>--%>
    <%--        </form>--%>
    <%--    </div>--%>
    <%--</div>--%>
    <%--<form align="center" name="ShowUsers" method="POST" action="controller">--%>
    <%--    <input type="hidden" name="command" value="show_users" />--%>
    <%--    <div class="form-group">--%>
    <%--        <button type="submit" class="btn btn-default"><fmt:message key="submit"/></button>--%>
    <%--    </div>--%>
    <%--</form><hr/>--%>
    <%--<form align="center" name="ShowTrains" method="POST" action="controller">--%>
    <%--    <input type="hidden" name="command" value="show_all_trains" />--%>
    <%--    <div class="form-group">--%>
    <%--        <button type="submit" class="btn btn-default"><fmt:message key="submit"/></button>--%>
    <%--    </div>--%>
    <%--</form><hr/>--%>
</div>
<footer>
    <jsp:include page="${pageContext.request.contextPath}/pages/footer.jsp"/>
</footer>
</body>

</html>
