<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <%@ include file="../../static/front-head.jsp" %>
</head>
<body>
<input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>

<%@ include file="front-guide.jsp" %>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-3 column">
        </div>
        <div class="col-md-6 column">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>欢迎登录 Book Shop</h1>
                </div>
                <div class="panel-body">
                    <br>
                    <form id="loginForm">
                        <table>
                            <tr>
                                <td class="field">用户名：</td>
                                <td><input class="text form-control" type="text" name="userName" id="userName"
                                           required/></td>
                            </tr>
                            <tr>
                                <td class="field">登录密码：</td>
                                <td>
                                    <input class="text form-control" type="password" name="passWord" id="passWord"
                                           required/>
                                </td>
                            </tr>
                            <tr>
                                <td class="field">验证码：</td>
                                <td>
                                    <input class="text form-control" type="text" name="yan" id="yan"
                                           required/>
                                    <img title="点击刷新" src="<%=request.getContextPath()%>/yan" onclick="Refresh()">
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><br>
                                    <input class="btn btn-default active" type="button" id="submit" value="登录"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>

        </div>
        <div class="col-md-3 column">
        </div>
    </div>


</div>
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
