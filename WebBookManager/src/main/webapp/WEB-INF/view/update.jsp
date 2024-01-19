<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2024/01/08
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新フォーム</title>
    <link rel="stylesheet" type="text/css" href="update.css">
</head>
<body>
<h1>更新フォーム</h1>

<form action="updateServlet" method="post">
    <p>現在のID:<input type="text" name="id"></p>
    <p>新しい名前:<input type="text" name="name"></p>
    <p>新しいパスワード:<input type="password" name="pw"></p>

    <input type="submit" value="更新">
</form>
</body>
</html>