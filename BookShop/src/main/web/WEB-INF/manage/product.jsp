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
                </h1>

                <table class="table table-striped table-condensed table-bordered table-hover text-muted">
                    <tr class="active">
                        <th>ID</th>
                        <th>商品名称</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach var="book" items="${books}">
                        <tr>
                            <td class="first w4 c">${book.bid }</td>
                            <td class="thumb"><img height="77" width="77" src="${pageContext.request.contextPath}/static/image/product/${book.image}"/><a
                                    href="../product-view.html" target="_blank">${book.bname}</a></td>
                            <td class="w1 c"><a href="modifyBookPage.do?bid=${book.bid}">修改</a> <a
                                    href="delBook.do?bid=${book.bid}">删除</a></td>
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

<footer class="footer navbar-fixed-bottom" style="background-color: #333333">
    <div class="container">
        <span class="text-center text-danger">
            <br>
            <div><%@ include file="../../static/footer.jsp" %></div>
            <br>
            <br>
        </span>
    </div>
</footer>

</body>
</html>





