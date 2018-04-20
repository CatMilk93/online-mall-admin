<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>

用户名：${username}<br>
订单ID：${id}<br><br>

<table>
    <tr>
        <td>商品名称</td>
        <td>商品售价</td>
        <td>购买数量</td>
    </tr>
    <c:forEach var="orderItemView" items="${orderItemViews}">
        <tr>
            <td>${orderItemView.product.name}</td>
            <td>${orderItemView.product.price}</td>
            <td>${orderItemView.number}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
