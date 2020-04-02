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
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 >修改个人信息</h1>
                </div>
                <div class="panel-body">
                    <form method="post" action="${pageContext.request.contextPath}/updateUserMessage">
                        <input type="hidden" name="uid" value="${user.uid}">
                        <div>
                            性别：
                            <select name="gender" id="gender">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div>
                            邮箱：<input type="text" name="email" id="email" name="email" value="${user.email}">
                        </div>
                        <div>
                            手机号：<input type="text" name="phone" id="phone" name="phone" value="${user.phone}" >
                        </div>
                        <div>
                            地址：<input type="text" name="address" id="address" value="${user.adress}">
                        </div>
                        <input class="btn btn-default active" type="submit" name="submit" value="修改" />
                    </form>

                </div>
            </div>

        </div>
        <div class="col-md-4 column">
        </div>
    </div>


</div>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
