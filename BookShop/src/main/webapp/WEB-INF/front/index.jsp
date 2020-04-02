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
            <div class="row clearfix">
                <div class="col-md-1 column">
                </div>
                <div class="col-md-10 column">
                    <div class="carousel slide" id="carousel-283645">
                        <ol class="carousel-indicators">
                            <li class="active" data-slide-to="0" data-target="#carousel-283645">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-283645">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-283645">
                            </li>
                            <li data-slide-to="3" data-target="#carousel-283645">
                            </li>
                            <li data-slide-to="4" data-target="#carousel-283645">
                            </li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="${pageContext.request.contextPath}/productView?bid=10"><img alt="" src="${pageContext.request.contextPath}/static/image/1.jpg"/></a>
                            </div>
                            <div class="item">
                                <a href="${pageContext.request.contextPath}/productView?bid=11"><img alt="" src="${pageContext.request.contextPath}/static/image/2.jpg"/></a>
                            </div>
                            <div class="item">
                                <a href="${pageContext.request.contextPath}/productView?bid=12"><img alt="" src="${pageContext.request.contextPath}/static/image/3.jpg"/></a>
                            </div>
                            <div class="item">
                                <a href="${pageContext.request.contextPath}/productView?bid=13"><img alt="" src="${pageContext.request.contextPath}/static/image/4.jpg"/></a>
                            </div>
                            <div class="item">
                                <a href="${pageContext.request.contextPath}/productView?bid=14"><img alt="" src="${pageContext.request.contextPath}/static/image/5.jpg"/></a>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-283645" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                        <a class="right carousel-control" href="#carousel-283645" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                </div>
                <div class="col-md-1 column">
                </div>
            </div>
            <div class="page-header">
                <h1>
                    热门书籍 <small>推荐</small>
                </h1>
            </div>
            <div>
                <div class="col-md-1 column">
                </div>
                <div class="col-md-10 column">
                    <ul class="product clearfix">
                        <c:forEach items="${books}" var="book" end="9">
                            <li>
                                <dl>
                                    <dt><a href="${pageContext.request.contextPath}/productView?bid=${book.bid}" target="_blank"><img src="${pageContext.request.contextPath}/static/image/product/${book.image}"/></a></dt>
                                    <dd class="title"><a href="${pageContext.request.contextPath}/productView?bid=${book.bid}" target="_blank">${book.bname}</a></dd>
                                    <dd class="price">￥${book.price}</dd>
                                </dl>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-1 column">
                </div>
            </div>

        </div>
        <div class="col-md-1 column">
        </div>
    </div>
</div>

<%@ include file="../../static/footer.jsp" %>
</body>
</html>
