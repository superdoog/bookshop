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
                    <strong>${book.bname}</strong>
                </h2>
            </div>
            <div id="product">
                <div class="infos">
                    <div class="thumb"><img height="300" width="300" src="${pageContext.request.contextPath}/static/image/product/${book.image}"/>
                    </div>
                    <div class="buy">
                        <p>价格：<span class="price">￥${book.price}</span></p>
                        <p>作 者：${book.writer}</p>
                        <p>出版社：${book.printer}</p>
                        <p>出版日期：${dateStr}</p>
                        <p>库　存：${book.store}</p>
                        <p>购买数量：<span id="sub" onclick="subNum();"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></span>&nbsp;
                            <input style="height: 25px; width:25px;" id="number" name="number" value="1" size="2" readonly/>&nbsp;
                            <span id="add" onclick="addNum();"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></span></p>
                        <div class="button">
                            <c:if test="${book.store>0}">
                                <a id="buy" href="#"><img class="buyBtn" src="${pageContext.request.contextPath}/static/image/buy.jpg"></a>&nbsp;&nbsp;&nbsp;
                                <input type="hidden" id="bid" value="${book.bid}"/>&nbsp;&nbsp;&nbsp;
                                <a id="submit" href="#"><img src="${pageContext.request.contextPath}/static/image/cart.png"></a>
                            </c:if>
                            <c:if test="${book.store==0}">
                                <img src="${pageContext.request.contextPath}/static/image/null.png">
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-1 column">
        </div>
    </div>

    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column" id="products">
            <div class="introduce">
                <h3><strong>商品详情</strong></h3>
                <hr width=100% style="border:1px dashed ;">
                <div class="text">
                    ${book.detail}
                </div>
            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/product-view.js"></script>
<%@ include file="../../static/footer.jsp" %>
</body>
</html>
