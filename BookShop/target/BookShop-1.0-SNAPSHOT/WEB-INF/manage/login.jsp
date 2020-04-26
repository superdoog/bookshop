<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>管理员登录</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css"/>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <!-- Tabs Titles -->

        <!-- Icon -->
        <div class="fadeIn first">
            <p>管理员登录</p>
        </div>

        <!-- Login Form -->
        <form method="post" action="${pageContext.request.contextPath}/backLogin">
            <c:set var="error" value='<%=request.getParameter("error")%>'/>
            <c:if test="${error != null}">
                <div class="fadeIn second info">${error}</div>
            </c:if>
            <input type="text" id="username" class="fadeIn second" name="username" placeholder="username">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

    </div>
</div>
</body>
</html>
