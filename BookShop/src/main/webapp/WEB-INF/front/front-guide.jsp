<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="container-fluid" style="background-color: #333333">
    <br>
    <div class="col-md-12 column">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <a href="${pageContext.request.contextPath}/index"><img src="${pageContext.request.contextPath}/static/image/logo.png" style="float:left; width:65px;height: 65px; text-align:center;">
                <span class="navbar-brand"><font color="#333333" size="24">Book Shop</font></span></a>
            </div>

            <form class="nav navbar-form navbar-right" role="search" method="post" action="${pageContext.request.contextPath}/productList">
                <div class="form-group">查找书籍：<input type="text" class="form-control" name="key" placeholder="请输入商品关键字"/></div>
                <button type="submit" class="btn btn-default active">搜索</button>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/cartPage"><font color="#333333">&nbsp;&nbsp;&nbsp;&nbsp;🛒</font></a></li>
                    <c:if test="${sessionScope.userSession==null}">
                        <li><a id="login" href="${pageContext.request.contextPath}/frontLogin"><font color="#333333">登录</font></a></li>
                        <li><a id="register" href="${pageContext.request.contextPath}/regjsp"><font color="#333333">注册&nbsp;&nbsp;&nbsp;&nbsp;</font></a></li>
                    </c:if>
                    <c:if test="${sessionScope.userSession!=null}">
                        <li><a href="${pageContext.request.contextPath}/userOrder"><font color="#333333">我的订单</font></a></li>
                        <li><a><font color="#333333">用户:&nbsp;${sessionScope.userSession.uname}&nbsp;&nbsp;</font></a></li>
                        <li><a href="${pageContext.request.contextPath}/updateUserPage"><font color="#333333">更新个人信息</font></a></li>
                        <li><a href="${pageContext.request.contextPath}/updatePwdPage"><font color="#333333">修改密码</font></a></li>
                        <li><a id="logout" href="${pageContext.request.contextPath}/logout"><font color="#333333">注销&nbsp;&nbsp;&nbsp;&nbsp;</font></a></li>
                    </c:if>
                </ul>
            </form>
        </nav>
    </div>
</div>

<div class="col-md-12 column">

    <ul class="breadcrumb text-center">
        <c:forEach items="${bts}" var="bt">
            <li><a href="${pageContext.request.contextPath}/productList?type=${bt}">${bt}</a></li>
        </c:forEach>
    </ul>
</div>