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

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1>恭喜：购买成功！</h1>
                </div>
                <div class="panel-body">
                    <h3>正在进入首页...</h3>
                    <script type="text/javascript">
                        setTimeout("location.href= $(\"#path\").val() +'/index'", 3000);
                    </script>
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
