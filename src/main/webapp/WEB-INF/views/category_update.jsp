<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改分类名称</title>
</head>
<body>

<h4>修改分类名称</h4>

<form action="/background/updateCategory?id=${id}" method="post">
    <tr>
        <td>修改分类名称</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td><input type="submit" value="修改"></td>
    </tr>
</form>

</body>
</html>
