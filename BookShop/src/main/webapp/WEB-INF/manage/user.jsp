<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="../../static/back-head.jsp" %>
</head>
<body>
<div class="container-fluid" style="background-color: #333333">
    <br>
    <%@ include file="back-guide.jsp" %>
</div>
<div class="container">

    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>

    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <div class="page-header">
                <h1>
                    用户<small>管理</small>
                    <a class="pull-right" href="${pageContext.request.contextPath}/addUserPage">
                        <button type="button" class="btn btn-default active">增加用户</button>
                    </a>
                </h1>
                <br>
            </div>

            <table class="table table-striped table-condensed table-bordered table-hover text-muted">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>Email</th>
                    <th>手机</th>
                    <th>操作</th>
                </tr>
                </thead>
                <c:forEach var="user" items="${users}" varStatus="status">
                    <tr>
                        <td><span>${user.uid}</span></td>
                        <td><span>${user.uname}</span></td>
                        <td><span>${user.gender}</span></td>
                        <td><span>${user.email}</span></td>
                        <td><span>${user.phone}</span></td>
                        <td><span><a href="${pageContext.request.contextPath}/UserModifyPage?uid=${user.uid}">编辑</a></span>
                            <span><a class="deleteUser" href="javascript:;" userid=${user.uid} username=${user.uname}>删除</a></span>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="row clearfix">
                <form class="navbar-form navbar-right" role="search" action="${pageContext.request.contextPath}/UserManage">
                    <input type="hidden" name="pageIndex" value="1"/>
                </form>
                <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
                <c:import url="page.jsp">
                    <c:param name="totalCount" value="${totalCount}"/>
                    <c:param name="currentPageNo" value="${currentPageNo}"/>
                    <c:param name="totalPageCount" value="${totalPageCount}"/>
                </c:import>
            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>

    <!--点击删除按钮后弹出的页面-->
    <div class="zhezhao"></div>
    <div class="remove" id="removeUse">
        <div class="removerChid">
            <h2>提示</h2>
            <div class="removeMain">
                <p>你确定要删除该用户吗？</p>
                <a href="#" id="yes">确定</a>
                <a href="#" id="no">取消</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="../../static/footer.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/user.js"></script>
</body>
</html>





