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
    <label for="proName">商品名称</label>
    <input type="text" id="proName" name="proId" maxLength="50"/>
    <label for="proPrice">商品价格</label>
    <input type="text" id="proPrice" name="proPrice" maxLength="50"/>
    <label for="proInventory">商品库存</label>
    <input type="text" id="proInventory" name="proPrice" maxLength="50"/>
    <input type="submit" value="添加"/>
</form>

</body>
</html>