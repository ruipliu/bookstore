<%--
  Created by IntelliJ IDEA.
  User: Liu Ruiping
  Date: 12/8/2019
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" pageEncoding="UTF-8" %>
<html>
<form action="${pageContext.request.contextPath}/CategoryServlet?method=add" method="post">

    分类名称：<input type="text" name="name"><br>
    分类描述：<textarea name="description"></textarea><br>
    <input type="submit" value="提交">
</form>
</html>
