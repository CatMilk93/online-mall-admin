<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改订单状态</title>
</head>
<body>

<table>
    <form action="/background/updateOrder?id=${id}" method="post">
        <tr>
            <td>订单状态</td>
            <td><select name="status">
                <option value="0">未付款</option>
                <option value="1">已支付</option>
                <option value="2">已发货</option>
                <option value="3">已收货</option>
            </select></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </form>
</table>


</body>
</html>
