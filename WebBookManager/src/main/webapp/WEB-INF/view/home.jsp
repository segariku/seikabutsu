<%@ page import="utils.bookBean" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: rikut
  Date: 2023/11/20
  Time: 9:41
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

      </li>
      <li class="nav-item">
        <a class="nav-link" href="SearchServlet">書籍検索</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" href="SignoutServlet">サインアウトはこちら</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="updateServlet">ユーザー情報の更新はこちら</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="BookDeleteServlet">登録している書籍の削除はこちら</a>
      </li>
    </ul>

  </div>
</nav>
<div class="container">
<h1 class="my-5">HOME</h1>

<% String name = (String) session.getAttribute("name"); %>
<p>ようこそ、<%= name %>さん</p>

<ul id="book_list">
  <%-- JavaScriptの処理でここに追加される --%>
</ul>
</div>



<script>
  // ページが読み込まれたら
  window.onload = async => {
    // リクエストスコープから受け取り
    isbn_list = <%= (ArrayList<String>) request.getAttribute("isbn_list") %>;

    const book_list = document.getElementById("book_list")
    // 配列から一つずつ取り出す
    isbn_list.forEach( function (isbn) {
      // 検索処理
      book_search(isbn).then(function (data) {
        const make_element = document.createElement("li");
        make_element.setAttribute("id", data[0]);
        book_list.appendChild(make_element);

        const book_item = document.getElementById(data[0]);

        const book_add_item =
                "<li>" +
                "<img src='" + data[1] + "'>" +
                "<p>" + data[0] + "</p>" +
                "</li>";

        book_item.innerHTML= book_add_item;
      })
    })
  }

  async function book_search(isbn) {
    const res = await fetch(`https://www.googleapis.com/books/v1/volumes?q=isbn:` + isbn);
    const data = await res.json();

    const title = data.items[0].volumeInfo.title;
    const imageUrl = data.items[0].volumeInfo.imageLinks.thumbnail;

    return [title, imageUrl]
  }

</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

</body>
</html>
