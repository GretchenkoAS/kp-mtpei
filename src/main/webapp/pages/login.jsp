<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-4 mx-auto my-lg-4 p-3 bg-light">
            <form class="form-horizontal" name="loginForm" method="POST" action="controller">
                <input type="hidden" name="command" value="login"/>
                <span class="heading">АВТОРИЗАЦИЯ</span>
                <div class="form-group">
                    <input type="email" class="form-control" name="email" placeholder="E-mail">
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group help">
                    <input type="password" class="form-control" name="password" placeholder="Password">
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-default">ВХОД</button>
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
