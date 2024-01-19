<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2023/11/21
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

  <title>新規会員登録</title>
  <link rel="stylesheet" type="text/css" href="register.css">
</head>
<body>
<h1>登録フォーム</h1>

<form action="RegisterServlet" method="post">
  <p>ID:<input type="text" name="id"></p>
  <p>Name:<input type="text" name="name"></p>
  <p>PW:<input type="password" name="pw"></p>

  <input type="submit" value="登録">
</form>

</body>
</html>
