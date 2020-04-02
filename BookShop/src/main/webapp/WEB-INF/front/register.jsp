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
                    <h1>欢迎注册 Book Shop</h1>
                </div>
                <div class="panel-body ">

                    <form id="userForm" name="userForm" method="post" action="${pageContext.request.contextPath}/Register">

                        <c:if test="${error != null}">
                            <div style=" color: red;font-weight:bold;">${error}</div>
                        </c:if>

                            用户名：<input type="text" name="userName" id="userName" value="">
                        <font color="red"></font>
                        <div>
                            密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="userPassword" id="userPassword" value="">
                            <font color="red"></font>
                        </div>
                        <div>
                            确认密码：<input type="password" name="ruserPassword" id="ruserPassword" value="">
                            <font color="red"></font>
                        </div>
                        <div>
                            性别：
                            <select name="gender" id="gender">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div>
                            地址：<input name="address" id="address" value="">
                        </div>
                        <div>
                            <input type="button" class="btn btn-default active" name="add" id="add" value="注册">
                        </div>
                    </form>

                </div>
            </div>

        </div>
        <div class="col-md-3 column">
        </div>
    </div>


</div>
<script src="${pageContext.request.contextPath}/static/js/register.js"></script>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
