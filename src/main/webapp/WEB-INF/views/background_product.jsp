<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品管理</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<br/><br/>
<a href="/background/saveProductEnter">添加商品</a>

<table>
    <tr>
        <td>编号</td>
        <td>商品名称</td>
        <td>商品售价</td>
        <td>类别</td>
        <td>是否热门</td>
        <td>是否在售</td>
        <td>上线时间</td>
        <td>最后修改时间</td>
        <td>操作-修改</td>
        <td>操作-删除</td>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.categoryId}</td>
            <td>
                <c:choose>
                    <c:when test="${product.hot}">
                        是
                    </c:when>
                    <c:otherwise>
                        否
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${product.available}">
                        是
                    </c:when>
                    <c:otherwise>
                        否
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${product.createTime}</td>
            <td>${product.updateTime}</td>
            <td><a href="/background/updateProductEntry?id=${product.id}">修改</a></td>
            <td><a href="/background/deleteProduct?id=${product.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/background/product?page=${nextPage}"><h5>下一页</h5></a>


</body>
</html>
