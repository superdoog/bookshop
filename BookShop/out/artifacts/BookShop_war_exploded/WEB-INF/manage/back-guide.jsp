<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="container clearfix ">
    <div class="col-md-12 column">
        <nav class="navbar navbar-default" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1"><span
                        class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                        class="icon-bar"></span><span class="icon-bar"></span></button>
                <labela class="navbar-brand "><font color="#333333">图书销售系统后台</font></labela>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="${pageContext.request.contextPath}/UserManage"><font color="#333333">用户管理</font></a></li>
                    <li><a href="${pageContext.request.contextPath}/BookManage"><font color="#333333">商品管理</font></a></li>
                    <li><a href="${pageContext.request.contextPath}/OrderManage"><font color="#333333">订单管理</font></a></li>
                </ul>

                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${pageContext.request.contextPath}/"><font color="#333333">退出</font></a></li>
                </ul>
            </div>
        </nav>
    </div>
</div>
