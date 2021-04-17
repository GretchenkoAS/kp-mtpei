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
<form align="center" name="ShowUsers" method="POST" action="controller">
    <input type="hidden" name="command" value="show_users" />
    <div class="form-group">
        <button type="submit" class="btn btn-default"><fmt:message key="label.submit"/></button>
    </div>
</form><hr/>
<footer>
    <jsp:include page="${pageContext.request.contextPath}/pages/footer.jsp"/>
</footer>
</body>
</html>
