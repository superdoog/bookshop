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
                    <strong>购物车🛒</strong>
                </h2>
            </div>

            <div id="shopping">
                <c:if test="${sessionScope.cart.totalPrice!=0&&sessionScope.cart!=null}">
                    <form action="shopping-result.html">
                        <table class="table table-hover">
                            <tr>
                                <th>商品名称</th>
                                <th>单价（元）</th>
                                <th>购买数量</th>
                                <th>金额（元）</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach var="good" items="${sessionScope.cart.goods}">
                                <tr id="product_id_1">
                                    <td class="thumb"><img height="80" width="80" src="${pageContext.request.contextPath}/static/image/product/${good.key.image}"/><a
                                            href="productView?bid=${good.key.bid}">${good.key.bname}</a></td>
                                    <td class="price">
                                        <span>￥${good.key.price}</span>
                                        <input id="price${good.key.bid}" type="hidden" value="${good.key.price}"/>
                                    </td>
                                    <td class="number">
                                        <span id="sub" onclick="sub(${good.key.bid});"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></span>
                                        <input style="height: 25px; width:25px;" type="text" id="number${good.key.bid}" name="number" value="${good.value}" size="2" readonly/>
                                        <span id="add" onclick="add(${good.key.bid});"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></span>
                                    </td>
                                    <td class="price">
                                        <span>￥</span>
                                        <span id="goodSum${good.key.bid}">${good.key.price*good.value}</span>
                                    </td>
                                    <td class="delete"><a href="removeGoodsFromCart.do?bid=${good.key.bid}">删除</a></td>
                                </tr>
                            </c:forEach>

                            <tr class="warning">
                                <td colspan="" rowspan="" headers="">合计金额</td>
                                <td colspan="" rowspan="" headers=""></td>
                                <td colspan="" rowspan="" headers=""></td>
                                <td colspan="" rowspan="" headers=""></td>
                                <td class="price" id="price_id_1">
                                    <span>￥</span>
                                    <span id="sum">${sessionScope.cart.totalPrice }</span>
                                    <input id="hiddenSum" type="hidden" value="${sessionScope.cart.totalPrice}"/>
                                </td>
                            </tr>
                        </table>
                        <div class="button">
                            <a href="cleanCart.do">清空购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <c:if test="${sessionScope.userSession!=null}"><a id="submit" href="#"><img src="${pageContext.request.contextPath}/static/image/pay.png"></a></c:if>
                            <c:if test="${sessionScope.userSession==null}"><a onclick="unLog();" href="#"><img src="${pageContext.request.contextPath}/static/image/pay.png"></a></c:if>


                        </div>
                    </form>
                </c:if>
                <c:if test="${sessionScope.cart.totalPrice==0||sessionScope.cart==null}">
                    <img src="${pageContext.request.contextPath}/static/image/empty.jpg"/>
                </c:if>

            </div>


        </div>
        <div class="col-md-1 column">
        </div>
    </div>

</div>
<script src="${pageContext.request.contextPath}/static/js/cart.js"></script>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
