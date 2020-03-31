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
        <div class="col-md-3 column">
        </div>
        <div class="col-md-7 column">
            <div class="page-header">
                <h1>
                    修改书籍
                </h1>

                <form role="form" action="${pageContext.request.contextPath}/modifyBook" enctype="multipart/form-data" method="post">
                    <table class="form">
                        <input type="hidden" name="bid" value="${book.bid}"/>
                        <tr>
                            <td class="field">商品名称：</td>
                            <td><input type="text" class="text" name="bname" value="${book.bname}" /></td>
                        </tr>
                        <tr>
                            <td class="field">商品描述：</td>
                            <td><input type="text" class="text" name="detail" value="${book.detail}" /></td>
                        </tr>
                        <tr>
                            <td class="field">商品价格：</td>
                            <td><input type="text" class="text tiny" name="price" value="${book.price}"/> 元</td>
                        </tr>
                        <tr>
                            <td class="field">所属分类：</td>
                            <td>
                                <select name="type" class="form-control" style="width: 90px;" >
                                    <c:forEach items="${ bts}" var="bt">
                                        <option value="${bt }">${bt}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="field">作者：</td>
                            <td><input type="text" class="text" name="writer" value="${book.writer}"/></td>
                        </tr>
                        <tr>
                            <td class="field">出版社：</td>
                            <td><input type="text" class="text" name="printer" value="${book.printer}" /></td>
                        </tr>
                        <tr>
                            <td>出版日期：</td>
                            <td><input type="text" Class="Wdate" id="dateString" name="dateString"
                                       readonly="readonly" value="${book.date}" onclick="WdatePicker();"></td>
                        </tr>
                        <tr>
                            <td class="field">商品图片：</td>
                            <td><input type="file" class="text" name="image" /></td>
                        </tr>
                        <tr>
                            <td class="field">库存：</td>
                            <td><input type="text" class="text tiny" name="store" value="${book.store}" /></td>
                        </tr>
                        <tr>
                            <td><input class="btn btn-default active" type="submit" name="submit" value="修改" /></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/BookManage">
                                    <input class="btn btn-default active" type="button" value="返回">
                                </a>
                            </td>
                        </tr>
                    </table>
                </form>

            </div>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>
<%@ include file="../../static/footer.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/calendar/WdatePicker.js"></script>
</body>
</html>





