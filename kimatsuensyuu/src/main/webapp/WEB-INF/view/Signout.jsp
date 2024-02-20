<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2024/02/11
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>サインアウト</title>
    <link href="form.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
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
                    <a class="nav-link active" aria-current="page" href="HomeServlet">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="SignoutServlet">サインアウト</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="MoneyServlet">金額計算</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<h1>サインアウトページへようこそ</h1>
<p>※サインアウトをした場合はログインページに戻ります</p>
<form action="SignoutServlet" method="post">
<button class="btn-bd-primary" type="submit">サインアウト</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
