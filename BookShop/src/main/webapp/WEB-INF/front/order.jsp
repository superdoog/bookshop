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

            <div class="wrap">
                <div class="main">
                    <h2>确认收货地址</h2>
                    <hr/>
                    <div class="manage">
                        <form action="${pageContext.request.contextPath}/addOrder" id="orderForm" method="post">
                            <table class="table table-hover">
                                <tr>
                                    <td class="field">收货人：
                                        <input id="uid" name="uid" type="hidden" value="${sessionScope.userSession.uid}" required/>
                                    </td>
                                    <td><input type="text" class="text" id="oname" name="oname" value="${sessionScope.userSession.uname}" required/></td>
                                <tr>
                                    <td class="field">手机号码：</td>
                                    <td><input type="text" class="text" id="omobile" name="omobile" value="${sessionScope.userSession.phone}" required/></td>
                                </tr>
                                <tr>
                                    <td class="field">送货地址：</td>
                                    <td><textarea class="form-control" style="width:200px;height:100px;" id="oaddress" name="oaddress" required>${sessionScope.userSession.adress}</textarea></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
                <h2>确认订单信息</h2>
                <div id="shopping">
                    <c:if test="${sessionScope.cart.totalPrice!=0}">
                        <form>
                            <table>
                                <tr>
                                    <th>商品名称</th>
                                    <th>单价（元）</th>
                                    <th>购买数量</th>
                                    <th>金额（元）</th>
                                </tr>
                                <c:forEach var="good" items="${sessionScope.cart.goods}">
                                    <tr id="product_id_1">
                                        <td class="thumb"><img height="80" width="80" src="${pageContext.request.contextPath}/static/image/product/${good.key.image}"/><a href="${pageContext.request.contextPath}/productView?bid=${good.key.bid}">${good.key.bname}</a></td>
                                        <td class="price" ><span>￥${good.key.price}</span><input id="price${good.key.bid}" type="hidden" value="${good.key.price}" /></td>
                                        <td class="number"><a id="number${good.key.bid}" name="number">${good.value}</a></td>
                                        <td class="price"><span >￥</span><span id="goodSum${good.key.bid}">${good.key.price*good.value}</span></td>
                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="" rowspan="" headers="">合计金额</td>
                                    <td colspan="" rowspan="" headers=""></td>
                                    <td colspan="" rowspan="" headers=""></td>
                                    <td class="price" id="price_id_1"><span>￥</span><span id="sum">${sessionScope.cart.totalPrice}</span><input id="hiddenSum" type="hidden" value="${sessionScope.cart.totalPrice}"/></td>
                                </tr>
                            </table>
                            <div class="button"><a href="${pageContext.request.contextPath}/cartPage">返回购物车</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id="submit" href="#"><img src="${pageContext.request.contextPath}/static/image/orderSub.png"></a></div>
                        </form>
                    </c:if>
                    <c:if test="${sessionScope.cart.totalPrice==0}">
                        <img src="${pageContext.request.contextPath}/static/image/empty.jpg" />
                    </c:if>
                </div>
            </div>

        </div>
        <div class="col-md-1 column">
        </div>
    </div>
</div>
<%@ include file="../../static/footer.jsp" %>
<script src="${pageContext.request.contextPath}/static/js/jquery.validate-1.13.1.js"></script>
<script>
    var validator;
    $(document).ready(function () {
        $.validator.setDefaults({
        });
        validator = $("#orderForm").validate({
            rules: {
                oname: {
                    required: true
                },
                omobile: {
                    required: true,
                    minlength: 11,
                    maxlength: 11
                },
                oaddress: {
                    required: true
                }
            },
            messages: {
                oname: {
                    required: "必须填写收货人"
                },
                omobile: {
                    required: "必须填写电话",
                    minlength: "电话号码长度不正确",
                    maxlength: "电话号码长度不正确"
                },
                oaddress: {
                    required: "必须填写送货地址"
                }
            }
        });

        $("#submit").click(function () {
            $("#orderForm").submit();
        });
    });
</script>
</body>
</html>
