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
                    修改订单
                </h1>

                <form role="form" action="${pageContext.request.contextPath}/updateBookOrder" method="post">
                    <table class="form">
                        <tr>
                            <td class="field">订单ID：</td>
                            <td><input type="text" class="text"  id="oid" name="oid" value="${bookOrder.oid}" readonly /></td>
                        </tr>
                        <tr>
                            <td class="field">订购人姓名：</td>
                            <td><input type="text" class="text"  id="oname" name="oname" value="${bookOrder.oname}" /></td>
                        </tr>
                        <tr>
                            <td class="field">详细地址：</td>
                            <td><input type="text" class="text"  id="address" name="address" value="${bookOrder.adress}" /></td>
                        </tr>
                        <tr>
                            <td class="field">状态：</td>
                            <td><select id="status" name="orderStatus" class="form-control" style="width: 90px;">
                                <option value="未确认">未确认</option>
                                <option value="未发货">未发货</option>
                                <option value="已发货">已发货</option>
                                <option value="已签收">已签收</option>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td><input class="btn btn-default active" type="submit" name="submit" value="更新" /></td>
                            <td>
                                <a href="${pageContext.request.contextPath}/OrderManage"><input class="btn btn-default active" type="button" value="返回"></a>
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
</body>
</html>





