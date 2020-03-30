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
                    增加用户
                </h1>
                <br>
            </div>

            <form role="form" method="post" action="${pageContext.request.contextPath}/addUser">
                <table class="table table-condensed text-center ">
                    <tr>
                        <td class="field">用户名：</td>
                        <td><input type="text" class="form-control col-xs-3" name="userName" value="" required/></td>
                    </tr>
                    <tr>
                        <td class="field">密码：</td>
                        <td><input type="text" class="form-control col-xs-3" name="passWord" value="" required/></td>
                    </tr>
                    <tr>
                        <td class="field">性别：</td>
                        <td><input type="radio" name="gender" value="男" checked="checked"/>男 <input type="radio"
                                                                                                    name="gender"
                                                                                                    value="女"/>女
                        </td>
                    </tr>
                    <tr>
                        <td class="field">邮箱：</td>
                        <td><input type="text" class="form-control col-xs-3" name="email" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">手机号码：</td>
                        <td><input type="text" class="form-control col-xs-3" name="phone" value=""/></td>
                    </tr>
                    <tr>
                        <td class="field">送货地址：</td>
                        <td><input type="text" class="form-control col-xs-3" name="address" value=""/></td>
                    </tr>

                    <tr>
                        <td><input class="btn btn-default active" type="submit" name="submit" value="添加"/></td>
                        <td>
                            <a href="${pageContext.request.contextPath}/UserManage">
                                <input class="btn btn-default active" type="button" value="返回">
                            </a>
                        </td>
                    </tr>
                </table>
            </form>

        </div>
        <div class="col-md-2 column">
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





