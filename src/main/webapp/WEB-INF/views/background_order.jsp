<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
</head>
<body>

<jsp:include page="header.jsp"/>
<br/><br/>

<table>
    <tr>
        <td>订单ID</td>
        <td>订单状态</td>
        <td>用户名</td>
        <td>订单创建时间</td>
        <td>订单最后修改时间</td>
        <td>订单详情</td>
        <td>操作-修改状态</td>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>${order.id}</td>
            <td>${order.status.desc}</td>
            <td>${order.username}</td>
            <td>${order.createTime}</td>
            <td>${order.updateTime}</td>
            <td><a href="/background/order_item?id=${order.id}&username=${order.username}">订单详情</a></td>
            <td><a href="/background/updateOrderEntry?id=${order.id}">修改订单状态</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/background/order?page=${nextPage}"><h5>下一页</h5></a>

</body>
</html>
