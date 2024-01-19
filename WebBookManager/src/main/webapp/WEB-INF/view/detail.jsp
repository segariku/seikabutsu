<%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2023/12/11
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

    <title>Title</title>
</head>
<body>
<nav class="navbar navbar-expand-lg" >
    <div class="container-fluid">
        <a class="navbar-brand" href="HomeServlet">Navbar</a>
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="HomeServlet">Home</a>
            </li>

            <li class="nav-item">
                <a class="nav-link " href="SearchServlet">書籍検索</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container h-100">
  <div class="row h-100">
    <div class="col-6 h-100 text-center pt-5" ><%--　左:画像　--%>
    <img id="bookImage" style="width: 60%; height: 75%;" src="http://books.google.com/books/content?id=FQKOBAAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api">
    </div>
    <div class="col-6 h-100 px-5 pt-5" ><%--　右:書籍紹介--%>
        <h3 id="bookTitle" style="border-bottom: 1px solid black">Title</h3>
        <p id="bookDesc">書籍の詳細です。</p>

        <a class="btn btn-primary col-12" href="BookRegisterServlet?isbn=<%= request.getParameter("isbn")%>">登録</a>
    </div>
  </div>
</div>


<script>
    //画面が読み込まれたら
    window.onload = async () => {
        const isbn = <%= request.getParameter("isbn")%>

        const res = await fetch(`https://www.googleapis.com/books/v1/volumes?q=isbn:` + isbn);
        const data = await res.json();

        const title = data.items[0].volumeInfo.title;
        const desc = data.items[0].volumeInfo.description;
        const imageUrl = data.items[0].volumeInfo.imageLinks.thumbnail;

        document.getElementById("bookTitle").innerText = title;
        document.getElementById("bookDesc").innerText = desc;
        document.getElementById("bookImage").src = imageUrl;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</body>
</html>

