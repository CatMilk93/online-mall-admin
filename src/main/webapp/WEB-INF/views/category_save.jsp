<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加分类</title>
</head>
<body>

<h4>添加分类</h4>


<form action="/background/saveCategory" method="post">
    <tr>
        <td>分类名称</td>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <td><input type="submit" value="添加"></td>
    </tr>
</form>


</body>
</html>
