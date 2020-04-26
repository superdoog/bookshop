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
                    <h1 >修改密码</h1>
                </div>
                <div class="panel-body">
                    <form id="updatePwd" method="post" action="${pageContext.request.contextPath}/updateUserPwd">
                        <input type="hidden" name="uid" value="${sessionScope.userSession.uid}">
                        <script>
                            var ss = "${sessionScope.userSession.password}";
                        </script>
                        <div>
                            旧&nbsp;&nbsp;密&nbsp;&nbsp;码&nbsp;：<input type="password" name="userPassword" id="userPassword" value="">
                            <font color="red"></font>
                            <script>

                            </script>
                        </div>
                        <div>
                            密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码&nbsp;：<input type="password" name="newPassword" id="newPassword" value="">
                            <font color="red"></font>
                        </div>
                        <div>
                            确认密码&nbsp;：<input type="password" name="ruserPassword" id="ruserPassword" value="">
                            <font color="red"></font>
                        </div>
                        <input id="update" class="btn btn-default active" type="submit" name="submit" value="修改" />
                    </form>

                </div>
            </div>

        </div>
        <div class="col-md-3 column">
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/static/js/update-pwd.js"></script>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
