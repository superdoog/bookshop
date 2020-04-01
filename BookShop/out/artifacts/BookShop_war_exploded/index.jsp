<%--
  Created by IntelliJ IDEA.
  User: lv
  Date: 2020/3/26
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$


  <form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
    <label>头 像</label><input type="file" name="img"/><br/>
    <input type="submit" value="提  交"/>
  </form>
  </body>
</html>
