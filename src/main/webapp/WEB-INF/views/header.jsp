<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<c:choose>
    <c:when test="${empty name}">
        <a href="/login">登录</a>
    </c:when>
    <c:otherwise>
        ${name}
        <a href="/background/logout">退出</a>
    </c:otherwise>
</c:choose>

<h2><a href="/background">后台管理系统</a></h2>

<a href="/background/category">分类管理</a>
<a href="/background/product">商品管理</a>
<a href="/background/order">订单管理</a>