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
                    订单<small>管理</small>
                </h1>

                <table class="table table-hover">
                    <c:forEach items="${bookOrders}" var="bookOrder">
                        <tr class="active ">
                            <td class="first w4 c">订单号:${bookOrder.oid}</td>
                            <td class="w1 c">${bookOrder.date}</td>
                            <td class="w1 c">收货人:${bookOrder.oname}</td>
                            <td>收货地址：${bookOrder.adress}</td>
                            <td class="w1 c"><a href="orderModifyPage.do?oid=${bookOrder.oid}">修改</a> <a
                                    href="delserchBookOrder.do?oid=${bookOrder.oid}">删除</a></td>
                        </tr>
                        <c:forEach items="${bookOrder.orderDetails}" var="orderDetail">
                            <c:forEach items="${books }" var="book">
                                <c:if test="${book.bid==orderDetail.bookId }">
                                    <tr>
                                        <td class="first w4 c">${book.bname }</td>
                                        <td class="w1 c"><img height="60" width="60" src="${pageContext.request.contextPath}/static/image/product/${book.image}"></td>
                                        <td class="w1 c">数量：${orderDetail.bookNum }</td>
                                        <td>￥${book.pirce*orderDetail.bookNum }</td>
                                        <td class="w1 c">${bookOrder.status }</td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </table>

                <div class="row clearfix">
                    <form class="navbar-form navbar-right" role="search"
                          action="${pageContext.request.contextPath}/OrderManage">
                        <input type="hidden" name="pageIndex" value="1"/>
                    </form>
                    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
                    <c:import url="../page.jsp">
                        <c:param name="totalCount" value="${totalCount}"/>
                        <c:param name="currentPageNo" value="${currentPageNo}"/>
                        <c:param name="totalPageCount" value="${totalPageCount}"/>
                    </c:import>
                    <br>
                    <br>
                </div>

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
</body>
</html>





