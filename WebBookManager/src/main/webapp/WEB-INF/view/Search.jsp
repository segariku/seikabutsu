<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2023/12/11
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="HomeServlet">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="HomeServlet">書籍検索</a>
                </li>

            </ul>

        </div>
    </div>
</nav>

<%--検索バー--%>
<div class="container">
    <h1 class="pt-5 pb-3">書籍検索</h1>
    <div class="input-group mb-3">
        <input id="formText" type="text" class="form-control" placeholder="検索したい書籍情報を入力してください。" aria-label="Recipient's username" aria-describedby="button-addon2">
        <button id="btn" class="col-2 btn btn-outline-secondary" type="button" id="button-addon2">検索</button>
    </div>
</div>

<%--検索結果出力--%>
<div class="album py-5">
    <div class="container">
        <div id="bookItem" class="row">
            <%-- ここに検索結果をJSから追加--%>
            <%-- 検索は最大10件--%>
        </div>
    </div>
</div>

<script src="GoogleBooksAPI.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
