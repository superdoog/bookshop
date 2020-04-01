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
                    全部商品
                </h2>
            </div>
            <div>
                <div class="col-md-1 column">
                </div>
                <div class="col-md-10 column">
                    <ul class="product clearfix">
                        <c:forEach items="${books}" var="book">
                            <li>
                                <dl>
                                    <dt><a href="${pageContext.request.contextPath}/productView?bid=${book.bid}" target="_blank"><img src="${pageContext.request.contextPath}/static/image/product/${book.image}"/></a></dt>
                                    <dd class="title"><a href="${pageContext.request.contextPath}/productView?bid=${book.bid}" target="_blank">${book.bname}</a></dd>
                                    <dd class="price">￥${book.price}</dd>
                                </dl>
                            </li>
                        </c:forEach>
                    </ul>

                    <div class="row clearfix">
                        <form class="navbar-form navbar-right" role="form" action="${pageContext.request.contextPath}/productList">
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
