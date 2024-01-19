package com.example.webbookmanager;

import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        if (session.getAttribute("name") != null) {
            // String isbn = "9784844336778";//後で変える
            //bookBean book = GoogleBooksAPI.searchISBN(isbn);
            //request.setAttribute("book", book);
            String path = "/WEB-INF/view/detail.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(path);
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(""); // indexへ
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //DBに登録する処理を書く

    }
}
