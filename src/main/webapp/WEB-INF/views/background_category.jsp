<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>分类管理</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<br/><br/>
<a href="/background/saveCategoryEnter">添加分类</a>

<table>
    <tr>
        <td>编号</td>
        <td>分类名称</td>
        <td>操作-修改</td>
        <td>操作-删除</td>
    </tr>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.name}</td>
            <td><a href="/background/updateCategoryEntry?id=${category.id}">修改</a></td>
            <td><a href="/background/deleteCategory?id=${category.id}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/background/category?page=${nextPage}"><h5>下一页</h5></a>


</body>
</html>
