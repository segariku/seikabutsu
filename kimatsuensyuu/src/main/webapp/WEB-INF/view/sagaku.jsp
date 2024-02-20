<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2024/02/11
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <link href="money.css" rel="stylesheet">
    <title>差額表示</title>
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
<%
    int sagaku = (int) request.getAttribute("sagaku");
    if (sagaku <= 0){
%>
<h2>目標達成です!!! おめでとうございます!!!</h2>
</div>
<%
} else if(sagaku <= 10000){
%>
<h2>差額は <%= sagaku %>円です</h2>
<h4>目標金額はもう目の前です！！頑張りましょう！！</h4>
<%
} else if(sagaku <= 30000) {
%>
<h2>差額は <%= sagaku %>円です</h2>
<h4>目標金額までもう少しです！このまま頑張りましょう！</h4>
<%
} else if (sagaku <= 50000) {
%>
<h2>差額は <%= sagaku %>円です</h2>
<h4>順調に目標に近づいています。この調子で頑張りましょう</h4>
<%
} else {
%>
<h2>差額は <%= sagaku %>円です</h2>
<h4>目標金額までコツコツ貯めていきましょう</h4>
<%
    }
%>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>
