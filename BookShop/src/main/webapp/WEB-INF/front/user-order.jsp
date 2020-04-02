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
        <div class="col-md-1 column">
        </div>
        <div class="col-md-10 column">
            <div class="page-header">
                <h2>
                    <strong>我的订单</strong>
                </h2>
            </div>

            <table class="table table-hover">
                <c:forEach items="${bookOrders}" var="bookOrder">
                    <tr class="active">
                        <td>订单号:${bookOrder.oid}</td>
                        <td>${bookOrder.date}</td>
                        <td>收货人:${bookOrder.oname}</td>
                        <td>收货地址：${bookOrder.adress}</td>
                        <td>订单状态</td>
                    </tr>
                    <c:forEach items="${bookOrder.orderDetails}" var="orderDetail">
                        <c:forEach items="${orderDetail.books}" var="book">
                            <tr>
                                <td>${book.bname}</td>
                                <td><img height="80" width="80"
                                         src="${pageContext.request.contextPath}/static/image/product/${book.image}">
                                </td>
                                <td>数量：${orderDetail.bookNum}</td>
                                <td>￥${book.price*orderDetail.bookNum}</td>
                                <td>${bookOrder.status}</td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </c:forEach>
            </table>

            <div class="row clearfix">
                <form class="navbar-form navbar-right" role="search"
                      action="${pageContext.request.contextPath}/userOrder">
                    <input type="hidden" name="pageIndex" value="1"/>
                </form>
                <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
                <c:import url="Page.jsp">
                    <c:param name="totalCount" value="${totalCount}"/>
                    <c:param name="currentPageNo" value="${currentPageNo}"/>
                    <c:param name="totalPageCount" value="${totalPageCount}"/>
                </c:import>
                <br>
                <br>
            </div>

        </div>
        <div class="col-md-1 column">
        </div>
    </div>


</div>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
