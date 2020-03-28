<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <%@ include file="../../static/back-head.jsp"%>
</head>
<body>

<div class="container">
    <%@ include file="back-guide.jsp"%>
    <input type="hidden" id="path" name="path" value="${pageContext.request.contextPath}"/>

    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <div class="page-header">
                <h1>
                    用户<small>管理</small>
                </h1>

                <table class="table table-striped table-condensed">
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
                    <c:forEach var="book" items="${booklist}" varStatus="status">
                        <tr>
                            <td><span>${book.book_id}</span></td>
                            <td><span>${book.book_name}</span></td>
                            <td><span>${book.author}</span></td>
                            <td><span>${book.number}</span></td>
                            <td><span>${book.total}</span></td>
                            <td><span><a href="${pageContext.request.contextPath}/bookModifyPage?book_id=${book.book_id}">编辑</a></span>
                                 <span><a class="deleteBook" href="javascript:;" book_id=${book.book_id} book_name=${book.book_name}>删除</a></span></td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-3 column">
        </div>
        <div class="col-md-6 column">
            <div class="pager right">
                <ul class="clearfix">
                    <c:choose>
                        <c:when test="${pageInfo.hasPreviousPage}">
                            <li><a href="manaUser.do?pageNum=1">首页</a></li>
                            <li><a href="manaUser.do?pageNum=${pageInfo.prePage }">上一页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>首页</span></li>
                            <li><span>上一页</span></li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="index" begin="1" end="${pageInfo.pages }">

                        <li
                                <c:if test="${index==pageInfo.pageNum}">class="current"</c:if>><a
                                href="manaUser.do?pageNum=${index }">${index }</a></li>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${pageInfo.hasNextPage}">
                            <li><a href="manaUser.do?pageNum=${pageInfo.nextPage }">下一页</a></li>
                            <li><a href="manaUser.do?pageNum=${pageInfo.pages }">尾页</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><span>下一页</span></li>
                            <li><span>尾页</span></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
        <div class="col-md-3 column">
        </div>
    </div>
</div>
<div class="row clearfix">
        <span class="text-center"><%@ include file="../../static/footer.jsp"%></span>
</div>

</body>
</html>





