<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<%
    pageContext.setAttribute("APP_PATH",request.getContextPath());
%>
<head>
    <title>首页</title>
    <script type="text/javascript" src="/static/js/jquery-3.3.1.min.js"></script>
    <meta charset="utf-8">
</head>
<body>
<form action="${APP_PATH}/product/inquireProductById" method="post">
    <label for="proId">商品Id</label>
    <input type="text" id="proId" name="proId" maxLength="50"/>
    <input type="submit" value="查询"/>
</form>

</body>
</html>