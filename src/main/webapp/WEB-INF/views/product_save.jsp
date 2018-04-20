<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>

<h4>添加商品</h4>

<table>
<form action="/background/saveProduct" method="post">
    <tr>
        <td>商品名称</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td>商品价格</td>
        <td><input type="text" name="price"></td>
    </tr>
    <tr>
        <td>是否热门</td>
        <td><select name="hot">
            <option value="1">是</option>
            <option value="0">否</option>
        </select></td>
    </tr>
    <tr>
        <td>商品所属分类</td>
        <td><select name="categoryId">
            <c:forEach var="category" items="${categories}">
                <option value="${category.id}">${category.name}</option>
            </c:forEach>
        </select></td>
    </tr>
    <tr>
        <td>是否在线</td>
        <td><select name="available">
            <option value="1">是</option>
            <option value="0">否</option>
        </select></td>
    </tr>
    <tr>
        <td><input type="submit" value="添加"></td>
    </tr>
</form>
</table>

</body>
</html>
