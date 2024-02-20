<%@ page import="java.util.List" %>
<%@ page import="util.moneyBean" %><%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2024/02/07
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="home.css" rel="stylesheet">
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="SignoutServlet">サインアウト</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MoneyServlet">金額計算</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MoneyRegisterServlet">差額登録</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MoneyUpdateServlet">差額更新</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h1 class="my-5">HOME</h1>

    <% String name = (String) session.getAttribute("name"); %>
    <p>ようこそ、<%= name %>さん</p>

    <%
        List<moneyBean> moneyBeanList = (List<moneyBean>) request.getAttribute("moneyBeanList");
        for (moneyBean money : moneyBeanList) {
            if (money.getUser_id() == (int) session.getAttribute("user_id")) {
    %>
    <p>現在の差額は <%= money.getMoney() %>円です。</p>
    <%
            }
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>