<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MainNuha</title>
</head>
<body>
<h3>Welcome</h3>
<hr />
${user}, hello!
<hr />
<br/>
<br/>
<br/>
<form align="center" name="ShowUsers" method="POST" action="controller">
    <input type="hidden" name="command" value="show_users" />
    <input type="submit" value="Show users"/>
</form><hr/>
</body>
</html>
